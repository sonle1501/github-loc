# Tài liệu phát triển phần mềm (Software Development Notes)

## Về tài liệu này
Đây là nhật ký ghi lại các ý tưởng và cách giải quyết các bài toán trong quá trình xây dựng dự án `github-loc`. Đối với các hướng dẫn sử dụng dòng lệnh chi tiết, có thể tham khảo thêm tại tài liệu [commands.md](./commands.md) và hướng dẫn cài đặt tại [setup.md](./setup.md).

---

## Mục tiêu (Goal)

### Tại sao lại làm github-loc
* **Khác biệt với công cụ online - True SLOC**: Các công cụ trực tuyến phổ biến (như `ghloc` hay `codetabs`) thường chỉ đếm số dòng văn bản thô (bao gồm cả comments). `github-loc` hướng tới việc tính toán chính xác số dòng code thực tế (Source Lines of Code - SLOC), dòng chú thích (Comments), và dòng trống (Blank Lines).
* **Hỗ trợ private (Private Repositories)**: Nếu người dùng cung cấp personal access tokens, github-loc có thể để phân tích các private repo
* **Phân tích hàng loạt (User Mode)**: Cho phép quét và thống kê toàn bộ các kho lưu trữ công khai của một tài khoản GitHub cụ thể chỉ bằng một câu lệnh duy nhất.
* **Định dạng JSON**: Xuất kết quả ra JSON, có thể dùng để sử dụng bởi các mục đich khác (ví dụ trực quan hóa dữ liệu dưới dạng cây bằng javascript...)
---

## Kế hoạch triển khai (Plan)

### Proof of Concept - POC
Liệu có thể gọi API của GitHub tải file nén của repo về máy nội bộ rồi giải nén và tiến hành phân tích offline một cách nhanh chóng không ?
* Tải xuống từ GitHub: Sử dụng HTTP Client để tải xuống file ZIP qua API `/zipball` của GitHub

Làm cách nào để đếm số dòng code (SLOC) một cách chính xác ?
* Tích hợp 1 thư viện đếm bên ngoài `locc4j` vào ngay trong mã nguồn qua giấy phép Apache License

---

## Kiến trúc & Công nghệ (Architecture & Tech Stack)

* **Maven, Java 17**: Dự án sử dụng Maven và Java 17 làm ngôn ngữ lập trình để tận dụng các tính năng hiện đại (như Java Records , Switch Expressions...).
* **Jackson (JSON Processor)**: Sử dụng các thư viện `jackson-databind` và `jackson-core` để chuyển đổi cấu trúc cây dữ liệu phức tạp thành định dạng JSON và ghi ra file báo cáo. Đã migrate từ Jackson 2 lên Jackson 3 cho thư viện `locc4j`
* **Logback & SLF4J**: Tăng hiệu năng (performance) cho việc logging, đồng thời giúp người dùng CLI theo dõi trạng thái của công cụ mà không bị rối mắt bởi các stack trace lỗi thô.
* **Lombok**: Sử dụng các annotation `@Getter`, `@Setter`, và `@Slf4j` giúp mã nguồn gọn gàng, giảm thiểu các dòng mã lặp đi lặp lại.
* **JUnit 5 & Mockito**: Unit test và Mock testing
  
---

## Thiết kế phần mềm (Software Design)

Dưới đây là cách triển khai các tính năng và giải quyết các bài toán kỹ thuật cụ thể:

### 1. Tải dữ liệu repository từ GitHub API (Download Repository)
Diễn ra tại [RepoDownloader.java](../src/main/java/dev/sonle/githubloc/api/RepoDownloader.java)

#### Gửi request đến GitHub API
* Gửi request HTTP GET kèm theo GitHub Token (nếu có) trong header.
* Cấu hình `.followRedirects(HttpClient.Redirect.ALWAYS)` để tự động xử lý chuyển hướng (HTTP Redirect - 307) từ GitHub API sang máy chủ CDN chứa file zip thực tế.
* Nhờ việc cấu hình token GitHub (nếu cung cấp) trong [GithubTokenProcessor.java](../src/main/java/dev/sonle/githubloc/api/GithubTokenProcessor.java) mà có thể tăng rate limit và cho phép tải các private repository.

#### Stream Writing
* Thiết lập kết nối stream, HttpClient sẽ mở một kết nối socket TCP tới server (qua TLS/HTTPS) ở hàm `makeRequest`
* Client gửi http request, nếu server phản hồi thành công (200 OK) thì Java sẽ khởi tạo một HttpResponse với body là một InputStream nhưng chưa rót dữ liệu vào ổ đĩa
* Tại hàm `locateRepo` dữ liệu mới chính thức được rót từ mạng vào RAM xong ghi xuống ổ đĩa
* Chunking: 8 KB

---

### 2. Giải nén an toàn & Chống lỗ hổng Zip Slip (Unzip)

* Việc giải nén file ZIP được thực hiện trong [Unzip.java](../src/main/java/dev/sonle/githubloc/filesystem/Unzip.java) bằng cách sử dụng `ZipInputStream` để đọc qua từng `ZipEntry`.
* **Phòng chống lỗ hổng Zip Slip**: Lỗ hổng Zip Slip xảy ra khi một file ZIP chứa các entry có tên dạng `../../malicious.sh` nhằm ghi đè các file hệ thống ngoài thư mục đích. Để ngăn chặn, hệ thống thực hiện giải quyết đường dẫn tuyệt đối bằng `normalize()` và kiểm tra tiền tố đường dẫn:
  ```java
  Path resolvedDestPath = targetDir.resolve(entry.getName()).normalize();
  if (!resolvedDestPath.startsWith(targetDir)) {
      throw new GithubLocException(ErrorCode.FILE_PROCESSING_ERROR, "Entry is outside of the target dir: " + entry.getName());
  }
  ```
  
---

### 3. Xây dựng cấu trúc cây thư mục (Directory Tree Model)

* Cấu trúc thư mục được mô hình hóa bằng lớp [Tree.java](../src/main/java/dev/sonle/githubloc/tree/Tree.java) và các nút đại diện [FileNode.java](../src/main/java/dev/sonle/githubloc/tree/FileNode.java).
* Mỗi `FileNode` lưu trữ:
  * Thông tin cơ bản: tên file/thư mục, đường dẫn vật lý, nút cha (`parent`) và danh sách các nút con (`childs`).
  * Chỉ số thống kê: số dòng code (`loc`), số dòng bình luận (`comments`), số dòng trống (`blanks`).
  * Bản đồ phân loại ngôn ngữ: tập hợp ngôn ngữ được sử dụng (`languageSet`) và số dòng code tương ứng với từng ngôn ngữ lập trình (`locByLang`).
* **Cơ chế cộng dồn (Roll-up)**: Khi đếm xong LOC cho các file lá (các file thực tế), hệ thống thực hiện hàm đệ quy `countLocFolder` trong [DirectoryLocProcessor.java](../src/main/java/dev/sonle/githubloc/loc/DirectoryLocProcessor.java) để cộng dồn các thông số LOC, Comments, Blanks và gộp (merge) bản đồ ngôn ngữ từ các file con lên các thư mục cha và cuối cùng là thư mục gốc.

---

### 4. Đa luồng với Batch Processing khi xử lý 1 repo
* Luồng chính duyệt qua cấu trúc đĩa bằng [DirectoryBuilder.java](../src/main/java/dev/sonle/githubloc/filesystem/DirectoryBuilder.java) cực kỳ nhanh vì chỉ xây dựng khung cây thư mục thô (chứ chưa tính LOC)
* Trong lúc duyệt, lưu tất cả các file vào 1 list nhằm làm phẳng (cây thư mục thì có thứ tự, quan hệ cha-con)
* Đa luồng theo lô: Đếm tại [DirectoryLocProcessor.java](../src/main/java/dev/sonle/githubloc/loc/DirectoryLocProcessor.java)
* Đầu tiên khởi tạo một pool có tối đa `cores * 8` luồng (giả sử cho cores = 4, thì luồng tối đa trong pool là 32)
* Khởi tạo batchSize = cores, mỗi lô sẽ xử lý 4 file (nếu cores = 4)

*Ví dụ Đếm 1 repo có 18 file*: Hệ thống tạo 5 lô (tức là 5 threads, mỗi thread xử lý 1 lô). Lô đầu tiên đếm 2 file dư ra, mỗi lô còn lại đếm 4 file

#### Kết quả đo lường hiệu năng (Benchmark với repo Elasticsearch ~6M LOC)
| Thuật toán | Điểm số (Thời gian trung bình - ms/op) | Độ tin cậy (Sai số) |
| :--- | :---: | :---: |
| `Sequential` (Tuần tự) | **15530.40 ms** | ± 297.93 ms |
| `Batch Processing` (Chia lô) | **4074.86 ms** | ± 373.23 ms |
| `Producer-Consumer` (Đa luồng không chia lô) | **3412.35 ms** | ± 110.31 ms |

---

### 5. Quy trình bất đồng bộ & Phân chia luồng xử lý (Asynchronous Workflow & Separated Executor)

Khi người dùng chạy chương trình ở chế độ quét toàn bộ dự án của một User (`Mode.USER`), hệ thống cần tải xuống, giải nén và xử lý song song hàng chục repository khác nhau. Để cải thiện hiệu năng, [MultithreadingReposHandle.java](../src/main/java/dev/sonle/githubloc/multirepos/MultithreadingReposHandle.java) triển khai pipeline đa luồng kèm theo bất đồng bộ sử dụng `CompletableFuture`:

$$\text{Tải xuống (I/O Bound)} \xrightarrow{\text{Async}} \text{Giải nén (I/O Bound)} \xrightarrow{\text{Async}} \text{Đếm LOC (CPU Bound)} \xrightarrow{\text{Async}} \text{Xuất báo cáo JSON (CPU Bound)}$$

#### IO và CPU
Để tối ưu hóa tài nguyên phần cứng, hệ thống sử dụng hai loại Thread Pool riêng biệt:
1. **ioExecutor (Cached Thread Pool)**:
   * Sử dụng `Executors.newCachedThreadPool()` cho các tác vụ Tải xuống (`runSingleDownload`) và Giải nén (`runSingleUnzip`).
   * *Lý do*: Tác vụ I/O bound phần lớn thời gian là chờ phản hồi từ mạng hoặc tốc độ đọc/ghi của ổ đĩa. Cached Thread Pool cho phép tạo thêm luồng mới khi cần để thực hiện tải đồng thời nhiều repo, giúp tăng băng thông mạng mà không bị giới hạn cứng.
2. **cpuExecutor (Fixed Thread Pool)**:
   * Sử dụng `Executors.newFixedThreadPool(cores)` với số lượng luồng bằng đúng số nhân CPU cho các tác vụ Xây dựng cây thư mục, Tính toán LOC (`runSingleJsonProcess`).
   * *Lý do*: Tác vụ CPU bound sử dụng hết công suất của nhân CPU để tính toán văn bản. Việc giới hạn số luồng bằng số nhân CPU giúp giảm thiểu tranh chấp lõi CPU, loại bỏ tình trạng quá tải context switching của hệ điều hành.

#### Giải thích quá trình chạy bất đồng bộ qua task donwload
* Luồng chính khi nhận task download, nó không cần đợi Repo A tải xong. Nó chỉ cần ném tác vụ đó vào ioExecutor rồi ngay lập tức làm việc khác, như ném tiếp các task tải Repo B, Repo C...
* Đối với luồng chính, tiến trình này là Non-blocking.
* Các luồng con trong pool thì vẫn giữ và làm task donwload (bị block rồi), khi làm xong có thể nhanh chóng nhảy sang các task donwload khác
* Giả sử có 1 task download mà tất cả các luồng trong Pool đều đang bận (hoặc chưa có luồng nào được tạo trước đó), Pool mới tạo ra 1 luồng mới để gánh task này.
---

### 6. Tích hợp bộ đếm dòng code (locc4j Engine)

* `github-loc` phân tích cú pháp code trực tiếp thông qua gói [locc4j](../src/main/java/dev/sonle/githubloc/locc4j).
* Lớp [Language.java](../src/main/java/dev/sonle/githubloc/locc4j/Language.java) định nghĩa cấu trúc của hơn 100 ngôn ngữ lập trình phổ biến (tiền tố mở rộng `.java`, `.py`, `.cpp`, `.js`...).
* Lớp [FileCounter.java](../src/main/java/dev/sonle/githubloc/locc4j/FileCounter.java) mở luồng đọc file và sử dụng:
  * [BlockDelimiter.java](../src/main/java/dev/sonle/githubloc/locc4j/BlockDelimiter.java) để xác định ranh giới giữa code và các bình luận khối (ví dụ: `/* ... */` trong C-style, `""" ... """` trong Python).
  * [CharData.java](../src/main/java/dev/sonle/githubloc/locc4j/CharData.java) để phân tích từng ký tự trên một dòng nhằm phân loại dòng đó là dòng code thực thi, dòng comment đơn hay dòng trống.

---

### 7. Cơ chế sắp xếp và thống kê ngôn ngữ (Sorting & Statistics Algorithms)

Sau khi tính toán xong cây thư mục, nếu người dùng chạy hành động `SORT`, [RepoSorter.java](../src/main/java/dev/sonle/githubloc/sort/RepoSorter.java) phối hợp với [FilesSorter.java](../src/main/java/dev/sonle/githubloc/sort/FilesSorter.java) sẽ lọc và xếp hạng dữ liệu:

* **Sắp xếp theo LOC (Hành động SORT mặc định)**: Lọc ra toàn bộ các file lá trong dự án, sắp xếp chúng theo số dòng code giảm dần sử dụng `Comparator` tùy biến.
* **Gom nhóm theo ngôn ngữ (SORT BYLANG)**:
  * Lấy danh sách ngôn ngữ lập trình được sử dụng, sắp xếp các ngôn ngữ này theo tổng số dòng code giảm dần.
  * Phân loại toàn bộ các file code vào từng nhóm ngôn ngữ tương ứng, trong mỗi nhóm các file lại được sắp xếp theo số dòng code giảm dần.
* **Sắp xếp theo ngôn ngữ phổ biến nhất (SORT BYMOSTLANG)**:
  * Xác định ngôn ngữ có tổng số dòng code cao nhất trong toàn bộ repository bằng phương thức `getMostUsedLanguage` trong `DirectoryLocProcessor`.
  * Chỉ lọc ra và sắp xếp các file code thuộc ngôn ngữ phổ biến nhất đó.
* **Tính toán phần trăm sử dụng**: Sử dụng phương thức `getPercentageUsedLanguage` để tính tỷ lệ đóng góp của từng ngôn ngữ trong dự án dựa trên công thức:
  $$\text{Tỷ lệ \%} = \frac{\text{Tổng dòng code của ngôn ngữ}}{\text{Tổng dòng code của cả dự án}} \times 100$$

---

### 8. Quản lý ngoại lệ tập trung (Exception Handling)

* **Custom Exception**: Định nghĩa lớp ngoại lệ [GithubLocException.java](../src/main/java/dev/sonle/githubloc/exception/GithubLocException.java) kế thừa từ `RuntimeException`. Lớp này bọc các thông tin lỗi thô và liên kết với một [ErrorCode.java](../src/main/java/dev/sonle/githubloc/exception/ErrorCode.java) cụ thể.
* **ErrorCode Enum**: Chuẩn hóa toàn bộ các lỗi có thể xảy ra trong hệ thống và định nghĩa mã thoát (Exit Code) tương ứng cho ứng dụng CLI:
  * `INTERRUPTED` (Exit Code 1): Tiến trình bị ngắt giữa chừng.
  * `REPO_DOWNLOAD_FAILED` (Exit Code 2): Tải file zip từ GitHub thất bại.
  * `UNEXPECTED_ERROR` (Exit Code 3): Lỗi không xác định.
  * `INVALID_INPUT` (Exit Code 4): Đối số đầu vào không hợp lệ.
  * `FILE_PROCESSING_ERROR` (Exit Code 5): Lỗi đọc/ghi file hoặc Zip Slip.
  * `REPO_TREE_CREATION_FAILED` (Exit Code 6): Lỗi duyệt thư mục và dựng cây.
  * `GITHUB_API_ERROR` (Exit Code 7): GitHub API trả về mã lỗi đặc biệt (User không tồn tại...).
  * `JSON_PROCESSING_ERROR` (Exit Code 8): Lỗi phân tích cú pháp hoặc ghi file JSON.
* **Fail-Fast & Exit Handler**: Ở phương thức `main` của [App.java](../src/main/java/dev/sonle/githubloc/App.java), toàn bộ ngoại lệ được bắt lại. Chương trình sẽ ghi log mô tả lỗi thân thiện kèm theo mã thoát tương ứng và kết thúc bằng `System.exit(code)`, ngăn chặn việc ném ra stack trace thô gây bối rối cho người sử dụng CLI.

---

### 10. Các giải pháp kỹ thuật khác

* **Interactive Mode (Chế độ tương tác)**: Khi khởi chạy ứng dụng mà không truyền bất kỳ đối số nào, [CliParser.java](../src/main/java/dev/sonle/githubloc/execution/CliParser.java) sẽ khởi chạy chế độ tương tác, sử dụng `Scanner` để hướng dẫn người dùng nhập tham số mục tiêu từng bước một cách dễ dàng.
* **Size Formatter**: Tích hợp [SizeFormatter.java](../src/main/java/dev/sonle/githubloc/filesystem/SizeFormatter.java) tự động chuyển đổi kích thước byte thô sang các đơn vị đọc được (B, KB, MB, GB) để hiển thị thông tin tải xuống và giải nén trực quan trên console.
* **Console Tree Rendering**: Sử dụng [TreePrinter.java](../src/main/java/dev/sonle/githubloc/output/TreePrinter.java) để in cấu trúc cây thư mục trực quan trực tiếp ra màn hình dòng lệnh với các ký tự vẽ nhánh chuyên dụng (`├──`, `└──`), kết hợp hiển thị thông tin LOC và ngôn ngữ lập trình của từng file/thư mục.

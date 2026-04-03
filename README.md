# GitHub LOC Counter

A powerful command-line tool designed to analyze GitHub repositories and local directories, accurately counting Lines of Code (LOC), determining programming languages for each file, and visualizing repository structures.

## 1. Introduction: Tools & Features

- **Process Repository**

Process any public GitHub repository or private repository (token required for private). This tool counts exact lines of code using **SLOC (Source Lines of Code)**, provides higher precision than standard LOC counting engines on GitHub or some counting LOC websites like codetabs, ghloc. 

The tool also calculates comments and blank lines. At the end of the analysis, it prints a convenient repository tree-directory hierarchy directly to your console and generates a JSON result.

*Example command:*

```bash
<command> : spring-projects/spring-boot
```

- **Process Multiple Repositories (User Mode)**

Analyze and process all public repositories belonging to a specific GitHub user in one go

*Example command:*

```bash
<command> : sonle1501
```

- **Sort Files by LOC**

Organize and sort repository files by LOC. The tool can intelligently group files by their programming language and sort them, helping analyze repositories by presenting modules with the most used language and files with the highest LOC first.

```bash
<command> : sonle1501/github-loc -a sort bylang
```

## 2. Usage

There are two primary options for running this application:

**Option 1: Using Java 17 and Maven**

1. Ensure you have Java 17+ and Maven installed on your machine.
2. Clone the repository and navigate into the folder:
   ```bash
   git clone https://github.com/sonle1501/github-loc.git
   cd github-loc
   ```
3. Build the project using Maven:
   ```bash
   mvn clean package
   ```
4. Run the generated `.jar` file:
   ```bash
   java -jar target/githubloc-1.0.jar <your-command>
   ```

**Option 2: Ready-made Executable (.exe) for Windows**

1. Navigate to the **Releases** section of this GitHub repository.
2. Download the latest `.zip` release.
3. Unzip the downloaded file to your desired location.
4. Run the `.exe` directly or open your command prompt/PowerShell and run without needing Java or Maven installed:
   ```bash
   ./github-loc.exe <your-command>
   ```

- Note: If using Linux, see the tar.gz artifact in the Releases section

## 3. Command Guide

General command syntax operates via different **Modes**, **Actions**, and an optional **SortArgument**.

### Mode

Defines what target structure the app should analyze.

| Name | Format | What does it do ? | Example |
|------|--------|--------------------------|---------|
| `REPO` | `<user>/<repo>` | Targets a single Github repository | `numpy/numpy` |
| `USER` | `<user>` | Targets every repository from a specific GitHub user | `sonle1501` |
| `LOCAL`| `LOCAL <repo>` | Analyzes a locally stored project/directory. **Note:** the repo must already exist at `storage/repos/` to trigger this mode. | `LOCAL github-loc` |

### Action Arguments (`-a` or `--action`)

Defines what processing steps the application executes on the designated target. Defaults to `DEFAULT`.

| Name | Format | What does it do (short)? | Example |
|------|--------|--------------------------|---------|
| `DEFAULT` | *(No argument)* | Downloads, unzips, exports repo to JSON, and prints tree to console | `facebook/react` |
| `JSON` | `-a json` | Only exports the repository tree directly to a JSON file | `facebook/react -a json` |
| `TREE` | `-a tree` | Only shows the project's tree view in the console, no JSON export | `facebook/react -a tree` |
| `SORT` | `-a sort` | Shows and exports the file list, sorting and ranking them by LOC | `facebook/react -a sort` |
| `DOWNLOAD` | `-a download` | Only downloads the repository as a `.zip` without expanding it | `facebook/react -a download` |
| `UNZIP` | `-a unzip` | Downloads and unzips the repository folder without outputting results| `facebook/react -a unzip` |

### Sort Arguments

If you have selected the `SORT` action, you can append an additional argument defining the sorting behavior.

| Name | Format | What does it do (short)? | Example |
|------|--------|--------------------------|---------|
| `ALL` | `ALL` or no sort argument | Sorts all listed files strictly by Lines of Code. | `facebook/react -a sort` |
| `BYLANG` | `BYLANG` | Groups the files by their programming language, then sorts them | `facebook/react -a sort BYLANG` |
| `BYMOSTLANG` | `BYMOSTLANG` | Prioritizes sorting files grouped by the most used language | `facebook/react -a sort BYMOSTLANG` |

If you run the application directly (via `java -jar` without arguments, running the main method in `App.java`, or clicking the `.exe` file), a mini-program prompt will appear asking you to type your command. Note that the default mode processes the `sonle1501/github-loc` repository (command: `sonle1501/github-loc`).

## 4. Output Storage

The tool neatly organizes its results and intermediate files within the internal `storage/` directory during execution:

- **`storage/repos/`**: Contains the unzipped, extracted repository folders.
- **`storage/zip-repos/`**: Contains the raw downloaded `.zip` repository archives.
- **`storage/json-results/`**:
  - `[REPO-NAME].json`: Contains the JSON repository tree hierarchy results.
  - `ordered-list-[REPO-NAME].json`: Orders JSON sequence outputs produced manually by a `SORT` action.
- **`storage/user-repos/`**: Contains JSON results generated during a comprehensive `USER` mode multi-repository analysis.

## 5. GitHub Token Configuration

To safely process private repositories or increase GitHub API rate limits (bypassing the basic anonymous quota limit of 60 calls/hour), you can link a GitHub Personal Access Token.

1. Log into your GitHub account and navigate to **Settings** > **Developer Settings** > **Personal access tokens** > **Fine-grained tokens** (or classic tokens).
2. Generate a new token with at least Repository 'Read-Only' permissions.
3. In your project repository environment, navigate to `src/main/resources/` and create a file named `token.properties`.
4. Apply your token to the file formatted strictly as follows:
   ```properties
   FINE_GRAINED_TOKEN=your_token_here
   ```

*(Note: Be careful to keep your token secure. Standard practice is appending `token.properties` into your `.gitignore` to prevent accidental credential leaks).*

## 6. License

This project utilizes and integrates the [locc4j](https://github.com/cthing/locc4j) counting engine.

The `github-loc` project is licensed natively under the **MIT License**. See the [LICENSE](LICENSE) for details.

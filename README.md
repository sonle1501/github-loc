# GitHub LOC Counter

A command-line tool count LOC, determine programming languages in each file and visualize GitHub repositories

This tool allows you to download and unzip repositories, view their file structure in a tree format, and export data (including lines of code, programming language) to JSON.

## Installation

### Prerequisites
- Java 17 or higher
- Maven (for building)

### Build from Source
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/github-loc.git
   ```
2. Navigate to the project directory:
   ```bash
   cd github-loc
   ```
3. Build the project:
   ```bash
   mvn clean package
   ```
   The executable jar will be located in `target/githubloc-1.0.jar`.

## Usage

Run the application using the generated JAR file:

```bash
java -jar target/githubloc-1.0.jar <user>/<repo> [options]
```

### Arguments

- `<user>/<repo>`: The GitHub repository to analyze (e.g., `spring-projects/spring-boot`).

### Options

- `-a, --action <ACTION>`: Specify the action to perform. Default is `ALL`.

| Action | Description |
|--------|-------------|
| `ALL` | Download, unzip, generate tree view, and export JSON (Default). |
| `TREE` | Download, unzip, and generate tree view. |
| `JSON` | Download, unzip, and export JSON. |
| `DOWNLOAD` | Only download the repository zip. |
| `UNZIP` | Download and unzip the repository. |

### Examples

**Analyze a repository (Default behavior):**
```bash
java -jar target/githubloc-1.0.jar cgag/loc
```

**Only download the repository:**
```bash
jjava -jar target/githubloc-1.0.jar cgag/loc -a DOWNLOAD
```

**Generate a tree view:**
```bash
java -jar target/githubloc-1.0.jar cgag/loc -a TREE
```

## Output

The tool generates output in the `work/` directory:
- `work/repos/`: Unzipped repository contents.
- `work/zip-repos/`: Downloaded zip files.
- `work/json-results/`: JSON analysis results.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

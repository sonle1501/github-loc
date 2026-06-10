# Command Guide

This guide details the command syntax, execution modes, action arguments, and sorting behaviors supported by **GitHub LOC Counter**.

---

## 1. Syntax Overview
Commands generally follow this syntax:
```bash
[TARGET] [ACTION_ARGUMENTS] [SORT_ARGUMENTS]
```
If you start the tool without arguments, an interactive terminal prompt will open to guide you.

---

## 2. Execution Modes
The target defines what repository or repository set the tool should analyze.

| Mode | Format | Description | Example |
| :--- | :--- | :--- | :--- |
| **Repository** | `<user>/<repo>` | Analyzes a single public or private GitHub repository. | `numpy/numpy` |
| **User** | `<user>` | Analyzes all public repositories belonging to a specific GitHub user. | `sonle1501` |
| **Local** | `LOCAL <repo>` | Analyzes a directory locally stored at `storage/repos/`. | `LOCAL github-loc` |

---

## 3. Action Arguments
Specify an action using the `-a` or `--action` flags to customize the workflow. (Defaults to `DEFAULT` if omitted).

| Action | Argument | Description | Example |
| :--- | :--- | :--- | :--- |
| **DEFAULT** | *(None)* | Downloads, extracts, exports JSON, and displays tree in console. | `facebook/react` |
| **JSON** | `-a json` | Exports the repository tree structure and analysis strictly to a JSON file. | `facebook/react -a json` |
| **TREE** | `-a tree` | Renders the project tree directly in the console without exporting JSON. | `facebook/react -a tree` |
| **SORT** | `-a sort` | Renders and exports file listing sorted by Lines of Code. | `facebook/react -a sort` |
| **DOWNLOAD** | `-a download` | Only downloads the repository ZIP archive (no extraction or analysis). | `facebook/react -a download` |
| **UNZIP** | `-a unzip` | Downloads and extracts the repository directory without analyzing. | `facebook/react -a unzip` |

---

## 4. Sorting Arguments
These arguments apply when using the **SORT** action (`-a sort`).

| Sort Type | Argument | Description | Example |
| :--- | :--- | :--- | :--- |
| **ALL** | `ALL` *(or blank)* | Sorts all files strictly by Lines of Code (LOC) descending. | `facebook/react -a sort` |
| **BYLANG** | `BYLANG` | Groups files by programming language, then sorts each group by LOC. | `facebook/react -a sort BYLANG` |
| **BYMOSTLANG** | `BYMOSTLANG` | Prioritizes sorting files grouped under the most dominant programming language. | `facebook/react -a sort BYMOSTLANG` |

---

## 5. Interactive Mode
If you run the application with no arguments:
- via Java JAR: `java -jar target/githubloc-1.0.jar`
- via Binary: `./github-loc.exe` (Windows) or `./github-loc` (Linux)

An interactive shell will launch:
```text
Enter repository / user / local target command (or type 'exit' to quit):
```
You can enter any of the commands listed above. The default command is `sonle1501/github-loc` if you press Enter without inputting anything.

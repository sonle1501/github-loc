# Setup Guide

This guide provides detailed instructions on how to install, build, and configure the **GitHub LOC Counter**.

---

## Prerequisites
- **For Building from Source:** Java 17+ and Maven installed.
- **For Prebuilt Binaries:** Windows OS (for `.exe`) or Linux OS (for `.tar.gz`).

---

## 1. Installation Options

### Option 1: Build from Source (Java & Maven)
1. Clone the repository and navigate to the directory:
   ```bash
   git clone https://github.com/sonle1501/github-loc.git
   cd github-loc
   ```
2. Build the project using Maven:
   ```bash
   mvn clean package
   ```
3. Run the generated `.jar` file:
   ```bash
   java -jar target/githubloc-1.0.jar <your-command>
   ```

### Option 2: Prebuilt Executables
1. Go to the **Releases** section of this GitHub repository.
2. Download the latest archive:
   - For **Windows**: Download the `.zip` archive.
   - For **Linux**: Download the `.tar.gz` archive.
3. Extract the downloaded file to your preferred directory.
4. Run the executable directly via command line:
   - **Windows:**
     ```bash
     ./github-loc.exe <your-command>
     ```
   - **Linux:**
     ```bash
     ./github-loc <your-command>
     ```

---

## 2. GitHub Token Configuration

By default, GitHub limits unauthenticated API requests to 60 per hour. Setting up a Personal Access Token (PAT) increases this rate limit and allows you to scan private repositories.

### Generating a Token
1. Go to your GitHub account settings: **Settings** > **Developer Settings** > **Personal access tokens** > **Fine-grained tokens** (or classic tokens).
2. Generate a new token with at least **Metadata: Read-only** (and **Contents: Read-only** if you want to scan private repositories).

### Applying the Token
Choose one of the following methods depending on how you run the application:

#### For Maven Builds (From Source)
Create a file named `token.properties` in `src/main/resources/` with the following content:
```properties
FINE_GRAINED_TOKEN=your_github_token_here
```

#### For Prebuilt Executables
Create a file in the same directory as the executable:
- **Option A (`token.properties`):**
  ```properties
  FINE_GRAINED_TOKEN=your_github_token_here
  ```
- **Option B (`token.txt`):**
  Write only the token string inside:
  ```text
  your_github_token_here
  ```

> [!WARNING]
> Keep your token file secure and never commit `token.properties` or `token.txt` to public version control. The repository includes these in `.gitignore` by default.

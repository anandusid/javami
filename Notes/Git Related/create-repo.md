To add your Spring Boot project to a new GitHub repository, follow these steps:

---

### 1. **Create a New Repository on GitHub**
1. Log in to [GitHub](https://github.com/).
2. Click on the `+` icon in the top-right corner and select **New repository**.
3. Provide a repository name (e.g., `spring-boot-project`).
4. Choose repository visibility (`Public` or `Private`).
5. (Optional) Add a description.
6. Click **Create repository**.

---

### 2. **Initialize Git in Your Project**
1. Open a terminal or command prompt in your project directory.
2. Initialize Git:
   ```bash
   git init
   ```
3. Add all files to the staging area:
   ```bash
   git add .
   ```
4. Commit the changes:
   ```bash
   git commit -m "Initial commit"
   ```

---

### 3. **Link the Project to the GitHub Repository**
1. Copy the repository's URL from GitHub (e.g., `https://github.com/username/repository.git`).
2. Link your local Git repository to the GitHub repository:
   ```bash
   git remote add origin https://github.com/username/repository.git
   ```
3. Push the code to GitHub:
   ```bash
   git branch -M main
   git push -u origin main
   ```

---

### 4. **Verify on GitHub**
1. Go to your GitHub repository page.
2. Refresh the page to see your project files uploaded.

---

### Troubleshooting Tips:
- **Authentication**: If prompted, use your GitHub credentials or a Personal Access Token (PAT) for authentication.
- **Ignored Files**: Ensure sensitive files (like `application.properties`) are excluded using a `.gitignore` file.
  Example `.gitignore` for Spring Boot:
  ```plaintext
  /target/
  *.log
  *.class
  *.war
  *.jar
  application.properties
  application.yml
  ```
- **Errors While Pushing**: Use `git pull origin main --rebase` if the branch already exists and has conflicts.

---

For further details, check the [GitHub documentation](https://docs.github.com/en/get-started/quickstart/create-a-repo).
# Participant Setup Instructions

## Before Workshop Day - Complete These Steps

---

## 1. Install Required Software

### Java 21 JDK
```bash
# Download from: https://adoptium.net/
# Or use package manager:

# macOS
brew install openjdk@21

# Verify installation
java -version
# Should show: openjdk version "21" or higher
```

### Maven 3.8+
```bash
# Download from: https://maven.apache.org/download.cgi
# Or use package manager:

# macOS
brew install maven

# Verify installation
mvn -version
# Should show: Apache Maven 3.8 or higher
```

### Git
```bash
# Download from: https://git-scm.com/downloads
# Or use package manager:

# macOS
brew install git

# Verify installation
git --version
```

### IDE (Choose One)

**Option A: VS Code**
- Download: https://code.visualstudio.com/
- Install VS Code

**Option B: IntelliJ IDEA**
- Download: https://www.jetbrains.com/idea/download/
- Community Edition is sufficient

---

## 2. Install Amazon Q Developer Extension

### For VS Code:
1. Open VS Code
2. Click Extensions icon (or Ctrl+Shift+X / Cmd+Shift+X)
3. Search: "Amazon Q"
4. Click "Install" on "Amazon Q" extension
5. Restart VS Code

### For IntelliJ IDEA:
1. Open IntelliJ IDEA
2. Go to Settings/Preferences → Plugins
3. Search: "Amazon Q"
4. Click "Install"
5. Restart IntelliJ

---

## 3. Configure AWS Credentials

### Option A: AWS Builder ID (Recommended for Workshop)
1. Open Amazon Q extension in your IDE
2. Click "Sign in"
3. Choose "AWS Builder ID"
4. Complete authentication in browser
5. Return to IDE - you should see Q icon active

### Option B: IAM Identity Center
1. Get credentials from your AWS administrator
2. Follow IAM Identity Center setup
3. Configure in Amazon Q extension

### Verify Amazon Q is Working:
1. Open Amazon Q Chat panel
2. Type: "Hello, can you help me with Java migration?"
3. You should receive a response

---

## 4. Get Workshop Materials

### You will receive ONE of these:

**Option A: Zip File**
```bash
# Extract the zip file
unzip Java-framework-upgrade-workshop.zip
cd Java-framework-upgrade-workshop
```

**Option B: Git Repository**
```bash
# Clone the repository (URL provided by instructor)
git clone <repository-url>
cd java-spring-migration-workshop
```

---

## 5. Verify Sample Application

```bash
# Navigate to sample app
cd sample-app

# Check Java version in pom.xml
grep "<java.version>" pom.xml
# Should show: <java.version>1.8</java.version>

# Check Spring version
grep "<spring.version>" pom.xml
# Should show: <spring.version>5.2.3.RELEASE</spring.version>

# Verify git is initialized
git log
# Should show: "Baseline: Java 8 + Spring 5.2.3"
```

---

## 6. Open Sample App in IDE

### VS Code:
```bash
cd sample-app
code .
```

### IntelliJ IDEA:
1. File → Open
2. Select sample-app folder
3. Wait for Maven import to complete

---

## 7. Pre-Workshop Checklist

Complete this checklist and bring to workshop:

**Software Installed**:
- [ ] Java 21 JDK installed and verified
- [ ] Maven 3.8+ installed and verified
- [ ] Git installed and verified
- [ ] VS Code or IntelliJ IDEA installed
- [ ] Amazon Q Developer extension installed

**Amazon Q Setup**:
- [ ] Amazon Q extension authenticated
- [ ] Q Chat responds to test query
- [ ] Q icon visible in IDE

**Workshop Materials**:
- [ ] Workshop folder downloaded/cloned
- [ ] sample-app opens in IDE
- [ ] pom.xml shows Java 1.8 and Spring 5.2.3
- [ ] Git log shows baseline commit

**Optional but Helpful**:
- [ ] Notebook for taking notes
- [ ] Second monitor (if available)
- [ ] Stable internet connection

---

## Troubleshooting

### Java Version Issues
```bash
# Check which Java is active
java -version

# If wrong version, set JAVA_HOME
export JAVA_HOME=/path/to/java21
export PATH=$JAVA_HOME/bin:$PATH
```

### Maven Not Found
```bash
# Check if Maven is in PATH
which mvn

# If not found, add to PATH or reinstall
```

### Amazon Q Not Responding
1. Check internet connection
2. Sign out and sign in again
3. Restart IDE
4. Check AWS credentials are valid

### Sample App Won't Open
1. Verify you're in correct directory
2. Check pom.xml exists
3. Try: `mvn clean install` (may fail, that's OK)
4. Contact instructor before workshop

---

## What to Bring to Workshop

- [ ] Laptop with all software installed
- [ ] Power adapter
- [ ] Notebook and pen
- [ ] Questions about your own applications (for Module 5)

---

## Workshop Day Schedule

**9:00 AM - 10:30 AM**: Module 1 - Environment Setup & Assessment  
**10:30 AM - 10:45 AM**: Break  
**10:45 AM - 12:45 PM**: Module 2 - Java 8 → Java 21 Migration  
**12:45 PM - 1:45 PM**: Lunch  
**1:45 PM - 3:45 PM**: Module 3 - Spring 5.2.3 → Spring 6 Migration  
**3:45 PM - 4:00 PM**: Break  
**4:00 PM - 5:30 PM**: Module 4 - Testing & Validation  
**5:30 PM - 7:00 PM**: Module 5 - Platform Validation (Optional)

---

## Need Help?

**Before Workshop**:
- Email: [instructor-email]
- Slack: [channel]

**During Workshop**:
- Raise hand in session
- Use chat for questions
- Ask instructor during breaks

---

## See You at the Workshop!

Make sure everything above is ✅ checked before workshop day.

If you have any issues with setup, contact the instructor ASAP.
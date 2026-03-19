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

---

## 2. Install Kiro IDE

Kiro IDE is a standalone AI-powered IDE — no extensions or plugins required.

1. Download Kiro IDE from [Kiro IDE Download URL]
2. Run the installer for your operating system (macOS, Windows, or Linux)
3. Launch Kiro IDE
4. Click "Sign in" on the welcome screen
5. Sign in with your Kiro account (create one if you don't have one yet)
6. Complete authentication in your browser
7. Return to Kiro IDE — verify the Kiro icon is active in the sidebar

### Verify Kiro is Working:
1. Open Kiro Chat panel (click the Kiro icon in the sidebar)
2. Type: "Hello, can you help me with Java migration?"
3. You should receive a response

---

## 3. Get Workshop Materials

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

## 4. Verify Sample Application

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

## 5. Open Sample App in Kiro IDE

1. Launch Kiro IDE
2. File → Open Folder
3. Select the `sample-app` folder
4. Wait for Maven dependency resolution to complete
5. Verify the project structure is visible in the Explorer panel

---

## 6. Pre-Workshop Checklist

Complete this checklist and bring to workshop:

**Software Installed**:
- [ ] Java 21 JDK installed and verified
- [ ] Maven 3.8+ installed and verified
- [ ] Git installed and verified
- [ ] Kiro IDE installed and launched

**Kiro IDE Setup**:
- [ ] Signed in with Kiro account
- [ ] Kiro Chat responds to test query
- [ ] Kiro icon visible and active in sidebar

**Workshop Materials**:
- [ ] Workshop folder downloaded/cloned
- [ ] sample-app opens in Kiro IDE
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

### Kiro IDE Not Responding
1. Check internet connection
2. Sign out and sign in again (click Kiro icon → Sign out)
3. Restart Kiro IDE
4. Verify your Kiro account credentials are valid

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

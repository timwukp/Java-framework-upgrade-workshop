# Workshop Training Kickstart Guide

## For Tomorrow's Customer Training Session

---

## Pre-Training Setup (Do This NOW)

### 1. Verify Repository Structure
```bash
cd /Users/tmwu/Downloads/Java-framework-upgrade-workshop

# You should have:
ls -la
# ✅ Module-1-Environment-Setup.md
# ✅ Module-2-Java-Migration.md
# ✅ Module-3-Spring-Migration.md
# ✅ Module-4-Testing-Validation.md
# ✅ Module-5-Platform-Validation.md
# ✅ Quick-Reference-Guide.md
# ✅ Workshop-Agenda.md
# ✅ sample-app/ (directory)
```

### 2. Verify Sample App is Ready
```bash
cd sample-app

# Check it's in BASELINE state (Java 8 + Spring 5.2.3)
grep "<java.version>" pom.xml
# Should show: <java.version>1.8</java.version>

grep "<spring.version>" pom.xml
# Should show: <spring.version>5.2.3.RELEASE</spring.version>

# Check git status
git log --oneline
# Should show: "Baseline: Java 8 + Spring 5.2.3"

git tag
# Should show: pre-migration-baseline
```

✅ **Sample App Status**: READY - It's in Java 8 + Spring 5.2.3 state

---

## How to Kickstart Training Tomorrow

### Option 1: Share Entire Repository (RECOMMENDED)

**Step 1**: Zip the workshop folder
```bash
cd /Users/tmwu/Downloads
zip -r Java-framework-upgrade-workshop.zip Java-framework-upgrade-workshop/
```

**Step 2**: Share with participants via:
- Email attachment
- Shared drive
- Git repository (push to GitHub/GitLab)
- USB drive

**Step 3**: Participants extract and verify
```bash
unzip Java-framework-upgrade-workshop.zip
cd Java-framework-upgrade-workshop/sample-app
git log  # Should see baseline commit
```

---

### Option 2: Push to Git Repository (BEST PRACTICE)

**Step 1**: Create GitHub/GitLab repository
```bash
# On GitHub/GitLab, create new repo: "java-spring-migration-workshop"
```

**Step 2**: Push workshop materials
```bash
cd /Users/tmwu/Downloads/Java-framework-upgrade-workshop

# Initialize if needed
git init
git add .
git commit -m "Workshop materials: Java 8 + Spring 5 to Java 21 + Spring 6"

# Push to remote
git remote add origin <your-repo-url>
git push -u origin main
```

**Step 3**: Share repository URL with participants
```
Repository: https://github.com/your-org/java-spring-migration-workshop
```

**Step 4**: Participants clone
```bash
git clone <repo-url>
cd java-spring-migration-workshop/sample-app
```

---

## Training Day Schedule

### 9:00 AM - Opening (15 min)

**Your Script**:
```
"Good morning! Today we'll migrate a Java 8 + Spring 5.2.3 application 
to Java 21 + Spring 6 using Amazon Q Developer.

First, let's verify everyone has the materials:
1. Open the workshop folder
2. Navigate to sample-app directory
3. Open pom.xml - you should see Java 1.8 and Spring 5.2.3

Everyone ready? Let's begin with Module 1..."
```

### 9:15 AM - Module 1 Start

**Your Script**:
```
"Open Module-1-Environment-Setup.md

First exercise: Install Amazon Q Developer extension
- VS Code users: Extensions → Search 'Amazon Q'
- IntelliJ users: Settings → Plugins → Search 'Amazon Q'

Let's do this together..."
```

**Participants Follow**: Module-1-Environment-Setup.md step-by-step

---

## Quick Verification Checklist

### Before Training Starts:

**Repository**:
- [ ] All 7 module files present
- [ ] sample-app directory exists
- [ ] sample-app is in Java 8 + Spring 5.2.3 state
- [ ] Git history shows baseline commit

**Sample App**:
- [ ] pom.xml: Java 1.8 ✅
- [ ] pom.xml: Spring 5.2.3.RELEASE ✅
- [ ] User.java: uses java.util.Date ✅
- [ ] User.java: has javax.persistence imports ✅
- [ ] SecurityConfig.java: extends WebSecurityConfigurerAdapter ✅
- [ ] UserController.java: uses @RequestMapping(method=...) ✅
- [ ] UserServiceTest.java: uses JUnit 4 (@Before, @Test) ✅

**Participant Requirements**:
- [ ] Java 21 JDK installed
- [ ] Maven 3.8+ installed
- [ ] Git installed
- [ ] VS Code or IntelliJ IDEA
- [ ] Amazon Q Developer extension installed
- [ ] AWS credentials configured

---

## Training Flow

### Module 1 (90 min): Environment Setup
- Participants open sample-app
- Install Amazon Q extension
- Create git branch
- Analyze project with Q

### Module 2 (120 min): Java Migration
- Update pom.xml to Java 21
- Migrate Date API
- Fix compilation errors
- Participants follow Module-2-Java-Migration.md

### Module 3 (120 min): Spring Migration
- Update Spring to 6.x
- Migrate javax → jakarta
- Update SecurityConfig
- Modernize controllers
- Participants follow Module-3-Spring-Migration.md

### Module 4 (90 min): Testing
- Migrate JUnit 4 → 5
- Fix all tests
- Participants follow Module-4-Testing-Validation.md

### Module 5 (90 min - Optional): Platform
- Create deployment descriptors
- Participants follow Module-5-Platform-Validation.md

---

## Troubleshooting During Training

### If Participant's Sample App is Wrong State:
```bash
cd sample-app
git reset --hard pre-migration-baseline
git clean -fd
```

### If Participant Needs Fresh Start:
```bash
# Delete their sample-app folder
# Re-extract from zip or re-clone from git
```

### If Build Fails:
```bash
# Check Java version
java -version  # Should be 21

# Check Maven
mvn -version

# Clean build
mvn clean compile
```

---

## Quick Reference for You (Instructor)

### Key Files Participants Will Modify:
1. **pom.xml** - Java & Spring versions, dependencies
2. **User.java** - Date API, javax → jakarta
3. **UserController.java** - Annotations, javax → jakarta
4. **SecurityConfig.java** - Spring 6 pattern
5. **UserServiceTest.java** - JUnit 5

### Expected Changes by Module:
- **Module 2**: Java 1.8→21, Date→LocalDateTime
- **Module 3**: Spring 5→6, javax→jakarta, SecurityConfig rewrite
- **Module 4**: JUnit 4→5, test patterns
- **Module 5**: Platform descriptors

### Amazon Q Queries to Demonstrate:
```
"Analyze this Java 8 + Spring 5.2.3 application for migration complexity"
"Update this pom.xml to Java 21"
"Convert javax imports to jakarta"
"Migrate this Spring Security configuration to Spring 6"
"Migrate this JUnit 4 test to JUnit 5"
```

---

## Post-Training

### Collect Feedback:
- What worked well?
- What was confusing?
- Amazon Q helpfulness rating
- Would they recommend to colleagues?

### Share Resources:
- Quick-Reference-Guide.md
- AWS Documentation links
- Support contacts

---

## Emergency Contacts

**Technical Issues**: [Your contact]  
**AWS Support**: [Support channel]  
**Backup Instructor**: [Name]

---

## Final Checklist for Tomorrow Morning

**30 Minutes Before Training**:
- [ ] Test screen sharing
- [ ] Open all module files
- [ ] Have sample-app open in IDE
- [ ] Amazon Q extension working
- [ ] Test internet connection
- [ ] Prepare backup materials (USB drive)

**At Training Start**:
- [ ] Welcome participants
- [ ] Share repository/materials
- [ ] Verify everyone has materials
- [ ] Begin Module 1

---

## Success Criteria

By end of training, participants should:
- [ ] Have migrated sample-app to Java 21 + Spring 6
- [ ] Be comfortable using Amazon Q Developer
- [ ] Understand migration patterns
- [ ] Be ready to migrate their own applications

---

**You're Ready! The sample app is in perfect baseline state for training.**

Good luck tomorrow! 🚀
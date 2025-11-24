# Module 2: Java 8 → Java 21 Migration (120 minutes)

## Hands-On Training Guide

### Part 1: Code Transformation Setup (15 minutes)

#### Exercise 2.1: Prepare for Transformation
**Tool: Q Chat - Pre-transformation Planning**

**Ask Q:**
```
"Before running /transform to upgrade from Java 8 to Java 21, what should I:
1. Back up or preserve?
2. Expect to change?
3. Manually review after transformation?"
```

**Create transformation checklist:**
```
Pre-Transformation:
□ Current code committed to git
□ All tests passing
□ Build successful
□ Backup of pom.xml/build.gradle created

Expected Changes:
□ API replacements (Date → LocalDateTime, etc.)
□ Lambda expression updates
□ Stream API enhancements
□ Deprecated API removals
```

---

### Part 2: Run Code Transformation (30 minutes)

#### Exercise 2.2: Execute /transform Command
**Tool: Amazon Q Code Transformation**

**VS Code:**
```
1. Open Command Palette (Ctrl+Shift+P / Cmd+Shift+P)
2. Type: "Amazon Q: Transform"
3. Select transformation type: "Upgrade Java version"
4. Configure transformation:
   - Source version: Java 8
   - Target version: Java 21
   - Scope: Select project root or specific modules
5. Click "Start Transformation"
6. Monitor progress in Q panel
```

**IntelliJ IDEA:**
```
1. Right-click on project root or module
2. Select "Amazon Q" → "Transform Code"
3. Choose "Java Version Upgrade"
4. Set source: Java 8, target: Java 21
5. Review transformation plan in dialog
6. Click "Transform"
7. Watch progress in Amazon Q tool window
```

**During transformation:**
```
Q will show:
- Files being analyzed
- Changes being applied
- Estimated completion time
- Summary of modifications
```

#### Exercise 2.3: Review Transformation Summary
**Tool: Q Chat + Diff View**

**Step 1: Get transformation report**
```
After transformation completes, ask Q:
"Summarize the changes made by the Java 21 transformation:
- How many files were modified?
- What types of changes were made?
- Are there any files that need manual review?"
```

**Step 2: Review key changes**
```
Open modified files in diff view:
1. Use git diff or IDE diff tool
2. For each significant change, ask Q:
   "Explain why this change was made: [paste code snippet]"
```

**Common transformations to review:**
```java
// Date API changes
// BEFORE (Java 8)
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

// AFTER (Java 21)
LocalDateTime dateTime = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

Ask Q: "Is this Date API transformation correct for my use case?"
```

```java
// Optional API enhancements
// BEFORE
Optional<User> user = findUser(id);
if (user.isPresent()) {
    return user.get().getName();
}
return "Unknown";

// AFTER
Optional<User> user = findUser(id);
return user.map(User::getName).orElse("Unknown");

Ask Q: "Explain this Optional API improvement"
```

---

### Part 3: Fix Compilation Errors (40 minutes)

#### Exercise 2.4: Identify and Fix Errors
**Tool: IDE Compiler + Q Chat**

**Step 1: Build project**
```bash
mvn clean compile
# or
gradle clean build
```

**Step 2: Collect errors**
```
Review compiler output and categorize:
- Deprecated API errors
- Type inference issues
- Module system conflicts
- Third-party library incompatibilities
```

#### Exercise 2.5: Fix Deprecated APIs
**Tool: Q Chat - Error Resolution**

**For each error, use this pattern:**

**Example 1: Removed APIs**
```
Error: cannot find symbol: class Applet

Ask Q:
"I'm getting this error after Java 21 upgrade:
'cannot find symbol: class Applet'
What is the Java 21 alternative?"

Apply Q's suggestion:
- Remove Applet usage
- Use modern UI framework
- Or mark as legacy code to refactor later
```

**Example 2: Finalize() deprecation**
```java
// Error: finalize() has been deprecated and marked for removal

Ask Q:
"How do I replace finalize() in Java 21?
Here's my current code:
[paste code]"

Expected solution:
- Use try-with-resources
- Implement AutoCloseable
- Use Cleaner API
```

**Example 3: SecurityManager removal**
```
Error: SecurityManager has been removed

Ask Q:
"SecurityManager is removed in Java 21. How do I handle security checks?
Current code:
[paste code]"

Apply modern security approach Q suggests
```

#### Exercise 2.6: Update Type Inference
**Tool: Q Inline Suggestions + Chat**

**Pattern matching enhancements:**
```java
// Java 8 style
if (obj instanceof String) {
    String str = (String) obj;
    return str.length();
}

// Ask Q: "Modernize this instanceof check for Java 21"

// Java 21 style (Q suggestion)
if (obj instanceof String str) {
    return str.length();
}
```

**Switch expressions:**
```java
// Java 8 style
String result;
switch (day) {
    case MONDAY:
    case FRIDAY:
        result = "Work";
        break;
    case SATURDAY:
    case SUNDAY:
        result = "Rest";
        break;
    default:
        result = "Unknown";
}

// Ask Q: "Convert this to Java 21 switch expression"

// Java 21 style (Q suggestion)
String result = switch (day) {
    case MONDAY, FRIDAY -> "Work";
    case SATURDAY, SUNDAY -> "Rest";
    default -> "Unknown";
};
```

#### Exercise 2.7: Fix Module System Issues
**Tool: Q Chat - Module Configuration**

**If using Java modules (module-info.java):**
```
Ask Q:
"I need to create/update module-info.java for Java 21.
My project uses:
- Spring Framework
- Jackson
- Hibernate
What should my module-info.java contain?"

Apply Q's suggested module configuration
```

**If not using modules:**
```
Ask Q:
"Should I add module-info.java for this project in Java 21?
What are the pros and cons?"

Decision: Add modules or stay on classpath
```

---

### Part 4: Update Dependencies (20 minutes)

#### Exercise 2.8: Update Java-Related Dependencies
**Tool: Q Chat - Dependency Management**

**Step 1: Identify dependencies to update**
```
Ask Q:
"Review my pom.xml and identify which dependencies need updates for Java 21 compatibility:
[paste pom.xml]"
```

**Step 2: Update Maven/Gradle configuration**
```xml
<!-- Ask Q: "Update this Maven configuration for Java 21" -->

<!-- BEFORE -->
<properties>
    <java.version>1.8</java.version>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>

<!-- AFTER (Q suggestion) -->
<properties>
    <java.version>21</java.version>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <maven.compiler.release>21</maven.compiler.release>
</properties>
```

**Step 3: Update plugin versions**
```
Ask Q:
"What Maven plugin versions are compatible with Java 21?
Update these plugins:
- maven-compiler-plugin
- maven-surefire-plugin
- maven-jar-plugin"

Apply Q's suggested versions
```

#### Exercise 2.9: Handle Third-Party Library Compatibility
**Tool: Q Chat - Compatibility Check**

**For each major dependency:**
```
Ask Q:
"Is [library-name] version [version] compatible with Java 21?
If not, what version should I upgrade to?"

Examples:
- "Is Lombok 1.18.20 compatible with Java 21?"
- "Is Apache Commons Lang 3.9 compatible with Java 21?"
- "Is Jackson 2.10.0 compatible with Java 21?"
```

**Update incompatible libraries:**
```xml
<!-- Ask Q: "Update these dependencies for Java 21 compatibility" -->

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version> <!-- Q suggests latest version -->
</dependency>
```

---

### Part 5: Validation and Testing (15 minutes)

#### Exercise 2.10: Compile and Run Tests
**Tool: Terminal + Q Chat**

**Step 1: Clean build**
```bash
mvn clean compile
# Verify: BUILD SUCCESS

mvn test
# Check test results
```

**Step 2: Fix test failures**
```
For each test failure:

1. Copy error message
2. Ask Q:
   "This test is failing after Java 21 upgrade:
   [paste error and test code]
   How do I fix it?"
3. Apply fix
4. Re-run test
```

#### Exercise 2.11: Code Review Post-Migration
**Tool: /review Command**

**Run comprehensive review:**
```
1. Command Palette → "Amazon Q: Review Code"
2. Select "Review Changes" or "Review Project"
3. Review findings in Code Issues panel
4. For each issue, ask Q:
   "How do I fix this issue: [paste issue description]"
```

**Focus areas:**
```
- Security vulnerabilities introduced
- Performance regressions
- Code quality issues
- Best practices violations
```

#### Exercise 2.12: Runtime Validation
**Tool: Q Chat - Runtime Testing**

**Start application:**
```bash
mvn spring-boot:run
# or
java -jar target/application.jar
```

**If startup fails:**
```
Ask Q:
"Application fails to start after Java 21 upgrade:
[paste stack trace]
What's the issue?"

Common issues Q will help with:
- Reflection access issues
- Module system conflicts
- JVM argument updates needed
```

**Test critical paths:**
```
Ask Q:
"Generate a checklist of critical application paths to test after Java 21 upgrade"

Test each path and document results
```

---

## Module 2 Completion Checklist

**Transformation Complete:**
- [ ] /transform executed successfully
- [ ] Transformation summary reviewed
- [ ] Key changes understood

**Compilation Success:**
- [ ] All compilation errors fixed
- [ ] Deprecated APIs replaced
- [ ] Type inference updated
- [ ] Module system configured (if applicable)

**Dependencies Updated:**
- [ ] Java version set to 21 in build file
- [ ] Maven/Gradle plugins updated
- [ ] Third-party libraries compatible
- [ ] Build successful

**Validation Complete:**
- [ ] All tests passing
- [ ] Code review clean
- [ ] Application starts successfully
- [ ] Critical paths tested

---

## Key Q Developer Commands Used

| Command | Purpose | Usage Count |
|---------|---------|-------------|
| `/transform` | Java version upgrade | 1 time |
| Q Chat | Error resolution | 10-20 times |
| `/review` | Code quality check | 2-3 times |
| Inline suggestions | Code fixes | Continuous |

---

## Common Issues & Solutions

**Issue: Transformation takes too long**
```
Solution:
- Transform smaller modules individually
- Check network connection
- Ask Q: "Can I transform specific packages only?"
```

**Issue: Too many compilation errors**
```
Solution:
- Fix errors by category (deprecated APIs first)
- Ask Q: "Prioritize these errors for fixing: [list errors]"
- Fix high-impact errors first
```

**Issue: Tests fail with reflection errors**
```
Solution:
Ask Q:
"I'm getting IllegalAccessException in tests after Java 21 upgrade.
How do I configure JVM arguments for testing?"

Add to pom.xml:
<argLine>--add-opens java.base/java.lang=ALL-UNNAMED</argLine>
```

---

## Performance Optimization Tips

**Ask Q for Java 21 optimizations:**
```
"What Java 21 features can improve performance in this code:
[paste performance-critical code]"

Q may suggest:
- Virtual threads for concurrent operations
- Pattern matching for cleaner code
- Record classes for data carriers
- Sealed classes for better type safety
```

---

## Next Steps

After completing Module 2, you should have:
1. Java 21 compilation successful
2. All Java 8 code modernized
3. Tests passing with Java 21
4. Application running on Java 21

**Proceed to Module 3: Spring 5.2.3 → Spring 6 Migration**
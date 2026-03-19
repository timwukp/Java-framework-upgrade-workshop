# Module 2: Java 8 → Java 21 Migration (120 minutes)

## Hands-On Training Guide

### Part 1: Migration Planning with Kiro Specs (30 minutes)

#### Exercise 2.1: Create a Kiro Specs Workflow for Java Migration
**Tool: Kiro Specs — Requirements → Design → Tasks**

Instead of running a single transformation command, you will use Kiro Specs to plan and execute the Java 8 → Java 21 migration as a structured workflow. Kiro Specs breaks the migration into three phases: a requirements document defining scope, a design document with migration strategy, and a set of executable tasks you track to completion.

**Step 1: Create the requirements document**

Open Kiro Chat and request a new Spec:

```
Ask Kiro:
"Create a Kiro Spec for migrating our application from Java 8 to Java 21.
The requirements should cover:
1. Updating compiler and build configuration to Java 21
2. Replacing deprecated and removed Java APIs
3. Modernizing code with Java 21 language features (pattern matching, switch expressions, records)
4. Updating third-party dependencies for Java 21 compatibility
5. Ensuring all tests pass after migration"
```

Kiro will generate a `requirements.md` file in `.kiro/specs/java-migration/` that captures the migration scope and acceptance criteria.

**Step 2: Generate the design document**

Once you review and approve the requirements, Kiro will generate a `design.md` that outlines the migration strategy:

```
The design document will include:
- Migration approach (incremental vs. big-bang)
- File-by-file transformation plan
- Dependency upgrade strategy
- Risk areas and manual review points
- Testing strategy
```

**Step 3: Break down into executable tasks**

Kiro generates a `tasks.md` with checkable tasks derived from the design:

```
Example tasks Kiro may generate:
□ Update pom.xml Java version from 1.8 to 21
□ Replace java.util.Date usage with java.time API
□ Modernize instanceof checks with pattern matching
□ Convert switch statements to switch expressions
□ Update Lombok to Java 21-compatible version
□ Update maven-compiler-plugin configuration
□ Run full test suite and fix failures
```

**Step 4: Track progress through task completion**

As you work through the migration, mark tasks complete in `tasks.md`. Kiro tracks your progress and can help with each individual task when you ask.

#### Exercise 2.2: Pre-Migration Checklist
**Tool: Kiro Chat — Pre-Migration Planning**

Before starting the migration tasks, verify your starting point:

**Ask Kiro:**
```
"Before starting the Java 8 to Java 21 migration, what should I:
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

### Part 2: Java Migration Custom Agent (20 minutes)

#### Exercise 2.3: Create and Configure a Java Migration Agent
**Tool: Kiro Custom Agents**

A Kiro Custom Agent is a specialized sub-agent you configure with tailored instructions and expertise for a specific task. For the Java migration, you will create a "Java Migration Agent" that understands Java 8→21 transformation patterns and can apply them consistently across your codebase.

**(a) Purpose and Expertise Scope**

The Java Migration Agent specializes in:
- Java 8 → Java 21 API replacements (Date API, Optional, Stream, etc.)
- Language feature modernization (pattern matching, switch expressions, records, sealed classes)
- Deprecated and removed API migration (Applet, SecurityManager, finalize())
- JVM configuration updates (module system, JVM arguments)

**(b) How to Create and Configure**

Create the agent configuration file at `.kiro/agents/java-migration-agent.md`:

```markdown
# Java Migration Agent

## Role
You are a Java migration specialist focused on upgrading Java 8 codebases to Java 21.

## Expertise
- Java 8 to Java 21 API migration patterns
- Modern Java language features (records, sealed classes, pattern matching, switch expressions)
- Deprecated API replacement strategies
- Maven/Gradle build configuration for Java 21
- Third-party library compatibility with Java 21

## Instructions
- When transforming code, preserve existing functionality and behavior
- Prefer modern Java idioms: use var where it improves readability, pattern matching for instanceof, switch expressions for multi-branch logic
- Replace java.util.Date with java.time equivalents (LocalDateTime, ZonedDateTime, Instant)
- Flag any use of removed APIs (e.g., SecurityManager, Applet) with recommended alternatives
- Update JVM arguments and module system configuration as needed
- Always explain why a change is being made

## Constraints
- Do not change business logic or application behavior
- Do not upgrade Spring Framework version (that is Module 3)
- Preserve all existing test coverage
```

**(c) Best Practices for Prompting and Delegating Tasks**

Use the Java Migration Agent through Kiro Chat for file-level transformations:

```
Ask Kiro (using the Java Migration Agent):
"Using the Java Migration Agent, modernize the Date API usage in
#File:sample-app/src/main/java/com/enterprise/user/entity/User.java"
```

```
Ask Kiro:
"Using the Java Migration Agent, scan #Folder:sample-app/src/main/java
for deprecated Java 8 APIs and list all files that need updates"
```

Tips for effective agent use:
- Delegate one file or one pattern at a time for precise results
- Use #File context key to point the agent at specific files
- Use #Folder context key for package-wide scanning
- Review each transformation before moving to the next file
- Ask the agent to explain its changes when the transformation is complex

---

### Part 3: Java 8→21 Migration Skill (15 minutes)

#### Exercise 2.4: Create a Reusable Java Modernization Skill
**Tool: Kiro Skills**

A Kiro Skill is a reusable, domain-specific capability you create to automate repetitive migration patterns. Instead of manually prompting for the same transformation on every file, a Skill encapsulates the pattern so you can invoke it consistently.

**(a) What the Skill Automates**

The "Java 8→21 Migration" Skill automates these repetitive modernization patterns:
- `java.util.Date` / `SimpleDateFormat` → `java.time.LocalDateTime` / `DateTimeFormatter`
- `instanceof` checks with manual casting → pattern matching `instanceof`
- Traditional `switch` statements → `switch` expressions
- Verbose `Optional` usage → fluent `Optional` chains (`map`, `orElse`, `ifPresent`)
- Anonymous inner classes → lambda expressions (where not already converted)
- Deprecated API calls → modern replacements

**(b) How to Create the Skill**

1. Open the Kiro Skills panel in the sidebar
2. Click "Create Skill" and name it `java-8-to-21-migration`
3. Define the skill's SKILL.md with the transformation patterns:

```markdown
# Java 8→21 Migration Skill

## Purpose
Automate repetitive Java 8 to Java 21 code modernization patterns.

## Patterns

### Date API Migration
- Replace `new Date()` with `LocalDateTime.now()` or `Instant.now()`
- Replace `SimpleDateFormat` with `DateTimeFormatter`
- Replace `Calendar` with `LocalDate`, `LocalDateTime`, or `ZonedDateTime`
- Add required imports from `java.time` package

### Pattern Matching
- Convert `if (obj instanceof Type) { Type t = (Type) obj; ... }` to `if (obj instanceof Type t) { ... }`

### Switch Expressions
- Convert multi-branch switch statements with break to switch expressions with arrow syntax
- Preserve fall-through behavior only when intentional

### Optional Improvements
- Convert `if (opt.isPresent()) { return opt.get()... }` to `opt.map(...).orElse(...)`

### Deprecated API Removal
- Replace `finalize()` with try-with-resources or Cleaner API
- Replace removed APIs with their documented alternatives
```

**(c) When and How to Invoke the Skill**

Invoke the skill through Kiro Chat:

```
Ask Kiro:
"Run the java-8-to-21-migration skill on
#File:sample-app/src/main/java/com/enterprise/user/service/UserService.java"
```

```
Ask Kiro:
"Run the java-8-to-21-migration skill across all files in
#Folder:sample-app/src/main/java/com/enterprise/user/"
```

The skill applies all defined patterns consistently, saving you from repeating the same prompts for each file. After the skill runs, review the changes in the diff view and commit when satisfied.

---

### Part 4: Build a Java Framework Migration Power (15 minutes)

#### Exercise 2.5: Package Migration Knowledge with Power Builder
**Tool: Kiro Power Builder**

A Kiro Power is a packaged bundle of documentation, steering files, and optionally MCP servers that extends Kiro IDE's capabilities for a specific domain. You will use the Power Builder to create a "Java Framework Migration" Power that your entire team can install and use.

**(a) Purpose and Contents**

The Java Framework Migration Power packages:
- **POWER.md**: Migration documentation and best practices for Java 8→21 upgrades — common pitfalls, API mapping tables, and step-by-step guidance
- **Steering files**: Pre-configured `.kiro/steering/` files with Java migration patterns, target version constraints, and coding guidelines
- **Optional MCP server**: A migration-specific MCP server that could provide tools like dependency compatibility checking or automated API mapping lookups

**(b) How to Build with Power Builder**

1. Open the Kiro Powers panel in the sidebar
2. Select "Build Power" to launch the Power Builder
3. Configure the Power:

```
Power Name: Java Framework Migration
Description: Packages Java 8→21 migration best practices, steering files,
             and documentation for enterprise Java modernization projects.

Contents:
├── POWER.md              # Migration guide and best practices
├── steering/
│   ├── java-migration-patterns.md    # Common transformation patterns
│   ├── deprecated-api-mapping.md     # Java 8 API → Java 21 API mapping
│   └── build-config-guidelines.md    # Maven/Gradle configuration for Java 21
└── mcp/ (optional)
    └── dependency-checker/           # MCP server for dependency compatibility
```

4. Write the POWER.md with migration best practices:

```markdown
# Java Framework Migration Power

## Overview
This Power provides comprehensive guidance for migrating enterprise Java
applications from Java 8 to Java 21.

## Migration Patterns
- Date/Time API: java.util.Date → java.time.*
- Pattern Matching: instanceof with casting → pattern matching instanceof
- Switch: statements with break → expressions with arrows
- Text Blocks: string concatenation → text blocks for multi-line strings
- Records: data-carrier classes → record classes
- Sealed Classes: open hierarchies → sealed class hierarchies

## Common Pitfalls
- Reflection access requires --add-opens flags in Java 21
- SecurityManager is removed — use alternative security mechanisms
- finalize() is deprecated for removal — use Cleaner or try-with-resources
- Some internal JDK APIs are encapsulated — use supported alternatives
```

5. Click "Build" to package the Power

**(c) How to Activate and Use**

After building, activate the Power in your workspace:

1. Open the Kiro Powers panel
2. Find "Java Framework Migration" in your local Powers
3. Click "Activate" to load its documentation and steering files into your workspace context

Once activated, Kiro Chat automatically has access to the Power's migration documentation. Ask questions like:

```
Ask Kiro:
"According to the Java Framework Migration Power, what is the recommended
replacement for java.util.Date in entity classes?"
```

**(d) How to Share with Team Members**

Share the Power with your team:
1. Export the Power as a shareable bundle from the Powers panel
2. Team members can import it into their Kiro IDE instance
3. The Power provides consistent migration guidance across the entire team

---

### Part 5: Execute Java Migration Tasks (40 minutes)

#### Exercise 2.6: Review Transformation Results
**Tool: Kiro Chat + Diff View**

As you work through the Kiro Specs tasks — either manually, via the Java Migration Agent, or using the Java 8→21 Migration Skill — review each transformation carefully.

**Step 1: Get a migration status report**
```
After completing a batch of tasks, ask Kiro:
"Summarize the changes made so far in the Java 21 migration:
- How many files were modified?
- What types of changes were made?
- Are there any files that need manual review?"
```

**Step 2: Review key changes**
```
Open modified files in diff view:
1. Use git diff or IDE diff tool
2. For each significant change, ask Kiro:
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

Ask Kiro: "Is this Date API transformation correct for my use case?"
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

Ask Kiro: "Explain this Optional API improvement"
```

---

### Part 6: Fix Compilation Errors (40 minutes)

#### Exercise 2.7: Identify and Fix Errors
**Tool: IDE Compiler + Kiro Chat**

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

Use the #Problems context key to share compilation errors directly with Kiro Chat:

```
Ask Kiro:
"Review #Problems and help me fix the compilation errors from the Java 21 migration.
Prioritize by severity and suggest fixes for each."
```

#### Exercise 2.8: Fix Deprecated APIs
**Tool: Kiro Chat — Error Resolution**

**For each error, use this pattern:**

**Example 1: Removed APIs**
```
Error: cannot find symbol: class Applet

Ask Kiro:
"I'm getting this error after Java 21 upgrade:
'cannot find symbol: class Applet'
What is the Java 21 alternative?"

Apply Kiro's suggestion:
- Remove Applet usage
- Use modern UI framework
- Or mark as legacy code to refactor later
```

**Example 2: Finalize() deprecation**
```java
// Error: finalize() has been deprecated and marked for removal

Ask Kiro:
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

Ask Kiro:
"SecurityManager is removed in Java 21. How do I handle security checks?
Current code:
[paste code]"

Apply modern security approach Kiro suggests
```

#### Exercise 2.9: Update Type Inference
**Tool: Kiro Code Suggestions + Chat**

**Pattern matching enhancements:**
```java
// Java 8 style
if (obj instanceof String) {
    String str = (String) obj;
    return str.length();
}

// Ask Kiro: "Modernize this instanceof check for Java 21"

// Java 21 style (Kiro suggestion)
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

// Ask Kiro: "Convert this to Java 21 switch expression"

// Java 21 style (Kiro suggestion)
String result = switch (day) {
    case MONDAY, FRIDAY -> "Work";
    case SATURDAY, SUNDAY -> "Rest";
    default -> "Unknown";
};
```

#### Exercise 2.10: Fix Module System Issues
**Tool: Kiro Chat — Module Configuration**

**If using Java modules (module-info.java):**
```
Ask Kiro:
"I need to create/update module-info.java for Java 21.
My project uses:
- Spring Framework
- Jackson
- Hibernate
What should my module-info.java contain?"

Apply Kiro's suggested module configuration
```

**If not using modules:**
```
Ask Kiro:
"Should I add module-info.java for this project in Java 21?
What are the pros and cons?"

Decision: Add modules or stay on classpath
```

---

### Part 7: Update Dependencies (20 minutes)

#### Exercise 2.11: Update Java-Related Dependencies
**Tool: Kiro Chat — Dependency Management**

**Step 1: Identify dependencies to update**
```
Ask Kiro:
"Review my pom.xml and identify which dependencies need updates for Java 21 compatibility:
#File:sample-app/pom.xml"
```

**Step 2: Update Maven/Gradle configuration**
```xml
<!-- Ask Kiro: "Update this Maven configuration for Java 21" -->

<!-- BEFORE -->
<properties>
    <java.version>1.8</java.version>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>

<!-- AFTER (Kiro suggestion) -->
<properties>
    <java.version>21</java.version>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <maven.compiler.release>21</maven.compiler.release>
</properties>
```

**Step 3: Update plugin versions**
```
Ask Kiro:
"What Maven plugin versions are compatible with Java 21?
Update these plugins:
- maven-compiler-plugin
- maven-surefire-plugin
- maven-jar-plugin"

Apply Kiro's suggested versions
```

#### Exercise 2.12: Handle Third-Party Library Compatibility
**Tool: Kiro Chat — Compatibility Check**

**For each major dependency:**
```
Ask Kiro:
"Is [library-name] version [version] compatible with Java 21?
If not, what version should I upgrade to?"

Examples:
- "Is Lombok 1.18.20 compatible with Java 21?"
- "Is Apache Commons Lang 3.9 compatible with Java 21?"
- "Is Jackson 2.10.0 compatible with Java 21?"
```

**Update incompatible libraries:**
```xml
<!-- Ask Kiro: "Update these dependencies for Java 21 compatibility" -->

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version> <!-- Kiro suggests latest version -->
</dependency>
```

---

### Part 8: Validation and Testing (15 minutes)

#### Exercise 2.13: Compile and Run Tests
**Tool: Terminal + Kiro Chat**

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
2. Ask Kiro:
   "This test is failing after Java 21 upgrade:
   [paste error and test code]
   How do I fix it?"
3. Apply fix
4. Re-run test
```

You can also use the #Problems context key to share all test failures at once:

```
Ask Kiro:
"Review #Problems — these test failures appeared after the Java 21 migration.
Help me fix them in priority order."
```

#### Exercise 2.14: Code Review Post-Migration
**Tool: Kiro Hooks**

**Run comprehensive review:**
```
1. Kiro Hooks automatically reviews changes on file save
2. Check the Kiro Hooks output panel for any flagged issues
3. For on-demand review of all migration changes, use Kiro Chat:

Ask Kiro:
"Review #Git Diff for any issues in the Java 21 migration changes:
- Security vulnerabilities introduced
- Performance regressions
- Code quality issues
- Best practices violations"
```

#### Exercise 2.15: Runtime Validation
**Tool: Kiro Chat — Runtime Testing**

**Start application:**
```bash
mvn spring-boot:run
# or
java -jar target/application.jar
```

**If startup fails:**
```
Ask Kiro:
"Application fails to start after Java 21 upgrade:
[paste stack trace]
What's the issue?"

Common issues Kiro will help with:
- Reflection access issues
- Module system conflicts
- JVM argument updates needed
```

**Test critical paths:**
```
Ask Kiro:
"Generate a checklist of critical application paths to test after Java 21 upgrade"

Test each path and document results
```

---

## Module 2 Completion Checklist

**Kiro Specs Workflow:**
- [ ] Requirements document created and reviewed
- [ ] Design document generated with migration strategy
- [ ] Tasks broken down and tracked to completion

**Custom Agent and Skill:**
- [ ] Java Migration Agent created and configured in `.kiro/agents/`
- [ ] Java 8→21 Migration Skill created and tested
- [ ] Agent and Skill used for file-level transformations

**Java Framework Migration Power:**
- [ ] Power built with Power Builder (POWER.md + steering files)
- [ ] Power activated in workspace
- [ ] Power shared with team (if applicable)

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
- [ ] Code review clean (Kiro Hooks)
- [ ] Application starts successfully
- [ ] Critical paths tested

---

## Key Kiro IDE Features Used

| Feature | Purpose | Usage |
|---------|---------|-------|
| Kiro Specs | Plan and track Java 8→21 migration as requirements → design → tasks | 1 workflow |
| Kiro Chat | Error resolution, dependency guidance, migration questions | 10-20 times |
| Kiro Code Suggestions | Inline code completions during migration edits | Continuous |
| Java Migration Custom Agent | Specialized agent for Java 8→21 file-level transformations | Per-file delegation |
| Java 8→21 Migration Skill | Automates repetitive modernization patterns (Date API, pattern matching, etc.) | Per-file or per-folder |
| Java Framework Migration Power | Packaged migration docs, steering files, and best practices for team use | 1 Power built and activated |

---

## Common Issues & Solutions

**Issue: Kiro Specs generates too many or too few tasks**
```
Solution:
- Refine the requirements document with more specific scope
- Ask Kiro to regenerate tasks with different granularity:
  "Regenerate the tasks with one task per file that needs changes"
```

**Issue: Too many compilation errors**
```
Solution:
- Fix errors by category (deprecated APIs first)
- Use the Java Migration Agent to batch-fix similar patterns:
  "Using the Java Migration Agent, fix all deprecated Date API usage in
  #Folder:sample-app/src/main/java/"
- Use #Problems context key to share all errors with Kiro Chat
```

**Issue: Tests fail with reflection errors**
```
Solution:
Ask Kiro:
"I'm getting IllegalAccessException in tests after Java 21 upgrade.
How do I configure JVM arguments for testing?"

Add to pom.xml:
<argLine>--add-opens java.base/java.lang=ALL-UNNAMED</argLine>
```

**Issue: Skill produces inconsistent results**
```
Solution:
- Refine the skill's SKILL.md with more specific patterns
- Test the skill on a single file first before running on a folder
- Review and adjust the skill's output, then re-run
```

---

## Performance Optimization Tips

**Ask Kiro for Java 21 optimizations:**
```
"What Java 21 features can improve performance in this code:
[paste performance-critical code]"

Kiro may suggest:
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
5. Java Migration Agent and Skill ready for reuse
6. Java Framework Migration Power built and shareable

**Proceed to Module 3: Spring 5.2.3 → Spring 6 Migration**
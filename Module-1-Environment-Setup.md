# Module 1: Environment Setup & Assessment (90 minutes)

## Hands-On Training Guide

### Part 1: Kiro IDE Setup (20 minutes)

#### Exercise 1.1: Install and Launch Kiro IDE
**Tool: Kiro IDE (Standalone)**

Kiro IDE is a standalone AI-powered IDE — there is no extension to install in another editor.

**Installation Steps:**
```
1. Download Kiro IDE from [Kiro IDE Download URL]
2. Run the installer for your operating system (macOS, Windows, or Linux)
3. Launch Kiro IDE
4. Click "Sign in" on the welcome screen
5. Sign in with your Kiro account
6. Complete authentication in your browser
7. Return to Kiro IDE — verify the Kiro icon is active in the sidebar
```

**Verification:**
- Open Kiro Chat panel (click the Kiro icon in the sidebar)
- Type: "Hello, can you help me with Java migration?"
- Confirm you receive a response

#### Exercise 1.2: Set Up Steering Files
**Tool: Kiro Steering Files**

Steering files provide Kiro with project-level context about your migration — scope, target versions, constraints, and coding guidelines. They live in `.kiro/steering/*.md` and are automatically picked up by Kiro to inform all interactions.

**Step 1: Create the steering directory**
```
1. In Kiro IDE, open the Explorer panel
2. Right-click the project root → New Folder
3. Create the folder path: .kiro/steering/
```

**Step 2: Create `project-context.md`**

Create `.kiro/steering/project-context.md` with the following content:
```markdown
# Project Context

This is a Java enterprise application migration project.

## Migration Scope
- Migrate from Java 8 to Java 21
- Migrate from Spring Framework 5.2.3 to Spring 6
- Migrate from javax.* to jakarta.* namespace
- Update all test frameworks (JUnit 4 → JUnit 5)

## Goals
- Modernize the codebase to use current LTS Java version
- Adopt Spring 6 and Spring Boot 3 patterns
- Maintain all existing business logic and functionality
- Ensure zero regression in test coverage
```

**Step 3: Create `tech-stack.md`**

Create `.kiro/steering/tech-stack.md` with:
```markdown
# Technology Stack

## Current State
- Java 8 (OpenJDK 1.8)
- Spring Framework 5.2.3.RELEASE
- javax.* namespace (Java EE)
- JUnit 4
- Maven 3.8+

## Target State
- Java 21 (OpenJDK 21 LTS)
- Spring Framework 6.x / Spring Boot 3.x
- jakarta.* namespace (Jakarta EE)
- JUnit 5
- Maven 3.8+

## Key Migration Constraints
- Must maintain backward compatibility with existing database schemas
- All REST API contracts must remain unchanged
- Security configurations must be updated to Spring Security 6 patterns
```

**Step 4: Create `coding-guidelines.md`**

Create `.kiro/steering/coding-guidelines.md` with:
```markdown
# Coding Guidelines

## Java 21 Patterns
- Use records for data transfer objects where appropriate
- Use sealed classes for type hierarchies where appropriate
- Replace Date/Calendar with java.time API (LocalDateTime, ZonedDateTime)
- Use text blocks for multi-line strings
- Use pattern matching for instanceof checks

## Spring 6 Patterns
- Use constructor injection (not field injection)
- Use SecurityFilterChain bean instead of WebSecurityConfigurerAdapter
- Use jakarta.* imports instead of javax.*

## General Rules
- Preserve all existing business logic
- Maintain existing test coverage
- Document any breaking changes
```

**Step 5: Create `project-structure.md`**

Create `.kiro/steering/project-structure.md` with:
```markdown
# Project Structure

## Application Architecture
- Controller layer: REST endpoints (UserController)
- Service layer: Business logic (UserService)
- Repository layer: Data access (UserRepository)
- Entity layer: Domain models (User)
- Config: Security and application configuration (SecurityConfig)

## Key Directories
- src/main/java/com/enterprise/user/ — Main application code
- src/main/resources/ — Configuration files
- src/test/java/ — Test classes
- pom.xml — Maven build configuration
```

**Verification:**
- Open Kiro Chat and ask: "What do you know about this project's migration goals?"
- Kiro should reference the steering file content in its response, confirming the files are being picked up.

#### Exercise 1.3: Browse and Install Powers from the Catalog
**Tool: Kiro Powers**

Powers are packaged bundles of documentation, steering files, and optionally MCP servers that extend Kiro's capabilities for specific domains. You can browse and install Powers from the Kiro Powers catalog.

**Steps:**
```
1. Open the Powers management panel in Kiro IDE (click the Powers icon in the sidebar)
2. Browse the Powers catalog for relevant Powers:
   - Look for AWS documentation Powers
   - Look for Java migration-related Powers
   - Look for Spring Framework Powers
3. Install any relevant Powers by clicking "Install"
4. Activate an installed Power by toggling it on in the Powers panel
5. Verify the Power is active — its documentation and tools should now be
   available to Kiro Chat
```

**What Powers provide:**
- Curated documentation and best practices accessible to Kiro
- Steering files that guide Kiro's responses for specific domains
- Optionally, MCP servers that provide specialized tools and integrations

**Tip:** In Module 2, you will learn to build your own custom Power using the Power Builder. For now, explore what's available in the catalog.

#### Exercise 1.4: Plan Custom Agents for the Migration
**Tool: Kiro Custom Agents**

Custom Agents are specialized sub-agents you configure for specific tasks. Each agent has tailored instructions and expertise. For a migration project like this, plan one agent per major framework migration.

**Recommended agents for this workshop:**

| Agent Name | Purpose | Created In |
|------------|---------|------------|
| Java Migration Agent | Java 8→21 transformation expertise | Module 2 |
| Spring Migration Agent | Spring 5→6 and Jakarta namespace expertise | Module 3 |

**Planning guidance:**
```
Ask Kiro: "I'm planning a migration from Java 8 + Spring 5.2.3 to Java 21 + Spring 6.
What specialized agents would you recommend I create, and what expertise
should each one have?"
```

Custom agents are configured as markdown files in `.kiro/agents/`. You will create and use them in Modules 2 and 3. For now, understand the concept: each agent gets a focused set of instructions so it can provide expert-level guidance for its specific migration domain.

---

### Part 2: Project Setup (15 minutes)

#### Exercise 1.5: Open Sample Application
**Tool: Kiro IDE Project Explorer + Kiro Chat**

**Steps:**
```
1. Clone or open sample Java 8 + Spring 5.2.3 application
2. Open project in Kiro IDE (File → Open Folder)
3. Wait for dependency resolution
4. Open Kiro Chat
5. Ask: "Analyze the structure of this project"
```

**Expected Kiro Response Topics:**
- Project type (Maven/Gradle)
- Java version detected
- Spring Framework version
- Key dependencies
- Project structure overview

#### Exercise 1.6: Verify Build Environment
**Tool: Terminal + Kiro Chat**

**Commands to run:**
```bash
# Check Java version
java -version

# Check Maven/Gradle
mvn -version
# or
gradle -version

# Build project
mvn clean compile
# or
gradle clean build
```

**If build fails, ask Kiro:**
```
"I'm getting this build error: [paste error]
What do I need to fix before starting migration?"
```

---

### Part 3: Initial Assessment (30 minutes)

#### Exercise 1.7: Project Complexity Analysis
**Tool: Kiro Chat - Project Analysis**

**Ask Kiro these questions in sequence:**

1. **Overall Assessment:**
```
"Analyze this Java 8 + Spring 5.2.3 application for migration to Java 21 + Spring 6. 
What is the complexity level and estimated effort?"
```

2. **Dependency Analysis:**
```
"List all dependencies in pom.xml that will need updates for Java 21 and Spring 6 migration"
```

3. **Code Pattern Analysis:**
```
"Scan the codebase and identify:
- Deprecated APIs that will break in Java 21
- Spring 5 patterns that need updating for Spring 6
- javax.* imports that need jakarta.* migration"
```

4. **Risk Assessment:**
```
"What are the highest risk areas in this migration?
Which files or components need the most careful attention?"
```

**Document findings in a checklist:**
```
Migration Complexity Assessment:
□ Number of Java files: ___
□ Number of Spring configuration files: ___
□ Number of test files: ___
□ Third-party dependencies requiring updates: ___
□ Deprecated API usage count: ___
□ Estimated migration time: ___
```

#### Exercise 1.8: Create Migration Baseline
**Tool: Kiro Chat + Kiro Hooks**

**Step 1: Configure and run Kiro Hooks for baseline review**

Kiro Hooks provide automated code review triggered on file save. For the baseline, you can also trigger a review on-demand.

```
1. Open Kiro Chat
2. Ask: "Review the current state of this project for code quality,
   security issues, and deprecated API usage"
3. Use #Folder to reference the entire source directory for a comprehensive scan:
   "#Folder src/main/java — Review all source files for migration readiness"
4. Review findings in the Kiro Chat response
```

**Step 2: Document current state**
```
Ask Kiro: "Summarize the code review findings and categorize by:
- Security issues
- Code quality issues
- Deprecated API usage
- Potential migration blockers"
```

**Step 3: Baseline metrics**
```
Ask Kiro: "Generate a report of:
- Total lines of code
- Test coverage estimate
- Complexity hotspots
- Dependencies with known vulnerabilities"
```

---

### Part 4: Migration Planning (25 minutes)

#### Exercise 1.9: Create Migration Strategy
**Tool: Kiro Chat - Strategic Planning**

**Ask Kiro to help create migration plan:**

```
"Based on this project analysis, create a step-by-step migration plan with:
1. Order of operations (Java first or dependencies first?)
2. Files to migrate in priority order
3. Testing strategy after each phase
4. Rollback points if issues occur"
```

**Expected output format:**
```
Phase 1: Java 8 → Java 21
- Step 1: Create Kiro Specs for Java migration (requirements → design → tasks)
- Step 2: Fix compilation errors in [specific files]
- Step 3: Update deprecated API usage
- Checkpoint: All code compiles

Phase 2: Spring 5.2.3 → Spring 6
- Step 1: Update pom.xml dependencies
- Step 2: Migrate javax.* to jakarta.*
- Step 3: Update Spring configurations
- Checkpoint: Application starts successfully

Phase 3: Testing
- Step 1: Update test framework
- Step 2: Fix test failures
- Step 3: Run integration tests
- Checkpoint: All tests pass
```

#### Exercise 1.10: Identify Critical Business Logic
**Tool: Kiro Chat - Code Understanding**

**For each major service/component, ask:**
```
"Explain what this [ServiceName] class does and identify:
- Critical business logic that must not break
- External integrations (databases, APIs, messaging)
- Security-sensitive operations
- Performance-critical sections"
```

**Create a risk matrix:**
```
Component | Business Impact | Migration Risk | Testing Priority
----------|----------------|----------------|------------------
UserService | High | Medium | P0
PaymentService | Critical | High | P0
ReportService | Medium | Low | P1
```

---

### Part 5: Environment Validation (10 minutes)

#### Exercise 1.11: Pre-Migration Checklist
**Tool: Kiro Chat + Manual Verification**

**Verify with Kiro's help:**

1. **Source Control:**
```
Ask Kiro: "What should I commit to git before starting migration?"

Expected actions:
- Create feature branch: git checkout -b feature/java21-spring6-migration
- Commit current state: git add . && git commit -m "Baseline before migration"
- Tag baseline: git tag pre-migration-baseline
```

2. **Backup Strategy:**
```
Ask Kiro: "What backup strategy should I use for this migration?"

Expected recommendations:
- Database backup commands
- Configuration file backups
- Dependency lock file preservation
```

3. **Test Execution:**
```
Run existing tests:
mvn test
# or
gradle test

Ask Kiro: "All tests pass. What should I document before migration?"
```

4. **Documentation:**
```
Ask Kiro: "Generate a pre-migration checklist document"

Should include:
□ Current Java version: ___
□ Current Spring version: ___
□ All tests passing: Yes/No
□ Build successful: Yes/No
□ Git branch created: Yes/No
□ Team notified: Yes/No
□ Rollback plan documented: Yes/No
```

---

## Module 1 Completion Checklist

**Environment Setup:**
- [ ] Kiro IDE installed and launched
- [ ] Successfully signed in with Kiro account
- [ ] Kiro Chat responding to queries
- [ ] Steering files created in `.kiro/steering/`
- [ ] Powers catalog browsed and relevant Powers installed
- [ ] Custom agent plan documented for Modules 2 and 3
- [ ] Sample project opened and building

**Assessment Complete:**
- [ ] Project complexity analyzed
- [ ] Dependencies identified for update
- [ ] Risk areas documented
- [ ] Migration plan created
- [ ] Critical business logic identified

**Ready for Migration:**
- [ ] Baseline code review completed
- [ ] Git branch created
- [ ] Current state committed
- [ ] All tests passing
- [ ] Team aligned on approach

---

## Key Kiro IDE Features Used

| Feature | Purpose | When to Use |
|---------|---------|-------------|
| Kiro Chat | Ask questions, get migration guidance | Throughout assessment and planning |
| Kiro Code Suggestions | Inline code completions during development | Writing steering files and documentation |
| Kiro Steering Files | Provide project context to Kiro (`.kiro/steering/*.md`) | Setup phase — defines migration scope and constraints |
| Kiro Powers | Install packaged documentation and tools from catalog | Setup phase — extend Kiro with domain knowledge |
| Kiro Custom Agents (planning) | Plan specialized agents for each migration phase | Setup phase — prepare for Modules 2 and 3 |

---

## Common Issues & Solutions

**Issue: Kiro IDE not responding**
```
Solution:
1. Check internet connection
2. Verify authentication: Click Kiro icon → Check sign-in status
3. Restart Kiro IDE
4. Ask Kiro: "Test connection"
```

**Issue: Steering files not being picked up**
```
Solution:
1. Verify files are in .kiro/steering/ directory (not a subdirectory)
2. Verify files have .md extension
3. Check file content is valid markdown
4. Restart Kiro IDE and test with a Kiro Chat query about the project
```

**Issue: Project not building**
```
Solution:
1. Copy build error
2. Ask Kiro: "How do I fix this build error: [paste error]"
3. Or use Kiro Chat with #Problems context key to share compilation errors directly
4. Apply suggested fixes
5. Clean and rebuild
```

**Issue: Can't find specific files**
```
Solution:
Ask Kiro: "Where are the Spring configuration files in this project?"
Or use #Folder context key: "#Folder src/main/java — List all configuration files"
Kiro will help locate key files
```

---

## Next Steps

After completing Module 1, you should have:
1. Working Kiro IDE setup with steering files configured
2. Powers installed from the catalog
3. Custom agent plan ready for Modules 2 and 3
4. Complete project assessment
5. Migration plan documented
6. Baseline established

**Proceed to Module 2: Java 8 → Java 21 Migration**

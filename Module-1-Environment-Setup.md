# Module 1: Environment Setup & Assessment (90 minutes)

## Hands-On Training Guide

### Part 1: Amazon Q Developer IDE Setup (20 minutes)

#### Exercise 1.1: Install and Configure Amazon Q
**Tool: IDE Extension Installation**

**VS Code:**
```
1. Open VS Code
2. Go to Extensions (Ctrl+Shift+X / Cmd+Shift+X)
3. Search "Amazon Q"
4. Click Install on "Amazon Q" extension
5. Click "Sign in" in the Amazon Q panel
6. Choose authentication method:
   - AWS Builder ID (recommended for workshop)
   - IAM Identity Center
7. Complete authentication in browser
8. Return to VS Code - verify Q icon in sidebar
```

**IntelliJ IDEA:**
```
1. Open IntelliJ IDEA
2. Go to Settings/Preferences → Plugins
3. Search "Amazon Q"
4. Click Install
5. Restart IDE
6. Click Amazon Q icon in toolbar
7. Sign in with AWS Builder ID or IAM Identity Center
8. Verify connection in Amazon Q tool window
```

**Verification:**
- Open Amazon Q Chat panel
- Type: "Hello, can you help me with Java migration?"
- Confirm you receive a response

---

### Part 2: Project Setup (15 minutes)

#### Exercise 1.2: Open Sample Application
**Tool: IDE Project Explorer + Q Chat**

**Steps:**
```
1. Clone or open sample Java 8 + Spring 5.2.3 application
2. Open project in IDE
3. Wait for dependency resolution
4. Open Amazon Q Chat
5. Ask: "Analyze the structure of this project"
```

**Expected Q Response Topics:**
- Project type (Maven/Gradle)
- Java version detected
- Spring Framework version
- Key dependencies
- Project structure overview

#### Exercise 1.3: Verify Build Environment
**Tool: Terminal + Q Chat**

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

**If build fails, ask Q:**
```
"I'm getting this build error: [paste error]
What do I need to fix before starting migration?"
```

---

### Part 3: Initial Assessment (30 minutes)

#### Exercise 1.4: Project Complexity Analysis
**Tool: Q Chat - Project Analysis**

**Ask Q these questions in sequence:**

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

#### Exercise 1.5: Create Migration Baseline
**Tool: Q Chat + /review**

**Step 1: Run code review**
```
1. Open Command Palette (Ctrl+Shift+P / Cmd+Shift+P)
2. Type: "Amazon Q: Review Code"
3. Select scope: "Entire Project" or specific folders
4. Wait for review to complete
5. Review findings in "Amazon Q - Code Issues" panel
```

**Step 2: Document current state**
```
Ask Q: "Summarize the code review findings and categorize by:
- Security issues
- Code quality issues
- Deprecated API usage
- Potential migration blockers"
```

**Step 3: Baseline metrics**
```
Ask Q: "Generate a report of:
- Total lines of code
- Test coverage estimate
- Complexity hotspots
- Dependencies with known vulnerabilities"
```

---

### Part 4: Migration Planning (25 minutes)

#### Exercise 1.6: Create Migration Strategy
**Tool: Q Chat - Strategic Planning**

**Ask Q to help create migration plan:**

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
- Step 1: Run /transform on core modules
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

#### Exercise 1.7: Identify Critical Business Logic
**Tool: Q Chat - Code Understanding**

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

#### Exercise 1.8: Pre-Migration Checklist
**Tool: Q Chat + Manual Verification**

**Verify with Q's help:**

1. **Source Control:**
```
Ask Q: "What should I commit to git before starting migration?"

Expected actions:
- Create feature branch: git checkout -b feature/java21-spring6-migration
- Commit current state: git add . && git commit -m "Baseline before migration"
- Tag baseline: git tag pre-migration-baseline
```

2. **Backup Strategy:**
```
Ask Q: "What backup strategy should I use for this migration?"

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

Ask Q: "All tests pass. What should I document before migration?"
```

4. **Documentation:**
```
Ask Q: "Generate a pre-migration checklist document"

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
- [ ] Amazon Q Developer IDE extension installed
- [ ] Successfully authenticated with AWS
- [ ] Q Chat responding to queries
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

## Key Q Developer Commands Used

| Command | Purpose | When to Use |
|---------|---------|-------------|
| Q Chat | Ask questions, get guidance | Throughout assessment |
| `/review` | Code quality analysis | Baseline and validation |
| Inline suggestions | Code completion | Writing documentation |

---

## Common Issues & Solutions

**Issue: Q not responding**
```
Solution:
1. Check internet connection
2. Verify authentication: Click Q icon → Check sign-in status
3. Restart IDE
4. Ask Q: "Test connection"
```

**Issue: Project not building**
```
Solution:
1. Copy build error
2. Ask Q: "How do I fix this build error: [paste error]"
3. Apply suggested fixes
4. Clean and rebuild
```

**Issue: Can't find specific files**
```
Solution:
Ask Q: "Where are the Spring configuration files in this project?"
Q will help locate key files
```

---

## Next Steps

After completing Module 1, you should have:
1. Working Amazon Q Developer IDE setup
2. Complete project assessment
3. Migration plan documented
4. Baseline established

**Proceed to Module 2: Java 8 → Java 21 Migration**

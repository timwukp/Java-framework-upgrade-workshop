# Kiro IDE Workshop - Quick Reference Guide

## Workshop Overview

**Duration**: 8 hours (9 AM - 5 PM) + Optional 1.5 hours  
**Target**: Java 8 + Spring 5.2.3 → Java 21 + Spring 6  
**Applications**: 27 apps (25 BDP/JBoss, 2 BPT/WebSphere, BCN/Mainframe)

---

## Kiro IDE Features

| Feature | Description | When to Use |
|---------|-------------|-------------|
| Kiro Specs | Structured workflow — requirements → design → tasks — for planning and executing migration work | Planning migration scope, breaking down work into trackable tasks, executing structured transformations |
| Kiro Hooks | Automated agent actions triggered by file saves for continuous code review; on-demand review via Kiro Chat with #Git Diff | Catching issues early during development, security validation, pre-commit quality checks |
| Kiro Steering | Project-level instruction files at `.kiro/steering/*.md` providing migration-specific context and constraints | Configuring Kiro with project context, migration targets, coding guidelines, and architecture constraints |
| Kiro Chat | Conversational AI interface for migration guidance, code generation, and troubleshooting | Asking migration questions, requesting code changes, troubleshooting errors, reviewing changes |
| Kiro Code Suggestions | Inline code completions during development | Writing new code, accepting migration pattern suggestions as you type |
| Context Keys | Special chat references: #File, #Folder, #Problems, #Terminal, #Git Diff | Providing targeted context to Kiro Chat — use #Problems for compilation errors, #File for specific file context, #Git Diff for reviewing changes |
| Kiro Skills | Reusable, domain-specific capabilities that automate repetitive migration patterns | Automating Date API modernization, javax→jakarta renames, security config upgrades, test annotation conversion |
| Kiro Custom Agents | User-defined specialized agents configured for specific migration tasks | Delegating Java 8→21 transformation tasks, Spring 5→6 migration tasks to focused agents with tailored expertise |
| Kiro Powers | Packaged bundles of documentation, steering files, and optional MCP servers that extend Kiro IDE capabilities | Installing migration knowledge from catalog, building shareable migration Power bundles for your team |

---

## Module-by-Module Quick Guide

### Module 1: Environment Setup (90 min)

**Key Tasks:**
1. Install and launch Kiro IDE
2. Sign in with Kiro account
3. Open and analyze project
4. Set up Kiro Steering files
5. Create migration plan and establish baseline

**Critical Kiro Queries:**
```
"Analyze this Java 8 + Spring 5.2.3 application for migration complexity"
"List all dependencies that need updates for Java 21 and Spring 6"
"What are the highest risk areas in this migration?"
"Generate a pre-migration checklist"
```

**Completion Criteria:**
- [ ] Kiro IDE working
- [ ] Project building successfully
- [ ] Migration plan documented
- [ ] Git branch created
- [ ] All tests passing

---

### Module 2: Java 8 → Java 21 (120 min)

**Key Tasks:**
1. Run `Kiro Specs` for Java upgrade
2. Review transformation results
3. Fix compilation errors
4. Update dependencies
5. Validate with tests

**Critical Kiro Queries:**
```
"Explain the changes made by Java 21 transformation"
"How do I fix this Java 21 compilation error: [error]"
"What is the Java 21 alternative for [deprecated API]"
"Update Maven configuration for Java 21"
"Is [library] version [X] compatible with Java 21?"
```

**Common Transformations:**
- Date API → LocalDateTime
- Optional API improvements
- Switch expressions
- Pattern matching
- finalize() → Cleaner API

**Completion Criteria:**
- [ ] Java 21 compilation successful
- [ ] All deprecated APIs replaced
- [ ] Dependencies updated
- [ ] Tests passing
- [ ] Application runs on Java 21

---

### Module 3: Spring 5.2.3 → Spring 6 (120 min)

**Key Tasks:**
1. Update Spring dependencies
2. Migrate javax.* → jakarta.*
3. Update Spring configurations
4. Modernize controllers
5. Update properties

**Critical Kiro Queries:**
```
"Generate updated Spring 6 dependencies for my pom.xml"
"Convert all javax imports to jakarta in this file"
"Migrate this Spring Security configuration to Spring 6"
"How do I replace WebSecurityConfigurerAdapter in Spring 6?"
"Update these Spring Boot properties for Spring 6"
```

**Key Migrations:**
```java
// Security
WebSecurityConfigurerAdapter → SecurityFilterChain bean

// Imports
javax.servlet.* → jakarta.servlet.*
javax.persistence.* → jakarta.persistence.*

// Controllers
@RequestMapping(method = GET) → @GetMapping

// Configuration
authorizeRequests() → authorizeHttpRequests()
```

**Completion Criteria:**
- [ ] Spring 6 dependencies updated
- [ ] All javax → jakarta complete
- [ ] Configurations modernized
- [ ] Application starts successfully
- [ ] Endpoints responding

---

### Module 4: Testing & Validation (90 min)

**Key Tasks:**
1. Migrate JUnit 4 → JUnit 5
2. Update Mockito
3. Fix unit tests
4. Create integration tests
5. Validate coverage

**Critical Kiro Queries:**
```
"Migrate this JUnit 4 test to JUnit 5 for Spring 6"
"Update Mockito test for JUnit 5 and Spring 6"
"Generate Spring 6 integration test for SQL Server database"
"Generate REST API integration test using MockMvc"
"How do I fix this Spring 6 test failure: [error]"
```

**Key Test Migrations:**
```java
// JUnit 4 → 5
@Before → @BeforeEach
@After → @AfterEach
@Test (same)
Assert.* → Assertions.*
@RunWith(SpringRunner.class) → @ExtendWith(SpringExtension.class)

// Mockito
@RunWith(MockitoJUnitRunner.class) → @ExtendWith(MockitoExtension.class)
```

**Completion Criteria:**
- [ ] All tests migrated to JUnit 5
- [ ] Unit tests passing
- [ ] Integration tests passing
- [ ] Code coverage ≥ 80%
- [ ] Security review clean

---

### Module 5: Platform Validation (90 min - Optional)

**Key Tasks:**
1. Configure JBoss EAP deployment
2. Configure WebSphere deployment
3. Optimize for mainframe
4. Test on each platform
5. Create deployment procedures

**Critical Kiro Queries:**

**JBoss EAP:**
```
"What JBoss EAP version supports Java 21 and Spring 6?"
"Generate jboss-deployment-structure.xml for Spring 6 application"
"Update pom.xml to package as WAR for JBoss EAP"
```

**WebSphere:**
```
"What WebSphere version supports Java 21 and Spring 6?"
"Generate ibm-web-ext.xml for Spring 6 application"
"What ClassLoader policy should I use for Spring 6 on WebSphere?"
```

**Mainframe:**
```
"How do I optimize Spring 6 application for mainframe deployment?"
"Generate JVM arguments for Java 21 on mainframe with 512MB heap"
"Generate mainframe-optimized Spring 6 configuration"
```

**Completion Criteria:**
- [ ] Platform descriptors created
- [ ] Test deployments successful
- [ ] All endpoints responding
- [ ] Performance acceptable
- [ ] Rollback procedures documented

---

## Common Error Patterns & Solutions

> **Tip**: Use Context Keys to give Kiro targeted context when troubleshooting. Use `#Problems` to share compilation errors directly, `#File` to reference the specific file with issues, and `#Terminal` to share build output.

### Compilation Errors

**Error**: `cannot find symbol: class [JavaxClass]`
```
Ask Kiro: "Getting 'cannot find symbol' for javax classes after Spring 6 upgrade. What's missing? #Problems"
Solution: Add jakarta.* dependency, convert imports. Use the Jakarta Namespace Migration Skill for bulk conversion.
```

**Error**: `method [X] has been deprecated and marked for removal`
```
Ask Kiro: "How do I replace [deprecated method] in Java 21? #File [filename]"
Solution: Use Kiro's suggested modern alternative. The Java 8→21 Migration Skill handles common deprecated API patterns.
```

### Runtime Errors

**Error**: `NoClassDefFoundError: javax/servlet/...`
```
Ask Kiro: "NoClassDefFoundError for javax.servlet after Spring 6 upgrade. What's wrong? #Problems #Terminal"
Solution: Verify jakarta.servlet dependency, check all imports converted
```

**Error**: `Unable to load ApplicationContext`
```
Ask Kiro: "Spring test context fails to load after Spring 6 upgrade. #Problems #File [test-file]"
Solution: Update test configuration, fix Spring 6 incompatibilities
```

### Test Failures

**Error**: `IllegalAccessException` in tests
```
Ask Kiro: "Getting IllegalAccessException in tests after Java 21 upgrade. How do I configure JVM arguments? #Problems"
Solution: Add --add-opens JVM arguments to test configuration
```

**Error**: Mocks are null
```
Ask Kiro: "Mocks are null in JUnit 5 test. What's wrong with my mock setup? #File [test-file]"
Solution: Add @ExtendWith(MockitoExtension.class). The JUnit 4→5 Migration Skill handles this conversion automatically.
```

---

## Best Practices Checklist

### Before Starting
- [ ] Create git branch for migration
- [ ] Commit current working state
- [ ] Tag baseline: `git tag pre-migration-baseline`
- [ ] Document current versions
- [ ] Run and pass all existing tests

### During Migration
- [ ] Commit after each major step
- [ ] Test frequently (after each module)
- [ ] Document issues and solutions
- [ ] Ask Kiro before making assumptions
- [ ] Use `Kiro Hooks` to catch issues early

### After Migration
- [ ] Full test suite passing
- [ ] Code coverage maintained/improved
- [ ] Security review clean
- [ ] Performance benchmarks met
- [ ] Documentation updated

---

## Kiro IDE Tips

### Getting Better Answers
1. **Be specific**: Include error messages, code snippets, versions
2. **Provide context**: Mention Java 21, Spring 6, target platform
3. **Use Context Keys**: Reference #File, #Folder, #Problems, or #Git Diff to give Kiro targeted context
4. **Leverage Skills**: Create reusable Skills for repetitive migration patterns instead of re-prompting
5. **Delegate to Agents**: Use Custom Agents (Java Migration Agent, Spring Migration Agent) for domain-specific tasks
6. **Activate Powers**: Install or build Powers to give Kiro packaged migration knowledge and tools

### Effective Kiro Chat Queries with Context Keys
```
❌ "How do I fix this error?"
✅ "How do I fix this Java 21 compilation error? #Problems"

❌ "Update my config"
✅ "Migrate this Spring Security configuration to Spring 6 #File SecurityConfig.java"

❌ "Tests failing"
✅ "This JUnit test fails after Spring 6 migration. #File UserServiceTest.java #Problems"

❌ "Review my changes"
✅ "Review my migration changes for issues #Git Diff"

❌ "Convert all javax imports"
✅ "Convert all javax imports to jakarta in this package #Folder src/main/java/com/enterprise/user"
```

### Using Kiro Specs
- Start by creating a requirements document defining the migration scope (e.g., Java 8→21)
- Kiro generates a design document with the migration strategy
- The design is broken into executable tasks you can track and complete
- Review each task's changes before committing
- Use Kiro Chat to ask about significant changes: "Explain why this task changed [file]"
- Track progress through task completion status

### Using Kiro Hooks
- Configure Hooks to trigger automated review on every file save
- Hooks provide continuous code quality and security feedback as you work
- Focus on security findings first, then code quality issues
- For on-demand review, use Kiro Chat with #Git Diff to review accumulated changes
- Re-run after fixes to verify issues are resolved

---

## Kiro Skills

Kiro Skills are reusable, domain-specific capabilities that automate repetitive migration patterns. You create a Skill by defining what it does, test it on sample files, optimize its behavior, and then trigger it across your codebase.

### How to Work with Skills
1. **Create**: Define a new Skill in Kiro IDE specifying the automation pattern (e.g., "convert Date API to LocalDateTime across Java files")
2. **Test**: Run the Skill on a single file to verify correct behavior before applying broadly
3. **Optimize**: Refine the Skill's instructions based on test results to handle edge cases
4. **Trigger**: Invoke the Skill on target files or folders to apply the pattern at scale

### Workshop Skills

| Skill | Module | Purpose |
|-------|--------|---------|
| Java 8→21 Migration Skill | Module 2 | Automates Date API modernization (`Date` → `LocalDateTime`), deprecated API removal, and Java 21 pattern adoption (switch expressions, pattern matching, `Cleaner` API) |
| Jakarta Namespace Migration Skill | Module 3 | Automates `javax.*` → `jakarta.*` package rename across all Java files (servlet, persistence, validation, etc.) |
| Spring Security Upgrade Skill | Module 3 | Automates `WebSecurityConfigurerAdapter` → `SecurityFilterChain` bean pattern, including `authorizeRequests()` → `authorizeHttpRequests()` |
| JUnit 4→5 Migration Skill | Module 4 | Automates test annotation conversion (`@Before` → `@BeforeEach`, `@RunWith` → `@ExtendWith`), assertion updates (`Assert.*` → `Assertions.*`), and lifecycle changes |

### Tips for Effective Skills
- Keep each Skill focused on one migration pattern for reliability
- Test on a representative file before running across the project
- Chain Skills in sequence: run Jakarta Namespace Skill before Spring Security Upgrade Skill
- Review Skill output with Kiro Hooks to catch edge cases

---

## Kiro Custom Agents

Kiro Custom Agents are user-defined specialized agents configured for specific migration tasks. Each agent has tailored instructions, expertise scope, and tool access, making it effective at a focused set of tasks.

### How to Work with Custom Agents
1. **Create**: Define a new Custom Agent in Kiro IDE with a name, description, and expertise scope
2. **Configure**: Provide the agent with specific instructions about its domain (e.g., Java 8→21 migration rules, target patterns, known pitfalls)
3. **Use**: Delegate tasks to the agent via Kiro Chat — the agent applies its specialized knowledge to produce better results than generic prompts
4. **Best Practices**: Create one agent per major migration domain; keep instructions focused; update agent configuration as you learn new patterns

### Workshop Custom Agents

| Agent | Module | Purpose | Configuration |
|-------|--------|---------|---------------|
| Java Migration Agent | Module 2 | Specialized for Java 8→21 transformation tasks including Date API modernization, deprecated API replacement, and Java 21 feature adoption | Configured with Java 8→21 migration rules, target Java 21 patterns, and knowledge of common migration pitfalls |
| Spring Migration Agent | Module 3 | Specialized for Spring 5→6 and Jakarta namespace migration including dependency updates, configuration modernization, and security pattern upgrades | Configured with Spring 5→6 migration rules, Jakarta namespace mappings, and Spring Security 6 patterns |

### Tips for Effective Custom Agents
- Plan which agents you need during Module 1 environment setup (one per major framework migration)
- Give agents specific, detailed instructions about the migration scope and constraints
- Use agents in combination with Skills: delegate the task to the agent, then run a Skill for repetitive patterns
- Update agent instructions as you discover new patterns during the workshop

---

## Kiro Powers

Kiro Powers are packaged bundles of documentation, steering files, and optional MCP servers that extend Kiro IDE's capabilities for specific domains. Powers give Kiro deep knowledge about a topic so it can provide better guidance and tooling.

### What's in a Power
- **POWER.md**: The main documentation file describing the Power's purpose, contents, and usage instructions
- **Steering files**: `.kiro/steering/*.md` files providing domain-specific context, constraints, and patterns
- **Optional MCP servers**: Model Context Protocol servers that provide specialized tools and data access for the domain

### How to Browse and Install Powers
1. Open the Powers management panel in Kiro IDE
2. Browse the Powers catalog for relevant Powers (e.g., AWS documentation, framework migration guides)
3. Install a Power to add its documentation and steering files to your workspace
4. The Power's knowledge becomes available to Kiro Chat and other features immediately

### How to Activate and Use Powers
1. Activate an installed Power from the Powers panel when you need its capabilities
2. Kiro Chat automatically incorporates the Power's documentation and steering context
3. If the Power includes MCP servers, their tools become available for Kiro to use
4. Deactivate Powers you no longer need to keep context focused

### How to Build Custom Powers with Power Builder
1. Use the Kiro Power Builder (a built-in Power) to create a new Power
2. Define the POWER.md with your domain documentation and best practices
3. Add steering files with migration patterns, constraints, and guidelines
4. Optionally configure MCP server integrations for specialized tooling
5. Validate the Power by testing it in your workspace
6. Share the Power with your team by publishing it or distributing the Power bundle

### Workshop Powers

| Power | Module | Purpose | Contents |
|-------|--------|---------|----------|
| Java Framework Migration Power | Module 2 (built), Module 3 (activated) | Packages Java 8→21 and Spring 5→6 migration documentation, best practices, and steering files into a reusable bundle | POWER.md with migration guide, steering files for Java 8→21 patterns, optionally an MCP server for migration-specific tooling |
| Platform Deployment Power | Module 5 | Bundles JBoss EAP, WebSphere, and Mainframe deployment knowledge into a shareable Power for platform teams | POWER.md with platform deployment guide, steering files for each platform's configuration requirements, deployment descriptor templates |

### Tips for Effective Powers
- Install relevant Powers from the catalog before starting migration work (Module 1)
- Build a custom Power when you accumulate enough domain knowledge to package (Module 2)
- Activate the Java Framework Migration Power during Spring migration (Module 3) to reuse Java migration context
- Share Powers with your team so everyone benefits from documented migration patterns
- Keep Power documentation focused and up-to-date as you discover new patterns

---

## Time Management

### If Running Behind Schedule

**Priority 1 (Must Complete):**
- Module 1: Setup and baseline
- Module 2: Java 21 migration
- Module 3: Spring 6 migration
- Basic testing validation

**Priority 2 (Important):**
- Complete test suite migration
- Integration testing
- Code coverage validation

**Priority 3 (Nice to Have):**
- Platform-specific configuration
- Performance optimization
- Advanced testing scenarios

### If Ahead of Schedule

**Enhancement Activities:**
- Explore Java 21 new features (Virtual Threads, Pattern Matching)
- Implement Spring 6 best practices
- Optimize performance
- Enhance test coverage
- Document lessons learned

---

## Emergency Procedures

### If Migration Breaks Everything
```bash
# Rollback to baseline
git reset --hard pre-migration-baseline

# Start over with smaller scope
# Ask Kiro: "What's the safest migration approach for this project?"
```

### If Stuck on an Issue
1. Copy full error message
2. Ask Kiro with complete context
3. Try Kiro's solution
4. If still stuck, ask for alternative approaches
5. Document issue for team review

### If Tests Won't Pass
1. Isolate failing tests
2. Ask Kiro about each failure individually
3. Check for environment issues
4. Verify dependencies are correct
5. Consider temporary @Disabled with TODO

---

## Success Metrics

### Technical Validation
- [ ] All applications compile successfully
- [ ] All unit tests pass (100%)
- [ ] Integration tests pass (100%)
- [ ] Code coverage ≥ 80%
- [ ] No security vulnerabilities
- [ ] Performance baseline met or exceeded

### Platform Validation
- [ ] BDP apps deploy to JBoss EAP
- [ ] BPT apps deploy to WebSphere
- [ ] BCN apps run on mainframe
- [ ] All integrations functional (DB, messaging)

### Team Readiness
- [ ] Team comfortable with Kiro IDE
- [ ] Common patterns documented
- [ ] Troubleshooting guide created
- [ ] Migration process repeatable

---

## Post-Workshop Resources

### Documentation
- [Kiro IDE User Guide]([Kiro IDE Documentation URL])
- [Java 21 Migration Guide](https://docs.oracle.com/en/java/javase/21/migrate/)
- [Spring Framework 6 Documentation](https://docs.spring.io/spring-framework/reference/)
- [Jakarta EE Migration Guide](https://jakarta.ee/resources/)

### Support
- AWS Support for Kiro IDE issues
- Internal team knowledge base
- Workshop materials and examples

---

## Quick Command Reference

### Git Commands
```bash
# Create migration branch
git checkout -b feature/java21-spring6-migration

# Commit baseline
git add . && git commit -m "Baseline before migration"

# Tag baseline
git tag pre-migration-baseline

# View changes
git diff

# Rollback if needed
git reset --hard pre-migration-baseline
```

### Maven Commands
```bash
# Clean build
mvn clean compile

# Run tests
mvn test

# Run specific test
mvn test -Dtest=TestClassName

# Package application
mvn clean package

# Run Spring Boot app
mvn spring-boot:run

# Generate coverage report
mvn clean test jacoco:report
```

### Verification Commands
```bash
# Check Java version
java -version

# Check Maven version
mvn -version

# Search for javax imports
grep -r "import javax\." src/

# Count test files
find src/test -name "*Test.java" | wc -l

# Check WAR structure
jar -tf target/application.war
```

---

## Workshop Completion Certificate

After completing all modules, you should be able to:
- ✅ Use Kiro IDE effectively including Specs, Hooks, Steering, Skills, Custom Agents, and Powers
- ✅ Migrate Java 8 applications to Java 21
- ✅ Migrate Spring 5.2.3 applications to Spring 6
- ✅ Update and validate comprehensive test suites
- ✅ Deploy to multiple enterprise platforms
- ✅ Troubleshoot migration issues independently
- ✅ Apply migration patterns to remaining applications

**Next Steps**: Apply learnings to production migration of 27 applications
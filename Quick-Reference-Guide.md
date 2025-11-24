# Amazon Q Developer IDE Workshop - Quick Reference Guide

## Workshop Overview

**Duration**: 8 hours (9 AM - 5 PM) + Optional 1.5 hours  
**Target**: Java 8 + Spring 5.2.3 → Java 21 + Spring 6  
**Applications**: 27 apps (25 BDP/JBoss, 2 BPT/WebSphere, BCN/Mainframe)

---

## Essential Q Developer Commands

| Command | Shortcut | Purpose |
|---------|----------|---------|
| Open Q Chat | Click Q icon | Ask questions, get guidance |
| `/transform` | Command Palette | Automated code transformation |
| `/review` | Command Palette | Code quality & security review |
| Inline suggestions | Tab to accept | Code completion |
| Command Palette | Ctrl+Shift+P / Cmd+Shift+P | Access all Q commands |

---

## Module-by-Module Quick Guide

### Module 1: Environment Setup (90 min)

**Key Tasks:**
1. Install Amazon Q extension
2. Authenticate with AWS
3. Open and analyze project
4. Create migration plan
5. Establish baseline

**Critical Q Queries:**
```
"Analyze this Java 8 + Spring 5.2.3 application for migration complexity"
"List all dependencies that need updates for Java 21 and Spring 6"
"What are the highest risk areas in this migration?"
"Generate a pre-migration checklist"
```

**Completion Criteria:**
- [ ] Q extension working
- [ ] Project building successfully
- [ ] Migration plan documented
- [ ] Git branch created
- [ ] All tests passing

---

### Module 2: Java 8 → Java 21 (120 min)

**Key Tasks:**
1. Run `/transform` for Java upgrade
2. Review transformation results
3. Fix compilation errors
4. Update dependencies
5. Validate with tests

**Critical Q Queries:**
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

**Critical Q Queries:**
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

**Critical Q Queries:**
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

**Critical Q Queries:**

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

### Compilation Errors

**Error**: `cannot find symbol: class [JavaxClass]`
```
Q: "Getting 'cannot find symbol' for javax classes after Spring 6 upgrade. What's missing?"
Solution: Add jakarta.* dependency, convert imports
```

**Error**: `method [X] has been deprecated and marked for removal`
```
Q: "How do I replace [deprecated method] in Java 21?"
Solution: Use Q's suggested modern alternative
```

### Runtime Errors

**Error**: `NoClassDefFoundError: javax/servlet/...`
```
Q: "NoClassDefFoundError for javax.servlet after Spring 6 upgrade. What's wrong?"
Solution: Verify jakarta.servlet dependency, check all imports converted
```

**Error**: `Unable to load ApplicationContext`
```
Q: "Spring test context fails to load after Spring 6 upgrade: [error]"
Solution: Update test configuration, fix Spring 6 incompatibilities
```

### Test Failures

**Error**: `IllegalAccessException` in tests
```
Q: "Getting IllegalAccessException in tests after Java 21 upgrade. How do I configure JVM arguments?"
Solution: Add --add-opens JVM arguments to test configuration
```

**Error**: Mocks are null
```
Q: "Mocks are null in JUnit 5 test. What's wrong with my mock setup?"
Solution: Add @ExtendWith(MockitoExtension.class)
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
- [ ] Ask Q before making assumptions
- [ ] Use `/review` to catch issues early

### After Migration
- [ ] Full test suite passing
- [ ] Code coverage maintained/improved
- [ ] Security review clean
- [ ] Performance benchmarks met
- [ ] Documentation updated

---

## Q Developer Pro Tips

### Getting Better Answers
1. **Be specific**: Include error messages, code snippets, versions
2. **Provide context**: Mention Java 21, Spring 6, target platform
3. **Ask follow-ups**: "Explain why", "Show alternative", "What if..."
4. **Request examples**: "Show me an example", "Generate code for..."

### Effective Queries
```
❌ "How do I fix this error?"
✅ "How do I fix this Java 21 compilation error: [full error message]"

❌ "Update my config"
✅ "Migrate this Spring Security configuration to Spring 6: [paste code]"

❌ "Tests failing"
✅ "This JUnit test fails after Spring 6 migration with error: [error]. Test code: [paste code]. How do I fix it?"
```

### Using /transform
- Run on specific modules first (test on small scope)
- Review changes before committing
- Ask Q to explain significant changes
- Use git diff to track all modifications

### Using /review
- Run before committing
- Focus on security findings first
- Ask Q how to fix each issue
- Re-run after fixes to verify

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
# Ask Q: "What's the safest migration approach for this project?"
```

### If Stuck on an Issue
1. Copy full error message
2. Ask Q with complete context
3. Try Q's solution
4. If still stuck, ask for alternative approaches
5. Document issue for team review

### If Tests Won't Pass
1. Isolate failing tests
2. Ask Q about each failure individually
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
- [ ] Team comfortable with Q Developer
- [ ] Common patterns documented
- [ ] Troubleshooting guide created
- [ ] Migration process repeatable

---

## Post-Workshop Resources

### Documentation
- [Amazon Q Developer User Guide](https://docs.aws.amazon.com/amazonq/latest/qdeveloper-ug/)
- [Java 21 Migration Guide](https://docs.oracle.com/en/java/javase/21/migrate/)
- [Spring Framework 6 Documentation](https://docs.spring.io/spring-framework/reference/)
- [Jakarta EE Migration Guide](https://jakarta.ee/resources/)

### Support
- AWS Support for Q Developer issues
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
- ✅ Use Amazon Q Developer IDE extension effectively
- ✅ Migrate Java 8 applications to Java 21
- ✅ Migrate Spring 5.2.3 applications to Spring 6
- ✅ Update and validate comprehensive test suites
- ✅ Deploy to multiple enterprise platforms
- ✅ Troubleshoot migration issues independently
- ✅ Apply migration patterns to remaining applications

**Next Steps**: Apply learnings to production migration of 27 applications
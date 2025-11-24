# Amazon Q Developer IDE Workshop Agent
## Java 8 + Spring 5.2.3 → Java 21 + Spring 6 Migration Workshop

---

## Workshop Agent Overview

**Purpose:** Guide enterprise teams through Java framework modernization using Amazon Q Developer IDE Extension  
**Target:** 27 applications across BDP (25 apps), BPT (2 apps), and BCN platforms  
**Approach:** Hands-on, IDE-centric migration with real-time validation

---

## Workshop Schedule (8-Hour Day: 9:00 AM - 5:00 PM)

**9:00 AM - 10:30 AM**: Module 1 - Environment Setup & Assessment (90 min)  
**10:30 AM - 10:45 AM**: Break (15 min)  
**10:45 AM - 12:45 PM**: Module 2 - Java 8 → Java 21 Migration (120 min)  
**12:45 PM - 1:45 PM**: Lunch Break (60 min)  
**1:45 PM - 3:45 PM**: Module 3 - Spring 5.2.3 → Spring 6 Migration (120 min)  
**3:45 PM - 4:00 PM**: Break (15 min)  
**4:00 PM - 5:30 PM**: Module 4 - Testing & Validation (90 min)  

**Optional Extended Session (5:30 PM - 7:00 PM)**: Module 5 - Platform-Specific Validation (90 min)

**Total Core Workshop**: 8 hours (9 AM - 5 PM with breaks)  
**Total with Optional Module**: 9.5 hours

---

## Workshop Structure

### Module 1: Environment Setup & Assessment (90 minutes)

#### Setup Amazon Q Developer IDE Extension
```
Prerequisites:
- VS Code or IntelliJ IDEA installed
- Amazon Q Developer IDE extension installed
- AWS credentials configured
- Access to sample application codebase
```

#### Initial Assessment Activities
1. **Open sample application in IDE**
2. **Use Amazon Q Chat**: "Analyze this Java 8 + Spring 5.2.3 application for migration complexity"
3. **Review project structure** with Q Developer assistance
4. **Identify critical business logic** requiring careful migration

---

### Module 2: Phase 1 - Java 8 → Java 21 Migration (120 minutes)

#### Step 1: Run Amazon Q Code Transformation

**Using /transform command:**
```
1. Open Command Palette (Ctrl+Shift+P / Cmd+Shift+P)
2. Select "Amazon Q: Transform"
3. Choose transformation type: "Upgrade Java version"
4. Select source: Java 8
5. Select target: Java 21
6. Review transformation plan
7. Execute transformation
```

#### Step 2: Review Transformation Results

**Use Amazon Q Chat for analysis:**
- "Explain the changes made in [filename]"
- "Are there any potential issues with this transformation?"
- "What manual fixes are needed after this transformation?"

#### Step 3: Fix Compilation Errors

**Interactive error resolution:**
```
1. Build project to identify errors
2. For each error, use Q Chat:
   - "How do I fix this Java 21 compilation error: [paste error]"
   - "What is the Java 21 equivalent of [deprecated API]"
3. Apply fixes with Q Developer inline suggestions
4. Validate changes compile successfully
```

---

### Module 3: Phase 2 - Spring 5.2.3 → Spring 6 Migration (120 minutes)

#### Step 1: Dependency Analysis

**Use Amazon Q Chat:**
```
Questions to ask:
- "What Spring 6 dependencies do I need for this pom.xml?"
- "Which third-party libraries need updates for Spring 6 compatibility?"
- "Generate updated pom.xml with Spring 6 and Jakarta EE dependencies"
```

#### Step 2: Jakarta EE Namespace Migration

**Manual migration with Q assistance:**
```
For each file with javax.* imports:
1. Ask Q: "Convert these javax imports to jakarta for Spring 6"
2. Review suggested changes
3. Apply changes file by file
4. Use Q to validate: "Check if all javax imports are migrated"
```

#### Step 3: Spring Configuration Updates

**Interactive configuration migration:**
```
For Spring configuration classes:
1. Open configuration file
2. Ask Q: "Migrate this Spring 5 configuration to Spring 6"
3. Review deprecated API replacements
4. Apply changes with inline suggestions
5. Ask Q: "Validate this Spring 6 configuration"
```

**Example Q Chat queries:**
- "How do I migrate WebSecurityConfigurerAdapter to Spring 6?"
- "Update this @RequestMapping to use Spring 6 best practices"
- "Generate Spring 6 compatible DataSource configuration"

#### Step 4: Update Application Properties

**Configuration file updates:**
```
1. Open application.properties/application.yml
2. Ask Q: "Update these Spring Boot properties for Spring 6"
3. Review and apply suggested changes
4. Ask Q: "Are there any deprecated properties here?"
```

---

### Module 4: Testing & Validation (90 minutes)

#### Step 1: Update Test Framework

**JUnit 4 → JUnit 5 migration:**
```
For each test class:
1. Ask Q: "Migrate this JUnit 4 test to JUnit 5"
2. Review annotation changes (@Before → @BeforeEach)
3. Update assertions (Assert.assertEquals → Assertions.assertEquals)
4. Apply changes and run tests
```

#### Step 2: Fix Test Failures

**Interactive test debugging:**
```
For each failing test:
1. Copy error message
2. Ask Q: "How do I fix this Spring 6 test failure: [error]"
3. Apply suggested fixes
4. Re-run tests
5. Iterate until all tests pass
```

#### Step 3: Integration Testing

**Database and messaging validation:**
```
Q Chat queries:
- "Generate integration test for SQL Server connection with Java 21"
- "Create test for IBM MQ message listener in Spring 6"
- "Validate MongoDB driver compatibility with this configuration"
```

---

### Module 5: Platform-Specific Validation (90 minutes)

#### BDP Platform (JBoss EAP) - 25 Applications

**Platform validation queries:**
```
- "What JBoss EAP version supports Java 21?"
- "Generate deployment descriptor for Spring 6 on JBoss EAP"
- "Check for JBoss module conflicts with Spring 6"
```

#### BPT Platform (WebSphere) - 2 Applications

**WebSphere-specific queries:**
```
- "How do I deploy Spring 6 application on WebSphere?"
- "Generate WebSphere-compatible web.xml for Spring 6"
- "What WebSphere version supports Java 21?"
```

#### BCN Platform (Mainframe)

**Mainframe considerations:**
```
- "What are Java 21 memory optimization strategies for mainframe?"
- "How do I minimize resource usage for mainframe deployment?"
- "Generate mainframe-optimized Spring 6 configuration"
```

---

## Amazon Q Developer IDE Features for Migration

### 1. Code Transformation (/transform)
**When to use:**
- Initial Java version upgrade
- Bulk API replacements
- Framework version updates

**How to use:**
```
Command Palette → Amazon Q: Transform
- Select transformation type
- Review changes before applying
- Validate results with Q Chat
```

### 2. Chat Interface
**When to use:**
- Understanding transformation results
- Getting migration guidance
- Generating code snippets
- Troubleshooting errors

**Example queries:**
```
- "Explain this transformation"
- "How do I fix [error]?"
- "Generate [configuration/test/code]"
- "Validate [file/configuration]"
```

### 3. Inline Code Suggestions
**When to use:**
- Writing new code
- Fixing compilation errors
- Implementing best practices

**How to use:**
```
- Start typing code
- Accept suggestions with Tab
- Use Alt+C for manual trigger
```

### 4. Code Review (/review)
**When to use:**
- Pre-commit validation
- Security checks
- Best practices verification

**How to use:**
```
Command Palette → Amazon Q: Review Code
- Review findings in Code Issues Panel
- Apply suggested fixes
- Re-review after changes
```

---

## Workshop Hands-On Exercises

### Exercise 1: Simple Service Migration (30 min)
```
Task: Migrate UserService.java from Java 8 + Spring 5 to Java 21 + Spring 6

Steps:
1. Run /transform on UserService.java
2. Fix compilation errors with Q Chat
3. Update Spring annotations
4. Migrate unit tests
5. Validate with /review
```

### Exercise 2: Configuration Migration (45 min)
```
Task: Migrate Spring Security configuration to Spring 6

Steps:
1. Ask Q: "Migrate this SecurityConfig to Spring 6"
2. Replace WebSecurityConfigurerAdapter
3. Update authentication configuration
4. Test security endpoints
5. Validate with integration tests
```

### Exercise 3: Database Integration (45 min)
```
Task: Update database configuration for Java 21 + Spring 6

Steps:
1. Ask Q: "Generate Spring 6 DataSource configuration for SQL Server"
2. Update JDBC driver version
3. Configure connection pool (HikariCP)
4. Create integration test
5. Validate database connectivity
```

### Exercise 4: Full Application Migration (90 min)
```
Task: Migrate complete application from Java 8 + Spring 5.2.3 to Java 21 + Spring 6

Steps:
1. Run /transform for Java upgrade
2. Update all dependencies with Q assistance
3. Migrate javax.* to jakarta.*
4. Update Spring configurations
5. Fix all compilation errors
6. Update and run all tests
7. Validate with /review
8. Document changes and lessons learned
```

---

## Common Migration Patterns with Q Developer

### Pattern 1: Dependency Updates
```
Q Chat: "Generate updated pom.xml with Java 21 and Spring 6 dependencies"

Review and apply:
- Spring Framework 6.x
- Jakarta EE dependencies
- Updated database drivers
- Test framework updates
```

### Pattern 2: Import Migration
```
Q Chat: "Convert all javax imports to jakarta in this file"

Validate:
- javax.servlet → jakarta.servlet
- javax.persistence → jakarta.persistence
- javax.validation → jakarta.validation
```

### Pattern 3: Configuration Modernization
```
Q Chat: "Modernize this Spring configuration for Spring 6"

Apply changes:
- Remove deprecated classes
- Use functional configuration
- Update security patterns
```

### Pattern 4: Test Framework Updates
```
Q Chat: "Migrate this JUnit 4 test to JUnit 5"

Update:
- Annotations (@Before → @BeforeEach)
- Assertions (Assert → Assertions)
- Test lifecycle methods
```

---

## Troubleshooting Guide

### Issue: Compilation Errors After Transformation
```
Solution:
1. Copy error message
2. Ask Q: "How do I fix this error: [paste error]"
3. Apply suggested fix
4. If still failing, ask: "Alternative solutions for [error]"
```

### Issue: Test Failures After Migration
```
Solution:
1. Run tests and capture failures
2. Ask Q: "Why is this test failing after Spring 6 migration?"
3. Review Spring 6 breaking changes
4. Update test configuration
5. Re-run tests
```

### Issue: Dependency Conflicts
```
Solution:
1. Ask Q: "Resolve dependency conflicts in this pom.xml"
2. Review suggested dependency management
3. Update version properties
4. Clean and rebuild project
```

### Issue: Runtime Errors
```
Solution:
1. Copy stack trace
2. Ask Q: "Explain this runtime error in Spring 6 context"
3. Review configuration issues
4. Apply suggested fixes
5. Test thoroughly
```

---

## Success Metrics

### Technical Validation
- [ ] All applications compile successfully
- [ ] All unit tests pass
- [ ] Integration tests validate connectivity
- [ ] No security vulnerabilities introduced
- [ ] Performance baseline maintained or improved

### Platform Validation
- [ ] BDP applications deploy to JBoss EAP
- [ ] BPT applications deploy to WebSphere
- [ ] BCN applications run on mainframe
- [ ] All integrations (SQL Server, DB2, IBM MQ, MongoDB) functional

### Team Readiness
- [ ] Team comfortable using Q Developer IDE
- [ ] Common patterns documented
- [ ] Troubleshooting guide created
- [ ] Migration process repeatable

---

## Post-Workshop Action Items

### Immediate (Week 1)
1. Apply learnings to pilot application (BPT - 2 apps)
2. Document platform-specific issues
3. Create fix templates for common problems
4. Establish validation checklist

### Short-term (Weeks 2-4)
1. Migrate BDP applications (25 apps) systematically
2. Track and resolve common issues
3. Update documentation with lessons learned
4. Validate on target platforms

### Long-term (Months 2-3)
1. Complete BCN mainframe migration
2. Establish continuous modernization process
3. Monitor production performance
4. Plan next modernization phase

---

## Resources

### Amazon Q Developer Documentation
- [IDE Extension User Guide](https://docs.aws.amazon.com/amazonq/latest/qdeveloper-ug/)
- [Code Transformation Guide](https://docs.aws.amazon.com/amazonq/latest/qdeveloper-ug/code-transformation.html)
- [Best Practices](https://docs.aws.amazon.com/amazonq/latest/qdeveloper-ug/best-practices.html)

### Migration References
- Java 21 Migration Guide
- Spring Framework 6 Documentation
- Jakarta EE Migration Guide

### Support Channels
- AWS Support
- Amazon Q Developer Community
- Internal team knowledge base

---

*This workshop agent provides structured guidance for using Amazon Q Developer IDE Extension to modernize 27 enterprise applications from Java 8 + Spring 5.2.3 to Java 21 + Spring 6.*

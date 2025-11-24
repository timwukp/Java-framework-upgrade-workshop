# Amazon Q Developer IDE Workshop - Detailed Agenda

## Java 8 + Spring 5.2.3 → Java 21 + Spring 6 Migration

**Date**: [Workshop Date]  
**Duration**: 8 hours (9:00 AM - 5:30 PM)  
**Format**: Hands-on training with Amazon Q Developer IDE Extension  
**Participants**: [Team Name/Count]

---

## Pre-Workshop Requirements (Complete Before Day 1)

**Participants must have:**
- [ ] Laptop with VS Code or IntelliJ IDEA installed
- [ ] Amazon Q Developer IDE extension installed
- [ ] AWS credentials configured (Builder ID or IAM Identity Center)
- [ ] Java 21 JDK installed
- [ ] Maven 3.8+ or Gradle 7+ installed
- [ ] Git installed and configured
- [ ] Sample application cloned and building
- [ ] Access to workshop materials repository

**Verify setup:**
```bash
java -version  # Should show Java 21
mvn -version   # Should show Maven 3.8+
git --version  # Should show Git 2.x+
```

---

## Day 1: Core Migration Workshop

### 9:00 AM - 9:15 AM: Welcome & Introduction (15 min)

**Topics:**
- Workshop objectives and outcomes
- Migration scope: 27 applications overview
- Amazon Q Developer capabilities
- Workshop structure and schedule
- Q&A setup and support channels

**Activities:**
- Instructor introduction
- Participant introductions
- Verify all setups working
- Share workshop materials

---

### 9:15 AM - 10:30 AM: Module 1 - Environment Setup & Assessment (75 min)

#### 9:15 AM - 9:35 AM: Amazon Q Setup (20 min)
**Hands-on:**
- Install and authenticate Amazon Q extension
- Test Q Chat functionality
- Explore Q Developer interface
- Run first Q query

**Q Queries to practice:**
```
"Hello, can you help me with Java migration?"
"What can you help me with?"
"Explain how /transform works"
```

#### 9:35 AM - 9:50 AM: Project Setup (15 min)
**Hands-on:**
- Open sample application
- Verify build successful
- Explore project structure with Q
- Create git branch for migration

**Commands:**
```bash
git checkout -b feature/java21-spring6-migration
git add . && git commit -m "Baseline before migration"
git tag pre-migration-baseline
```

#### 9:50 AM - 10:20 AM: Initial Assessment (30 min)
**Hands-on:**
- Run Q analysis on project
- Identify dependencies to update
- Document risk areas
- Create migration plan

**Key Q Queries:**
```
"Analyze this Java 8 + Spring 5.2.3 application for migration complexity"
"List all dependencies that need updates"
"What are the highest risk areas?"
```

#### 10:20 AM - 10:30 AM: Baseline Validation (10 min)
**Hands-on:**
- Run `/review` on current code
- Execute all tests
- Document baseline metrics
- Review migration checklist

---

### 10:30 AM - 10:45 AM: BREAK (15 min)

---

### 10:45 AM - 12:45 PM: Module 2 - Java 8 → Java 21 Migration (120 min)

#### 10:45 AM - 11:00 AM: Transformation Setup (15 min)
**Hands-on:**
- Understand /transform command
- Review transformation options
- Prepare for code transformation
- Set expectations

**Q Query:**
```
"What should I expect when transforming Java 8 to Java 21?"
```

#### 11:00 AM - 11:30 AM: Execute Transformation (30 min)
**Hands-on:**
- Run `/transform` command
- Monitor transformation progress
- Review transformation summary
- Examine changed files

**Activity:**
```
1. Command Palette → "Amazon Q: Transform"
2. Select: Java 8 → Java 21
3. Review changes in git diff
4. Ask Q to explain key changes
```

#### 11:30 AM - 12:15 PM: Fix Compilation Errors (45 min)
**Hands-on:**
- Build project and collect errors
- Fix deprecated API usage
- Update type inference
- Resolve module issues

**For each error:**
```
1. Copy error message
2. Ask Q: "How do I fix this Java 21 error: [error]"
3. Apply solution
4. Rebuild and verify
```

**Common fixes:**
- Date API → LocalDateTime
- finalize() → Cleaner API
- SecurityManager removal
- Switch expressions

#### 12:15 PM - 12:45 PM: Dependency Updates & Validation (30 min)
**Hands-on:**
- Update Java version in pom.xml
- Update Maven plugins
- Update third-party libraries
- Run tests and validate

**Q Queries:**
```
"Update Maven configuration for Java 21"
"Is [library] version [X] compatible with Java 21?"
"What plugin versions work with Java 21?"
```

---

### 12:45 PM - 1:45 PM: LUNCH BREAK (60 min)

---

### 1:45 PM - 3:45 PM: Module 3 - Spring 5.2.3 → Spring 6 Migration (120 min)

#### 1:45 PM - 2:15 PM: Dependency Migration (30 min)
**Hands-on:**
- Analyze current Spring dependencies
- Update to Spring 6 versions
- Add Jakarta EE dependencies
- Update pom.xml

**Q Queries:**
```
"Generate updated Spring 6 dependencies for my pom.xml"
"What Jakarta EE dependencies do I need?"
"Update these Spring dependencies to Spring 6"
```

#### 2:15 PM - 2:40 PM: Namespace Migration (25 min)
**Hands-on:**
- Identify all javax.* imports
- Convert to jakarta.* imports
- Verify complete migration
- Handle edge cases

**Q Query:**
```
"Convert all javax imports to jakarta in this file: [paste code]"
```

**Bulk replacement:**
```
javax.servlet.* → jakarta.servlet.*
javax.persistence.* → jakarta.persistence.*
javax.validation.* → jakarta.validation.*
```

#### 2:40 PM - 3:30 PM: Spring Configuration Updates (50 min)
**Hands-on:**
- Update Security configuration
- Modernize Web configuration
- Update DataSource configuration
- Update Controller annotations

**Key migrations:**
```java
// Security
WebSecurityConfigurerAdapter → SecurityFilterChain

// Controllers
@RequestMapping(method = GET) → @GetMapping

// Configuration
authorizeRequests() → authorizeHttpRequests()
```

**Q Queries:**
```
"Migrate this Spring Security configuration to Spring 6"
"How do I replace WebSecurityConfigurerAdapter?"
"Update this controller for Spring 6 best practices"
```

#### 3:30 PM - 3:45 PM: Application Properties & Validation (15 min)
**Hands-on:**
- Update application.properties
- Update logging configuration
- Build and start application
- Test endpoints

**Q Query:**
```
"Review these Spring Boot properties for Spring 6 compatibility"
```

---

### 3:45 PM - 4:00 PM: BREAK (15 min)

---

### 4:00 PM - 5:30 PM: Module 4 - Testing & Validation (90 min)

#### 4:00 PM - 4:30 PM: Test Framework Migration (30 min)
**Hands-on:**
- Update test dependencies
- Migrate JUnit 4 → JUnit 5
- Update Mockito usage
- Fix test annotations

**Q Query:**
```
"Migrate this JUnit 4 test to JUnit 5 for Spring 6: [paste test]"
```

**Key changes:**
```java
@Before → @BeforeEach
@After → @AfterEach
Assert.* → Assertions.*
@RunWith(SpringRunner.class) → @ExtendWith(SpringExtension.class)
```

#### 4:30 PM - 4:50 PM: Unit Test Validation (20 min)
**Hands-on:**
- Run all unit tests
- Fix failing tests
- Verify test coverage
- Document issues

**Commands:**
```bash
mvn test
mvn test -Dtest=SpecificTest
```

**For failures:**
```
Ask Q: "This test fails after Spring 6 migration: [error]. How do I fix it?"
```

#### 4:50 PM - 5:15 PM: Integration Testing (25 min)
**Hands-on:**
- Generate database integration tests
- Generate REST API tests
- Test external integrations
- Validate connectivity

**Q Queries:**
```
"Generate Spring 6 integration test for SQL Server database"
"Generate REST API integration test using MockMvc"
"Generate test for IBM MQ connection"
```

#### 5:15 PM - 5:30 PM: Final Validation & Review (15 min)
**Hands-on:**
- Run `/review` on migrated code
- Execute full test suite
- Verify code coverage
- Review security findings
- Document completion status

**Final checks:**
```bash
mvn clean verify
mvn jacoco:report
```

---

### 5:30 PM - 5:45 PM: Day 1 Wrap-up (15 min)

**Topics:**
- Review what was accomplished
- Address outstanding questions
- Preview optional Module 5
- Homework (if applicable)
- Feedback collection

**Completion checklist review:**
- [ ] Java 21 migration complete
- [ ] Spring 6 migration complete
- [ ] All tests passing
- [ ] Application running successfully

---

## Optional Extended Session

### 5:45 PM - 7:15 PM: Module 5 - Platform-Specific Validation (90 min)

**Note**: This module is optional and covers platform-specific deployment configurations.

#### 5:45 PM - 6:20 PM: JBoss EAP Configuration (35 min)
**Hands-on:**
- Verify JBoss compatibility
- Create deployment descriptors
- Configure module exclusions
- Package as WAR
- Test deployment

**Q Queries:**
```
"What JBoss EAP version supports Java 21 and Spring 6?"
"Generate jboss-deployment-structure.xml for Spring 6"
"Update pom.xml to package as WAR for JBoss"
```

#### 6:20 PM - 6:50 PM: WebSphere Configuration (30 min)
**Hands-on:**
- Verify WebSphere compatibility
- Create IBM deployment descriptors
- Configure ClassLoader
- Configure resources
- Test deployment

**Q Queries:**
```
"What WebSphere version supports Java 21 and Spring 6?"
"Generate ibm-web-ext.xml for Spring 6 application"
"Provide WebSphere datasource configuration steps"
```

#### 6:50 PM - 7:15 PM: Mainframe Optimization (25 min)
**Hands-on:**
- Understand mainframe constraints
- Optimize JVM settings
- Configure DB2 integration
- Create deployment package
- Generate startup scripts

**Q Queries:**
```
"How do I optimize Spring 6 for mainframe deployment?"
"Generate JVM arguments for Java 21 on mainframe"
"Generate mainframe-optimized Spring 6 configuration"
```

---

## Post-Workshop Activities

### Immediate (Week 1)
- [ ] Apply learnings to pilot application
- [ ] Document platform-specific issues
- [ ] Create fix templates
- [ ] Share knowledge with team

### Short-term (Weeks 2-4)
- [ ] Migrate remaining applications
- [ ] Track common issues
- [ ] Update documentation
- [ ] Validate on target platforms

### Long-term (Months 2-3)
- [ ] Complete all 27 applications
- [ ] Monitor production performance
- [ ] Establish continuous modernization
- [ ] Plan next modernization phase

---

## Workshop Materials

**Provided:**
- [ ] Module 1: Environment Setup guide
- [ ] Module 2: Java Migration guide
- [ ] Module 3: Spring Migration guide
- [ ] Module 4: Testing & Validation guide
- [ ] Module 5: Platform Validation guide
- [ ] Quick Reference Guide
- [ ] Sample application code
- [ ] Common issues & solutions document

**Participants should bring:**
- [ ] Laptop with required software
- [ ] AWS credentials
- [ ] Notebook for notes
- [ ] Questions about their specific applications

---

## Support During Workshop

**Instructor Support:**
- Main instructor for presentations and guidance
- Hands-on assistance during exercises
- Q&A throughout the day

**Amazon Q Developer:**
- Primary tool for guidance and troubleshooting
- Available for all questions
- Real-time code assistance

**Peer Support:**
- Collaborate with other participants
- Share solutions and approaches
- Learn from each other's challenges

---

## Success Criteria

By end of workshop, participants should:
- [ ] Successfully migrate sample application to Java 21 + Spring 6
- [ ] Be proficient with Amazon Q Developer IDE extension
- [ ] Understand common migration patterns
- [ ] Know how to troubleshoot migration issues
- [ ] Have platform-specific deployment knowledge
- [ ] Be ready to migrate production applications

---

## Feedback & Evaluation

**End of Day Survey:**
- Workshop content quality
- Instructor effectiveness
- Amazon Q Developer usefulness
- Hands-on exercise value
- Suggestions for improvement

**Follow-up (2 weeks later):**
- Application of learnings
- Production migration progress
- Additional support needed
- Success stories and challenges

---

## Contact Information

**Workshop Instructor**: [Name, Email]  
**AWS Support**: [Support channel]  
**Amazon Q Developer**: [Documentation link]  
**Internal Team Lead**: [Name, Email]

---

## Emergency Contacts

**Technical Issues**: [Contact]  
**AWS Account Issues**: [Contact]  
**Facility Issues**: [Contact]

---

**Workshop Version**: 1.0  
**Last Updated**: [Date]  
**Next Review**: [Date]
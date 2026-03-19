# Module 4: Testing & Validation (90 minutes)

## Hands-On Training Guide

### Part 1: Test Framework Migration (30 minutes)

#### Exercise 4.1: Analyze Current Test Suite
**Tool: Kiro Chat - Test Analysis**

**Step 1: Inventory tests**
```
Ask Kiro:
"Analyze my test suite and provide:
1. Total number of test files
2. Test framework versions (JUnit, Mockito, etc.)
3. Which tests need migration for Java 21 + Spring 6
4. Estimated migration effort

#Folder src/test/java"
```

**Step 2: Create test migration plan**
```
Ask Kiro:
"Create a prioritized test migration plan:
1. Unit tests
2. Integration tests
3. End-to-end tests

Which should I migrate first and why?"
```

#### Exercise 4.2: Migrate JUnit 4 to JUnit 5
**Tool: Kiro Chat - Test Migration**

**Update test dependencies:**
```xml
<!-- Ask Kiro: "Update test dependencies from JUnit 4 to JUnit 5 for Spring 6" -->

<!-- BEFORE (JUnit 4) -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>

<!-- AFTER (JUnit 5) - Kiro suggestion -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

**Migrate test class:**
```java
// BEFORE (JUnit 4)
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    
    @Before
    public void setUp() {
        // setup code
    }
    
    @After
    public void tearDown() {
        // cleanup code
    }
    
    @Test
    public void testFindUser() {
        User user = userService.findById(1L);
        assertNotNull(user);
        assertEquals("John", user.getName());
    }
}

// Ask Kiro:
"Migrate this JUnit 4 test to JUnit 5 for Spring 6:
[paste test class]"

// AFTER (JUnit 5) - Kiro suggestion
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
    
    @BeforeEach
    void setUp() {
        // setup code
    }
    
    @AfterEach
    void tearDown() {
        // cleanup code
    }
    
    @Test
    void testFindUser() {
        User user = userService.findById(1L);
        assertNotNull(user);
        assertEquals("John", user.getName());
    }
}
```

#### Exercise 4.2b: Create JUnit 4→5 Migration Skill
**Tool: Kiro Skills**

The JUnit 4 to JUnit 5 migration involves many repetitive, pattern-based transformations across your test suite. Instead of manually converting each test file, create a Kiro Skill to automate these patterns.

**(a) What the Skill Automates**

The "JUnit 4→5 Migration" Skill handles three categories of repetitive test modernization:

1. **Test annotation conversion**: `@Before` → `@BeforeEach`, `@After` → `@AfterEach`, `@BeforeClass` → `@BeforeAll`, `@AfterClass` → `@AfterAll`, `@Ignore` → `@Disabled`
2. **Assertion updates**: `org.junit.Assert.*` → `org.junit.jupiter.api.Assertions.*`, including reordering of message parameters (JUnit 5 places the message as the last argument)
3. **Runner/Extension migration**: `@RunWith(SpringRunner.class)` → `@ExtendWith(SpringExtension.class)`, `@RunWith(MockitoJUnitRunner.class)` → `@ExtendWith(MockitoExtension.class)`
4. **Lifecycle method changes**: Remove `public` modifier from test methods and lifecycle methods (JUnit 5 convention), update import statements

**(b) How to Create the Skill**

**Step 1:** Open the Kiro Skills panel and select "Create Skill"

**Step 2:** Name the skill `junit4-to-junit5-migration` and provide the following description:

```
Skill: JUnit 4→5 Migration

Purpose: Automate the migration of JUnit 4 test classes to JUnit 5 (Jupiter) for Spring 6 compatibility.

Patterns to apply:
- Replace @Before with @BeforeEach, @After with @AfterEach
- Replace @BeforeClass with @BeforeAll, @AfterClass with @AfterAll
- Replace @Ignore with @Disabled
- Replace @RunWith(SpringRunner.class) with @ExtendWith(SpringExtension.class)
- Replace @RunWith(MockitoJUnitRunner.class) with @ExtendWith(MockitoExtension.class)
- Replace @RunWith(Parameterized.class) with @ParameterizedTest patterns
- Update imports from org.junit.* to org.junit.jupiter.api.*
- Update imports from org.junit.Assert.* to org.junit.jupiter.api.Assertions.*
- Remove public modifier from test classes and test methods
- Move assertion message parameter from first to last position
- Replace @Rule ExpectedException with assertThrows()

Constraints:
- Preserve all test logic and assertions
- Maintain existing test method names
- Keep Mockito mock setup unchanged (only update runner/extension)
- Do not modify non-test source files
```

**Step 3:** Test the skill on a single test file first, then review the output before applying to the full test suite.

**(c) When and How to Invoke the Skill**

- **When to use**: Before manually migrating any JUnit 4 test file. Run the skill first to handle the mechanical conversions, then review and handle any edge cases manually.
- **How to invoke**: Open a JUnit 4 test file in the editor, then trigger the skill from the Kiro Skills panel or via Kiro Chat:

```
Ask Kiro:
"Use the junit4-to-junit5-migration skill to migrate this test file
#File UserServiceTest.java"
```

- **Batch processing**: To migrate multiple test files at once, reference the test folder:

```
Ask Kiro:
"Use the junit4-to-junit5-migration skill to migrate all test files in
#Folder src/test/java/com/enterprise/user"
```

> **Tip:** After the skill runs, review the changes using Kiro Chat with `#Git Diff` to verify all transformations are correct before committing.

---

#### Exercise 4.3: Update Mockito Usage
**Tool: Kiro Chat - Mocking Framework**

**Update Mockito version:**
```
Ask Kiro:
"What Mockito version is compatible with Java 21 and Spring 6?
Update my pom.xml mockito dependency."
```

**Modernize mock usage:**
```java
// BEFORE (Old Mockito)
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    
    @Mock
    private UserService userService;
    
    @InjectMocks
    private UserController userController;
    
    @Test
    public void testGetUser() {
        when(userService.findById(1L)).thenReturn(new User("John"));
        User result = userController.getUser(1L);
        verify(userService, times(1)).findById(1L);
    }
}

// Ask Kiro:
"Update this Mockito test for JUnit 5 and Spring 6:
[paste test class]"

// AFTER (Modern Mockito) - Kiro suggestion
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    
    @Mock
    private UserService userService;
    
    @InjectMocks
    private UserController userController;
    
    @Test
    void testGetUser() {
        when(userService.findById(1L)).thenReturn(new User("John"));
        User result = userController.getUser(1L);
        verify(userService, times(1)).findById(1L);
    }
}
```

---

### Part 2: Unit Test Validation (20 minutes)

#### Exercise 4.4: Run and Fix Unit Tests
**Tool: Terminal + Kiro Chat**

**Run all unit tests:**
```bash
mvn test

# Review output:
# - Tests run: X
# - Failures: Y
# - Errors: Z
# - Skipped: W
```

**Fix failing tests systematically:**
```
For each failure:

1. Identify test and error
2. Use Kiro Chat with the #Problems context key to share compilation errors directly:

Ask Kiro:
"This unit test fails after Java 21 + Spring 6 migration:
#Problems

How do I fix it?"

Or for a specific test file, combine #File and #Problems:

Ask Kiro:
"Fix the failing test in this file:
#File UserServiceTest.java
#Problems"

3. Apply Kiro's solution
4. Re-run test
5. Move to next failure
```

#### Exercise 4.5: Common Test Failures
**Tool: Kiro Chat with Context Keys - Error Resolution**

> **Tip:** Use the `#Problems` context key to share compilation errors directly with Kiro Chat instead of manually copying error messages. Use `#File` to reference the specific test file for targeted guidance.

**Failure 1: Spring context not loading**
```
Error: Unable to load ApplicationContext

Ask Kiro:
"Spring test context fails to load after Spring 6 upgrade:
#Problems
What configuration is missing?"

Common fixes Kiro will suggest:
- Update @SpringBootTest annotation
- Fix test configuration classes
- Update test properties
```

**Failure 2: Assertion method changes**
```java
// Error: cannot find symbol: method assertEquals(String, String)

// Use #Problems to share the compilation error directly:
Ask Kiro:
"JUnit 5 assertions not working after migration:
#Problems
#File UserServiceTest.java
What's the correct syntax?"

// Kiro will show:
import static org.junit.jupiter.api.Assertions.*;
// Not: import static org.junit.Assert.*;
```

**Failure 3: Mock injection issues**
```
Error: NullPointerException in test

Ask Kiro:
"Mocks are null in JUnit 5 test:
#File UserControllerTest.java
#Problems
What's wrong with my mock setup?"

Kiro will identify:
- Missing @ExtendWith(MockitoExtension.class)
- Incorrect mock initialization
- Spring context conflicts
```

---

### Part 3: Integration Testing (25 minutes)

#### Exercise 4.6: Database Integration Tests
**Tool: Kiro Chat - Integration Test Generation**

**Generate database test:**
```
Ask Kiro:
"Generate Spring 6 integration test for SQL Server database with:
- Test configuration
- Embedded database or testcontainers
- Repository testing
- Transaction rollback

Entity: User (id, name, email)
Repository: UserRepository extends JpaRepository"
```

**Apply generated test:**
```java
// Kiro will generate something like:
@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class UserRepositoryIntegrationTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    void testSaveAndFindUser() {
        User user = new User("John", "john@example.com");
        User saved = userRepository.save(user);
        
        assertNotNull(saved.getId());
        
        Optional<User> found = userRepository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("John", found.get().getName());
    }
    
    @Test
    void testFindByEmail() {
        User user = new User("Jane", "jane@example.com");
        userRepository.save(user);
        
        User found = userRepository.findByEmail("jane@example.com");
        assertNotNull(found);
        assertEquals("Jane", found.getName());
    }
}
```

**Run integration tests:**
```bash
mvn verify

# Or specific test:
mvn test -Dtest=UserRepositoryIntegrationTest
```

#### Exercise 4.7: REST API Integration Tests
**Tool: Kiro Chat - API Testing**

**Generate REST test:**
```
Ask Kiro:
"Generate Spring 6 REST API integration test using MockMvc for:
- GET /api/users
- POST /api/users
- GET /api/users/{id}
- PUT /api/users/{id}
- DELETE /api/users/{id}

Include JSON assertions and status code checks."
```

**Apply and enhance:**
```java
// Kiro generates base test, then ask:
"Add tests for:
- Invalid input validation
- 404 error handling
- Authentication/authorization
- Content negotiation"
```

#### Exercise 4.8: Messaging Integration Tests
**Tool: Kiro Chat - Messaging Tests**

**For IBM MQ integration:**
```
Ask Kiro:
"Generate Spring 6 integration test for IBM MQ:
- Send message to queue
- Receive message from queue
- Verify message content
- Handle connection errors

Queue: TEST.QUEUE
Message: JSON payload"
```

**For MongoDB integration:**
```
Ask Kiro:
"Generate Spring 6 integration test for MongoDB:
- Save document
- Find by criteria
- Update document
- Delete document

Use embedded MongoDB or testcontainers."
```

---

### Part 4: End-to-End Testing (15 minutes)

#### Exercise 4.9: Full Application Flow Tests
**Tool: Kiro Chat - E2E Test Design**

**Design test scenarios:**
```
Ask Kiro:
"Design end-to-end test scenarios for user management application:
1. User registration flow
2. User login and authentication
3. CRUD operations on user data
4. Error handling scenarios

Include setup, execution, and verification steps."
```

**Generate E2E test:**
```
Ask Kiro:
"Generate Spring 6 end-to-end test for user registration:
1. POST /api/register with user data
2. Verify user saved to database
3. Verify confirmation email sent (mock)
4. GET /api/users/{id} returns created user
5. Verify all fields correct"
```

#### Exercise 4.10: Performance Testing
**Tool: Kiro Chat - Performance Tests**

**Create performance baseline:**
```
Ask Kiro:
"Generate JMeter or Gatling test script for:
- Endpoint: GET /api/users
- Load: 100 concurrent users
- Duration: 60 seconds
- Success criteria: 95% requests < 200ms

Or suggest Spring Boot performance testing approach."
```

---

### Part 5: Comprehensive Validation (10 minutes)

#### Exercise 4.11: Code Coverage Analysis
**Tool: Kiro Chat + JaCoCo**

**Setup coverage:**
```
Ask Kiro:
"Add JaCoCo code coverage plugin to my pom.xml for Spring 6 project.
Configure minimum coverage thresholds:
- Line coverage: 80%
- Branch coverage: 70%"
```

**Run coverage:**
```bash
mvn clean test jacoco:report

# View report: target/site/jacoco/index.html
```

**Improve coverage:**
```
Ask Kiro:
"My code coverage is 65%. Which areas should I focus on?
Coverage report summary:
[paste key metrics]

Generate tests for low-coverage classes."
```

#### Exercise 4.12: Security Review with Kiro Hooks
**Tool: Kiro Hooks + Kiro Chat**

Kiro Hooks provide automated, continuous code review triggered on file save — replacing the need for manual review commands. In this exercise, you'll configure Hooks for security validation and learn to use on-demand review via Kiro Chat.

**Step 1: Configure Kiro Hooks for automated security review**

Kiro Hooks run automatically when you save files, providing continuous feedback on code quality and security. To set up security-focused hooks:

1. Open the Kiro Hooks panel from the sidebar
2. Create a new hook or verify that the default security review hook is active
3. Configure the hook to trigger on file save for Java source files (`**/*.java`)
4. The hook will automatically scan for common security issues including:
   - SQL injection vulnerabilities
   - Cross-site scripting (XSS) risks
   - Insecure authentication patterns
   - Hardcoded credentials or secrets
   - Missing input validation

**Step 2: Review Hooks output**

As you save files during the migration, Kiro Hooks will surface security findings directly in the editor:

- Security issues appear as inline annotations on the affected lines
- The Hooks output panel shows a summary of all findings across the project
- Each finding includes a severity level and suggested remediation

**Step 3: On-demand review with Kiro Chat and #Git Diff**

For a comprehensive review of all migration changes at once, use Kiro Chat with the `#Git Diff` context key:

```
Ask Kiro:
"Review my migration changes for security issues:
#Git Diff

Focus on:
- Spring Security configuration changes
- Authentication and authorization patterns
- Input validation in controllers
- Database query safety"
```

This sends your uncommitted changes to Kiro for a targeted security review, giving you a consolidated view of potential issues across all modified files.

**Step 4: Fix security findings**

For each security issue identified by Hooks or the on-demand review:

```
Ask Kiro:
"How do I fix this security issue in Spring 6:
[paste issue description from Hooks output]"
```

**Step 5: Generate security tests**

```
Ask Kiro:
"Generate security tests for Spring 6 application:
- Test authentication required for protected endpoints
- Test authorization rules
- Test CSRF protection
- Test SQL injection prevention
- Test XSS prevention"
```

> **Tip:** Keep Kiro Hooks active throughout the rest of the workshop. Every time you save a file, Hooks will catch potential issues before they accumulate — this is especially valuable during large-scale migrations where security regressions can slip through.

#### Exercise 4.13: Final Validation Checklist
**Tool: Kiro Chat - Validation Report**

**Generate validation report:**
```
Ask Kiro:
"Generate a comprehensive validation report for Java 21 + Spring 6 migration:

Current status:
- All unit tests: [PASS/FAIL count]
- Integration tests: [PASS/FAIL count]
- Code coverage: [percentage]
- Security issues: [count]
- Performance: [baseline comparison]

What else should I validate before production?"
```

**Execute final checks:**
```bash
# Full test suite
mvn clean verify

# Security scan
mvn dependency-check:check

# Build final artifact
mvn clean package

# Verify artifact
java -jar target/application.jar --spring.profiles.active=test
```

---

## Module 4 Completion Checklist

**Test Framework Migration:**
- [ ] JUnit 4 → JUnit 5 complete (using JUnit 4→5 Migration Skill)
- [ ] Mockito updated and working
- [ ] Test dependencies updated
- [ ] All test annotations migrated

**Unit Tests:**
- [ ] All unit tests passing
- [ ] Test coverage ≥ 80%
- [ ] No skipped tests
- [ ] Fast execution time

**Integration Tests:**
- [ ] Database tests passing
- [ ] REST API tests passing
- [ ] Messaging tests passing (if applicable)
- [ ] External service mocks working

**Kiro Hooks & Review:**
- [ ] Kiro Hooks configured and active for automated review on file save
- [ ] Security review completed via Kiro Hooks output
- [ ] On-demand review performed via Kiro Chat with #Git Diff

**Validation Complete:**
- [ ] Code coverage meets threshold
- [ ] Security review clean (Kiro Hooks findings resolved)
- [ ] Performance baseline met
- [ ] All critical paths tested
- [ ] Application starts and runs successfully

---

## Key Kiro IDE Features Used

| Feature | Purpose | Usage |
|---------|---------|-------|
| Kiro Hooks | Automated security review on file save; continuous code quality feedback | Active throughout module |
| Kiro Chat | Test migration guidance, test generation, error resolution | 30-50 times |
| Kiro Chat + `#Problems` | Share compilation errors directly for targeted troubleshooting | 10-20 times |
| Kiro Chat + `#Git Diff` | On-demand review of all migration changes for security and correctness | 2-3 times |
| Kiro Chat + `#File` | Reference specific test files for targeted migration guidance | 10-15 times |
| Kiro Code Suggestions | Inline test code completions during development | Continuous |
| JUnit 4→5 Migration Skill | Automate test annotation conversion, assertion updates, lifecycle changes | 1-2 times (per batch) |

---

## Common Issues & Solutions

**Issue: Tests pass locally but fail in CI/CD**
```
Solution:
Use Kiro Chat with #Terminal to share your CI/CD output:

Ask Kiro:
"Tests pass locally but fail in CI/CD after Spring 6 upgrade:
#Terminal
What environment differences should I check?"

Kiro will suggest:
- Java version mismatch
- Dependency resolution issues
- Test execution order problems
- Resource availability
```

**Issue: Slow test execution**
```
Solution:
Ask Kiro:
"Test suite takes 10 minutes after Spring 6 upgrade (was 2 minutes).
How do I optimize test performance?"

Kiro will suggest:
- Use @MockBean sparingly
- Optimize Spring context loading
- Parallel test execution
- Test slicing strategies
```

**Issue: Flaky tests**
```
Solution:
Ask Kiro:
"Some tests fail intermittently after migration:
#Problems
How do I fix flaky tests?"

Kiro will identify:
- Timing issues
- Shared state problems
- Resource cleanup issues
- Async operation handling
```

**Issue: Multiple compilation errors after migration**
```
Solution:
Use the #Problems context key to share all compilation errors at once:

Ask Kiro:
"I have multiple compilation errors after the JUnit 5 migration:
#Problems
Fix all of these systematically."

Then review the suggested changes with #Git Diff before committing:

Ask Kiro:
"Review my test migration changes for correctness:
#Git Diff"
```

---

## Testing Best Practices

**Ask Kiro for recommendations:**
```
"What are Spring 6 testing best practices for:
1. Test organization and structure
2. Test data management
3. Mocking strategies
4. Integration test configuration
5. Performance testing"

Apply Kiro's recommendations to test suite
```

---

## Performance Benchmarks

**Establish baselines:**
```
Ask Kiro:
"How do I establish performance baselines for:
- Application startup time
- API response times
- Database query performance
- Memory usage
- Thread utilization

Compare Java 8 + Spring 5 vs Java 21 + Spring 6"
```

---

## Next Steps

After completing Module 4, you should have:
1. Complete test suite migrated and passing
2. High code coverage maintained
3. Integration tests validating all components
4. Security and performance validated
5. Application ready for platform deployment

**Proceed to Module 5: Platform-Specific Validation (Optional)**

Or if skipping Module 5:
**Begin production deployment planning**
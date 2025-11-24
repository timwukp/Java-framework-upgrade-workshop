# Module 4: Testing & Validation (90 minutes)

## Hands-On Training Guide

### Part 1: Test Framework Migration (30 minutes)

#### Exercise 4.1: Analyze Current Test Suite
**Tool: Q Chat - Test Analysis**

**Step 1: Inventory tests**
```
Ask Q:
"Analyze my test suite and provide:
1. Total number of test files
2. Test framework versions (JUnit, Mockito, etc.)
3. Which tests need migration for Java 21 + Spring 6
4. Estimated migration effort

Project structure:
[paste src/test directory structure]"
```

**Step 2: Create test migration plan**
```
Ask Q:
"Create a prioritized test migration plan:
1. Unit tests
2. Integration tests
3. End-to-end tests

Which should I migrate first and why?"
```

#### Exercise 4.2: Migrate JUnit 4 to JUnit 5
**Tool: Q Chat - Test Migration**

**Update test dependencies:**
```xml
<!-- Ask Q: "Update test dependencies from JUnit 4 to JUnit 5 for Spring 6" -->

<!-- BEFORE (JUnit 4) -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>

<!-- AFTER (JUnit 5) - Q suggestion -->
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

// Ask Q:
"Migrate this JUnit 4 test to JUnit 5 for Spring 6:
[paste test class]"

// AFTER (JUnit 5) - Q suggestion
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

#### Exercise 4.3: Update Mockito Usage
**Tool: Q Chat - Mocking Framework**

**Update Mockito version:**
```
Ask Q:
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

// Ask Q:
"Update this Mockito test for JUnit 5 and Spring 6:
[paste test class]"

// AFTER (Modern Mockito) - Q suggestion
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
**Tool: Terminal + Q Chat**

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
2. Ask Q:
   "This unit test fails after Java 21 + Spring 6 migration:
   
   Test: [test name]
   Error: [error message]
   Test code: [paste test method]
   
   How do I fix it?"

3. Apply Q's solution
4. Re-run test
5. Move to next failure
```

#### Exercise 4.5: Common Test Failures
**Tool: Q Chat - Error Resolution**

**Failure 1: Spring context not loading**
```
Error: Unable to load ApplicationContext

Ask Q:
"Spring test context fails to load after Spring 6 upgrade:
[paste error]
What configuration is missing?"

Common fixes Q will suggest:
- Update @SpringBootTest annotation
- Fix test configuration classes
- Update test properties
```

**Failure 2: Assertion method changes**
```java
// Error: cannot find symbol: method assertEquals(String, String)

Ask Q:
"JUnit 5 assertions not working:
[paste error and code]
What's the correct syntax?"

// Q will show:
import static org.junit.jupiter.api.Assertions.*;
// Not: import static org.junit.Assert.*;
```

**Failure 3: Mock injection issues**
```
Error: NullPointerException in test

Ask Q:
"Mocks are null in JUnit 5 test:
[paste test class]
What's wrong with my mock setup?"

Q will identify:
- Missing @ExtendWith(MockitoExtension.class)
- Incorrect mock initialization
- Spring context conflicts
```

---

### Part 3: Integration Testing (25 minutes)

#### Exercise 4.6: Database Integration Tests
**Tool: Q Chat - Integration Test Generation**

**Generate database test:**
```
Ask Q:
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
// Q will generate something like:
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
**Tool: Q Chat - API Testing**

**Generate REST test:**
```
Ask Q:
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
// Q generates base test, then ask:
"Add tests for:
- Invalid input validation
- 404 error handling
- Authentication/authorization
- Content negotiation"
```

#### Exercise 4.8: Messaging Integration Tests
**Tool: Q Chat - Messaging Tests**

**For IBM MQ integration:**
```
Ask Q:
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
Ask Q:
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
**Tool: Q Chat - E2E Test Design**

**Design test scenarios:**
```
Ask Q:
"Design end-to-end test scenarios for user management application:
1. User registration flow
2. User login and authentication
3. CRUD operations on user data
4. Error handling scenarios

Include setup, execution, and verification steps."
```

**Generate E2E test:**
```
Ask Q:
"Generate Spring 6 end-to-end test for user registration:
1. POST /api/register with user data
2. Verify user saved to database
3. Verify confirmation email sent (mock)
4. GET /api/users/{id} returns created user
5. Verify all fields correct"
```

#### Exercise 4.10: Performance Testing
**Tool: Q Chat - Performance Tests**

**Create performance baseline:**
```
Ask Q:
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
**Tool: Q Chat + JaCoCo**

**Setup coverage:**
```
Ask Q:
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
Ask Q:
"My code coverage is 65%. Which areas should I focus on?
Coverage report summary:
[paste key metrics]

Generate tests for low-coverage classes."
```

#### Exercise 4.12: Security Testing
**Tool: Q Chat + /review**

**Run security review:**
```
1. Command Palette → "Amazon Q: Review Code"
2. Focus on security findings
3. For each security issue, ask Q:
   "How do I fix this security issue in Spring 6:
   [paste issue description]"
```

**Test security configurations:**
```
Ask Q:
"Generate security tests for Spring 6 application:
- Test authentication required for protected endpoints
- Test authorization rules
- Test CSRF protection
- Test SQL injection prevention
- Test XSS prevention"
```

#### Exercise 4.13: Final Validation Checklist
**Tool: Q Chat - Validation Report**

**Generate validation report:**
```
Ask Q:
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
- [ ] JUnit 4 → JUnit 5 complete
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

**Validation Complete:**
- [ ] Code coverage meets threshold
- [ ] Security review clean
- [ ] Performance baseline met
- [ ] All critical paths tested
- [ ] Application starts and runs successfully

---

## Key Q Developer Commands Used

| Command | Purpose | Usage Count |
|---------|---------|-------------|
| Q Chat | Test migration | 15-20 times |
| Q Chat | Test generation | 10-15 times |
| Q Chat | Error resolution | 10-20 times |
| `/review` | Security validation | 2-3 times |
| Inline suggestions | Test code completion | Continuous |

---

## Common Issues & Solutions

**Issue: Tests pass locally but fail in CI/CD**
```
Solution:
Ask Q:
"Tests pass locally but fail in CI/CD after Spring 6 upgrade:
[paste CI/CD error]
What environment differences should I check?"

Q will suggest:
- Java version mismatch
- Dependency resolution issues
- Test execution order problems
- Resource availability
```

**Issue: Slow test execution**
```
Solution:
Ask Q:
"Test suite takes 10 minutes after Spring 6 upgrade (was 2 minutes).
How do I optimize test performance?"

Q will suggest:
- Use @MockBean sparingly
- Optimize Spring context loading
- Parallel test execution
- Test slicing strategies
```

**Issue: Flaky tests**
```
Solution:
Ask Q:
"Some tests fail intermittently after migration:
[paste test name and occasional error]
How do I fix flaky tests?"

Q will identify:
- Timing issues
- Shared state problems
- Resource cleanup issues
- Async operation handling
```

---

## Testing Best Practices

**Ask Q for recommendations:**
```
"What are Spring 6 testing best practices for:
1. Test organization and structure
2. Test data management
3. Mocking strategies
4. Integration test configuration
5. Performance testing"

Apply Q's recommendations to test suite
```

---

## Performance Benchmarks

**Establish baselines:**
```
Ask Q:
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
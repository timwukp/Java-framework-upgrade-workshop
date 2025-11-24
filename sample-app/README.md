# Sample Application - BEFORE State (Ready for Training)

## ✅ This is the STARTING POINT for customers

This application is in **Java 8 + Spring 5.2.3** state - the BEFORE state that customers will migrate FROM.

---

## Current State (BEFORE Migration)

### Technology Stack
- ☑️ **Java**: 1.8
- ☑️ **Spring Framework**: 5.2.3.RELEASE
- ☑️ **Spring Boot**: 2.2.4.RELEASE
- ☑️ **JUnit**: 4.12
- ☑️ **Namespace**: javax.* (NOT jakarta.*)

### What Needs Migration

#### 1. Java 8 Patterns (Module 2)
```java
// User.java - OLD Date API
import java.util.Date;
private Date createdDate;
createdDate = new Date();
```

#### 2. Spring 5 Patterns (Module 3)
```java
// SecurityConfig.java - DEPRECATED Pattern
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()...
    }
}

// UserController.java - OLD Annotations
@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<List<User>> getAllUsers() { }
```

#### 3. javax Namespace (Module 3)
```java
// User.java
import javax.persistence.*;
import javax.validation.constraints.*;

// UserController.java
import javax.validation.Valid;
```

#### 4. JUnit 4 (Module 4)
```java
// UserServiceTest.java
import org.junit.Before;
import org.junit.Test;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Before
    public void setUp() { }
    
    @Test
    public void testCreateUser() {
        assertEquals(...);
    }
}
```

---

## Application Structure

```
sample-app/
├── pom.xml                          # Java 8, Spring 5.2.3
├── src/
│   ├── main/
│   │   ├── java/com/enterprise/user/
│   │   │   ├── UserManagementApplication.java
│   │   │   ├── entity/
│   │   │   │   └── User.java        # Uses Date, javax.*
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java
│   │   │   ├── service/
│   │   │   │   └── UserService.java
│   │   │   ├── controller/
│   │   │   │   └── UserController.java  # Old @RequestMapping
│   │   │   └── config/
│   │   │       └── SecurityConfig.java  # WebSecurityConfigurerAdapter
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/enterprise/user/
│           └── service/
│               └── UserServiceTest.java  # JUnit 4
```

---

## What Customers Will Do

### Module 1: Setup
- Open this application
- Analyze with Amazon Q
- Create migration plan

### Module 2: Java 8 → 21
- Update pom.xml to Java 21
- Migrate `Date` → `LocalDateTime`
- Update dependencies

### Module 3: Spring 5 → 6
- Update Spring to 6.1.0
- Migrate `javax.*` → `jakarta.*`
- Rewrite `SecurityConfig` (remove WebSecurityConfigurerAdapter)
- Modernize `UserController` annotations

### Module 4: Testing
- Migrate JUnit 4 → 5
- Update test annotations
- Fix assertions

### Module 5: Platform
- Create JBoss descriptors
- Create WebSphere descriptors

---

## Target State (AFTER Migration)

After completing all modules, this application will be:
- ✅ **Java**: 21
- ✅ **Spring Framework**: 6.1.0
- ✅ **Spring Boot**: 3.2.0
- ✅ **JUnit**: 5 (Jupiter)
- ✅ **Namespace**: jakarta.*
- ✅ **Date API**: LocalDateTime
- ✅ **Security**: SecurityFilterChain
- ✅ **Controllers**: @GetMapping, @PostMapping, etc.

---

## Security Configuration

### Environment Variables
The application now uses environment variables for secure configuration:

```bash
# Copy template and configure
cp .env.template .env
# Edit .env with your values
```

### Default Workshop Credentials
- **Admin**: workshop-admin / SecureWorkshop2024!
- **User**: workshop-user / UserWorkshop2024!
- **Database**: workshop_user / WorkshopDB2024!

### Security Features
- ✅ Environment variable configuration
- ✅ HTTPS enforcement (when X-Forwarded-Proto header present)
- ✅ CSRF protection (enabled for non-API endpoints)
- ✅ Updated JDBC driver (9.4.1.jre8)
- ✅ Reduced sensitive logging

## Quick Verification

Customers can verify they have the correct BEFORE state:

```bash
# Check Java version
grep "<java.version>" pom.xml
# Should show: <java.version>1.8</java.version>

# Check Spring version
grep "<spring.version>" pom.xml
# Should show: <spring.version>5.2.3.RELEASE</spring.version>

# Check for javax imports
grep -r "import javax\." src/main/java | wc -l
# Should show: 5

# Check for old Date API
grep "java.util.Date" src/main/java/com/enterprise/user/entity/User.java
# Should find matches

# Check for WebSecurityConfigurerAdapter
grep "WebSecurityConfigurerAdapter" src/main/java/com/enterprise/user/config/SecurityConfig.java
# Should find match

# Check for JUnit 4
grep "org.junit.Test" src/test/java/com/enterprise/user/service/UserServiceTest.java
# Should find matches
```

All checks should pass ✅

---

## Git Status

```bash
git log --oneline
# Shows: Baseline: Java 8 + Spring 5.2.3

git tag
# Shows: pre-migration-baseline
```

---

## Ready for Training

✅ This application is ready for customers to use in tomorrow's training.

✅ It contains all the patterns that need migration.

✅ Customers will follow the module guides to migrate this application step-by-step.

---

## Support

If customers have issues:
1. Check they're on the `main` branch
2. Verify git shows baseline commit
3. Reset if needed: `git reset --hard pre-migration-baseline`
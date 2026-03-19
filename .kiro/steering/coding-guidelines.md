# Development Guidelines and Patterns

> Kiro Steering File — Provides Kiro IDE with coding conventions and migration patterns to follow when assisting with code transformations.

## Code Quality Standards

### Package Structure Convention
- **Root Package**: `com.enterprise.user` (enterprise domain-based naming)
- **Layer Separation**: Clear separation by functionality (config, controller, entity, repository, service)
- **Single Responsibility**: Each class has a focused, single purpose
- **Consistent Naming**: Descriptive class names following Java conventions

### Import Organization Patterns
- **Grouped Imports**: Standard Java, then third-party, then application imports
- **Specific Imports**: No wildcard imports, explicit class imports only
- **jakarta Namespace**: All new code must use jakarta.* (not javax.*) after migration
- **Framework Imports**: Spring imports grouped together

### Code Formatting Standards
- **Indentation**: 4 spaces (consistent across all files)
- **Brace Style**: Opening braces on same line, closing braces on new line
- **Line Length**: Reasonable line lengths, method chaining properly formatted
- **Whitespace**: Consistent spacing around operators and method parameters

## Structural Conventions

### Class Declaration Patterns
```java
// Standard pattern observed in 5/5 files
@Entity                    // Annotations before class declaration
@Table(name = "users")     // Multiple annotations vertically aligned
@Data                      // Lombok annotations for boilerplate reduction
@NoArgsConstructor         // Constructor annotations
@AllArgsConstructor
public class ClassName {   // Public classes with descriptive names
```

### Method Declaration Standards
```java
// Consistent pattern in 4/5 files
@Override                  // Override annotations always present
protected void methodName() throws Exception {
    // Method body with proper exception handling
}

// REST endpoint pattern in UserController
@RequestMapping(method = RequestMethod.GET)  // Explicit HTTP method specification
public ResponseEntity<Type> methodName() {   // ResponseEntity return types
    // Implementation
}
```

### Field Declaration Conventions
```java
// Entity field pattern (User.java)
@NotNull                   // Validation annotations
@Size(min = 2, max = 50)   // Constraint specifications
@Column(nullable = false)  // JPA column mappings
private String fieldName;  // Private fields with descriptive names

// Service injection pattern (UserController)
@Autowired                 // Field injection (note: constructor injection preferred in modern Spring)
private ServiceType serviceName;
```

## Semantic Patterns

### Spring Boot Application Pattern
- **Main Class**: Simple @SpringBootApplication with static main method
- **Auto-Configuration**: Relies on Spring Boot's auto-configuration
- **Component Scanning**: Implicit component scanning from root package

### Security Configuration Pattern (Pre-Migration)
```java
// Current Spring 5 pattern - requires migration
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuration using method chaining
    }
}
```

### Entity Design Pattern
```java
// JPA entity with lifecycle callbacks
@Entity
@Table(name = "table_name")
public class EntityName {
    @PrePersist
    protected void onCreate() {
        // Automatic timestamp setting
    }
    
    @PreUpdate  
    protected void onUpdate() {
        // Update timestamp management
    }
}
```

### REST Controller Pattern
```java
// RESTful API design with explicit mappings
@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    // CRUD operations with proper HTTP methods
    // ResponseEntity return types for HTTP status control
    // @Valid for request validation
}
```

## Frequently Used Code Idioms

### Date Handling (Current - Requires Migration)
```java
// Java 8 Date API usage (found in User.java)
private Date createdDate;
createdDate = new Date();  // Should migrate to LocalDateTime.now()
```

### Optional Handling Pattern
```java
// Modern Optional usage in controller
return userService.findById(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
```

### Exception Handling Pattern
```java
// Service layer validation
if (!condition) {
    throw new IllegalArgumentException("Descriptive message");
}
```

### Repository Method Naming
```java
// Spring Data JPA method naming conventions
boolean existsByEmail(String email);  // Existence checks
Optional<Entity> findById(Long id);   // Optional returns for single entities
```

## Migration-Specific Patterns

When Kiro assists with migration, apply these transformation rules:

### 1. javax to jakarta Namespace (Found in 3/5 files)
```java
// Current (requires migration)
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

// Target
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
```

### 2. Spring Security Configuration (Found in SecurityConfig.java)
```java
// Current (deprecated pattern)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuration
    }
}

// Target (Spring 6 pattern)
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // Functional configuration
}
```

### 3. Request Mapping Annotations (Found in UserController.java)
```java
// Current (verbose pattern)
@RequestMapping(method = RequestMethod.GET)
@RequestMapping(method = RequestMethod.POST)

// Target (specific annotations)
@GetMapping
@PostMapping
```

### 4. JUnit Testing Framework (Found in UserServiceTest.java)
```java
// Current JUnit 4 pattern
@RunWith(MockitoJUnitRunner.class)
@Before
@After
@Test
import static org.junit.Assert.*;

// Target JUnit 5 pattern
@ExtendWith(MockitoExtension.class)
@BeforeEach
@AfterEach
@Test
import static org.junit.jupiter.api.Assertions.*;
```

## Popular Annotations and Usage

### Entity Annotations
- **@Entity**: JPA entity marking
- **@Table(name = "table_name")**: Explicit table naming
- **@Id**: Primary key identification
- **@GeneratedValue(strategy = GenerationType.IDENTITY)**: Auto-increment IDs
- **@Column**: Column customization (nullable, unique, name mapping)

### Validation Annotations
- **@NotNull**: Null validation
- **@Size(min = x, max = y)**: String length validation
- **@Email**: Email format validation
- **@Valid**: Request body validation in controllers

### Lombok Annotations
- **@Data**: Generates getters, setters, toString, equals, hashCode
- **@NoArgsConstructor**: Default constructor generation
- **@AllArgsConstructor**: All-args constructor generation

### Spring Annotations
- **@SpringBootApplication**: Main application class
- **@Configuration**: Configuration class marking
- **@EnableWebSecurity**: Security configuration enablement
- **@RestController**: REST endpoint controller
- **@RequestMapping**: HTTP endpoint mapping
- **@Autowired**: Dependency injection

### Testing Annotations (Post-Migration Targets)
- **@ExtendWith(MockitoExtension.class)**: JUnit 5 test runner (replaces @RunWith)
- **@Mock**: Mock object creation
- **@InjectMocks**: Mock injection into test subject
- **@BeforeEach/@AfterEach**: Test setup and teardown (replaces @Before/@After)
- **@Test**: Test method marking (from org.junit.jupiter.api)

## Best Practices

### Dependency Injection
- **Field Injection**: Currently using @Autowired field injection
- **Recommendation**: Migrate to constructor injection for better testability

### Error Handling
- **Consistent Exceptions**: IllegalArgumentException for validation failures
- **HTTP Status Codes**: Proper ResponseEntity usage with appropriate status codes

### Data Validation
- **Bean Validation**: Comprehensive use of validation annotations
- **Service Layer Validation**: Business logic validation in service methods

### Testing Practices
- **Mock Usage**: Proper mock setup and verification
- **Test Coverage**: Comprehensive CRUD operation testing
- **Exception Testing**: Explicit exception scenario testing

## Code Quality Metrics

### Complexity Analysis
- **Method Length**: Methods are concise and focused (average 5-10 lines)
- **Class Responsibility**: Single responsibility principle followed
- **Cyclomatic Complexity**: Low complexity with straightforward logic flows

### Maintainability Indicators
- **Consistent Patterns**: Same patterns used across similar components
- **Clear Naming**: Descriptive method and variable names
- **Separation of Concerns**: Clear layer separation (controller, service, repository)
- **Configuration Externalization**: Properties-based configuration

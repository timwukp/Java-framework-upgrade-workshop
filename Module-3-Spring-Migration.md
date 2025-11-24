# Module 3: Spring 5.2.3 → Spring 6 Migration (120 minutes)

## Hands-On Training Guide

### Part 1: Dependency Migration (30 minutes)

#### Exercise 3.1: Analyze Current Dependencies
**Tool: Q Chat - Dependency Analysis**

**Step 1: Get Spring 6 requirements**
```
Ask Q:
"I'm migrating from Spring 5.2.3 to Spring 6. 
Analyze my pom.xml and tell me:
1. Which Spring dependencies need version updates?
2. Which dependencies are incompatible with Spring 6?
3. What new dependencies do I need to add?

[paste pom.xml content]"
```

**Step 2: Create dependency update plan**
```
Ask Q:
"Create a step-by-step plan to update dependencies from Spring 5.2.3 to Spring 6.
Include version numbers and any breaking changes I should know about."
```

#### Exercise 3.2: Update Spring Framework Dependencies
**Tool: Q Chat - Dependency Generation**

**Generate updated pom.xml:**
```
Ask Q:
"Generate updated Spring 6 dependencies for my pom.xml. Current dependencies:
[paste current Spring dependencies]

Include:
- Spring Framework 6.x
- Spring Boot 3.x (if applicable)
- Compatible versions of all Spring modules"
```

**Apply updates:**
```xml
<!-- BEFORE (Spring 5.2.3) -->
<properties>
    <spring.version>5.2.3.RELEASE</spring.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
    </dependency>
</dependencies>

<!-- Ask Q: "Update these Spring dependencies to Spring 6" -->

<!-- AFTER (Spring 6) - Q suggestion -->
<properties>
    <spring.version>6.1.0</spring.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
    </dependency>
</dependencies>
```

#### Exercise 3.3: Add Jakarta EE Dependencies
**Tool: Q Chat - Jakarta Migration**

**Identify javax dependencies:**
```
Ask Q:
"List all javax.* dependencies in my pom.xml that need to be replaced with jakarta.* for Spring 6:
[paste dependencies section]"
```

**Update to Jakarta:**
```xml
<!-- Ask Q: "Convert these javax dependencies to jakarta for Spring 6" -->

<!-- BEFORE -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>

<!-- AFTER (Q suggestion) -->
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
</dependency>
<dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.1.0</version>
</dependency>
```

---

### Part 2: Namespace Migration (javax → jakarta) (25 minutes)

#### Exercise 3.4: Bulk Import Replacement
**Tool: Q Chat + IDE Find/Replace**

**Step 1: Get replacement mapping**
```
Ask Q:
"Provide a complete mapping of javax.* to jakarta.* imports for Spring 6 migration.
Include:
- javax.servlet → jakarta.servlet
- javax.persistence → jakarta.persistence
- javax.validation → jakarta.validation
- All other common javax packages"
```

**Step 2: Automated replacement**
```
For each file with javax imports:

1. Open file
2. Ask Q:
   "Convert all javax imports to jakarta in this file:
   [paste file content or import section]"
3. Review Q's suggestions
4. Apply changes
```

**Common replacements:**
```java
// BEFORE
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

// Ask Q: "Convert these imports to jakarta"

// AFTER (Q suggestion)
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
```

#### Exercise 3.5: Verify Complete Migration
**Tool: Q Chat - Verification**

**Search for remaining javax:**
```bash
# In terminal
grep -r "import javax\." src/

# Ask Q:
"I found these remaining javax imports:
[paste grep results]
Should these be converted to jakarta or kept as javax?"
```

**Handle edge cases:**
```
Ask Q:
"These javax imports don't have jakarta equivalents:
- javax.crypto.*
- javax.xml.*
- javax.naming.*
Should I keep them or is there an alternative?"
```

---

### Part 3: Spring Configuration Updates (35 minutes)

#### Exercise 3.6: Update Security Configuration
**Tool: Q Chat - Configuration Migration**

**Migrate WebSecurityConfigurerAdapter:**
```java
// BEFORE (Spring 5)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER");
    }
}

// Ask Q:
"Migrate this Spring Security configuration to Spring 6. 
WebSecurityConfigurerAdapter is deprecated."

// AFTER (Q suggestion - Spring 6)
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults());
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
```

#### Exercise 3.7: Update Web Configuration
**Tool: Q Chat - WebMvc Configuration**

**Migrate WebMvcConfigurer:**
```java
// BEFORE (Spring 5)
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST");
    }
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}

// Ask Q:
"Update this WebMvcConfigurer for Spring 6 best practices.
Are there any deprecated methods or better approaches?"

// Review Q's suggestions for:
// - CORS configuration updates
// - View resolver changes
// - Any new Spring 6 features to adopt
```

#### Exercise 3.8: Update Data Source Configuration
**Tool: Q Chat - Database Configuration**

**Modernize DataSource setup:**
```java
// Ask Q:
"Generate Spring 6 DataSource configuration for:
- Database: SQL Server
- Connection pool: HikariCP
- JPA with Hibernate
- Transaction management

Include best practices for Spring 6."

// Apply Q's generated configuration
```

**Example Q response to apply:**
```java
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=mydb");
        config.setUsername("${db.username}");
        config.setPassword("${db.password}");
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
```

#### Exercise 3.9: Update Controller Annotations
**Tool: Q Chat + Inline Suggestions**

**Review and update controllers:**
```java
// BEFORE (Spring 5)
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
}

// Ask Q:
"Modernize this controller for Spring 6 best practices.
Use specific HTTP method annotations and any new Spring 6 features."

// AFTER (Q suggestion)
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
}
```

---

### Part 4: Application Properties Update (15 minutes)

#### Exercise 3.10: Migrate Configuration Properties
**Tool: Q Chat - Properties Migration**

**Update application.properties:**
```properties
# BEFORE (Spring 5)
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=mydb
spring.datasource.username=user
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update
server.port=8080

# Ask Q:
"Review these Spring Boot properties for Spring 6 compatibility.
Are any deprecated? What new properties should I add?"

# Apply Q's suggestions for:
# - Deprecated property replacements
# - New Spring 6 properties
# - Performance tuning options
```

**Update application.yml:**
```yaml
# Ask Q:
"Convert this application.properties to application.yml with Spring 6 best practices:
[paste properties]"

# Apply Q's generated YAML configuration
```

#### Exercise 3.11: Update Logging Configuration
**Tool: Q Chat - Logging Setup**

```
Ask Q:
"Generate Spring 6 compatible logging configuration for:
- Framework: Logback
- Log levels: INFO for app, DEBUG for SQL
- File output: logs/application.log
- Console output with colors"

Apply Q's logback-spring.xml configuration
```

---

### Part 5: Validation and Testing (15 minutes)

#### Exercise 3.12: Compile and Fix Errors
**Tool: Terminal + Q Chat**

**Build project:**
```bash
mvn clean compile

# For each error:
# 1. Copy error message
# 2. Ask Q: "How do I fix this Spring 6 compilation error: [error]"
# 3. Apply fix
# 4. Rebuild
```

**Common Spring 6 errors:**
```
Error: Cannot resolve method 'authorizeRequests()'
Ask Q: "authorizeRequests() not found in Spring 6. What's the replacement?"

Error: WebSecurityConfigurerAdapter cannot be resolved
Ask Q: "How do I replace WebSecurityConfigurerAdapter in Spring 6?"

Error: javax.servlet.http.HttpServletRequest not found
Ask Q: "javax.servlet not found after Spring 6 upgrade. What's missing?"
```

#### Exercise 3.13: Application Startup Test
**Tool: Q Chat - Runtime Validation**

**Start application:**
```bash
mvn spring-boot:run

# If startup fails, ask Q:
"Application fails to start with Spring 6:
[paste stack trace]
What's the issue and how do I fix it?"
```

**Verify endpoints:**
```
Ask Q:
"Generate curl commands to test these endpoints after Spring 6 migration:
- GET /api/users
- POST /api/users
- GET /api/users/{id}
- DELETE /api/users/{id}"

Execute curl commands and verify responses
```

#### Exercise 3.14: Integration Testing
**Tool: Q Chat - Test Generation**

**Test database connectivity:**
```
Ask Q:
"Generate Spring 6 integration test for SQL Server database connection.
Include:
- Test configuration
- Connection verification
- Basic CRUD operations"

Apply and run generated test
```

**Test messaging (if applicable):**
```
Ask Q:
"Generate Spring 6 integration test for IBM MQ connection.
Verify:
- Connection establishment
- Message sending
- Message receiving"

Apply and run generated test
```

---

## Module 3 Completion Checklist

**Dependencies Updated:**
- [ ] Spring Framework upgraded to 6.x
- [ ] Spring Boot upgraded to 3.x (if applicable)
- [ ] Jakarta EE dependencies added
- [ ] All javax dependencies replaced

**Code Migration Complete:**
- [ ] All javax.* imports changed to jakarta.*
- [ ] Security configuration updated
- [ ] Web configuration modernized
- [ ] Data source configuration updated
- [ ] Controllers using Spring 6 patterns

**Configuration Updated:**
- [ ] application.properties/yml migrated
- [ ] Logging configuration updated
- [ ] Deprecated properties replaced
- [ ] New Spring 6 properties added

**Validation Complete:**
- [ ] Project compiles successfully
- [ ] Application starts without errors
- [ ] All endpoints responding
- [ ] Database connectivity verified
- [ ] Integration tests passing

---

## Key Q Developer Commands Used

| Command | Purpose | Usage Count |
|---------|---------|-------------|
| Q Chat | Dependency updates | 5-10 times |
| Q Chat | Code migration | 20-30 times |
| Q Chat | Configuration generation | 10-15 times |
| Inline suggestions | Code completion | Continuous |
| `/review` | Validation | 2-3 times |

---

## Common Issues & Solutions

**Issue: NoClassDefFoundError for javax classes**
```
Solution:
Ask Q: "Getting NoClassDefFoundError for javax.servlet after Spring 6 upgrade. What's missing?"

Q will suggest:
- Add jakarta.servlet dependency
- Verify all javax imports converted
- Check transitive dependencies
```

**Issue: Security configuration not working**
```
Solution:
Ask Q: "Spring Security configuration not working after Spring 6 upgrade:
[paste configuration]
What's wrong?"

Q will identify:
- Deprecated methods
- Missing beans
- Configuration errors
```

**Issue: Database connection fails**
```
Solution:
Ask Q: "Database connection fails with Spring 6:
[paste error]
How do I fix the DataSource configuration?"

Q will help with:
- Driver compatibility
- Configuration properties
- Connection pool settings
```

---

## Spring 6 Best Practices

**Ask Q for recommendations:**
```
"What Spring 6 best practices should I follow for:
1. REST API design
2. Security configuration
3. Database access
4. Error handling
5. Testing"

Apply Q's recommendations throughout codebase
```

---

## Next Steps

After completing Module 3, you should have:
1. Spring 6 fully integrated
2. All configurations updated
3. Application running on Spring 6
4. Basic integration tests passing

**Proceed to Module 4: Testing & Validation**
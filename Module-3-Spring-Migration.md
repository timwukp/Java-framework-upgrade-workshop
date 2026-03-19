# Module 3: Spring 5.2.3 → Spring 6 Migration (120 minutes)

## Hands-On Training Guide

### Part 1: Spring Migration Custom Agent and Power Activation (25 minutes)

#### Exercise 3.1: Create and Configure a Spring Migration Agent
**Tool: Kiro Custom Agents**

Just as you created a Java Migration Agent in Module 2, you will now create a specialized "Spring Migration Agent" for the Spring 5→6 and Jakarta namespace migration. This agent understands Spring-specific patterns and can apply them consistently across your codebase.

**(a) Purpose and Expertise Scope**

The Spring Migration Agent specializes in:
- Spring 5.2.3 → Spring 6 framework migration patterns
- Jakarta EE namespace migration (javax.* → jakarta.*)
- Spring Security modernization (WebSecurityConfigurerAdapter → SecurityFilterChain)
- Spring MVC and WebFlux configuration updates
- Spring Boot 2.x → 3.x migration (if applicable)
- Spring Data and JPA configuration for Jakarta Persistence

**(b) How to Create and Configure**

Create the agent configuration file at `.kiro/agents/spring-migration-agent.md`:

```markdown
# Spring Migration Agent

## Role
You are a Spring framework migration specialist focused on upgrading Spring 5.2.3 applications to Spring 6.

## Expertise
- Spring Framework 5.x to 6.x migration patterns
- Jakarta EE namespace migration (javax.* → jakarta.*)
- Spring Security 5.x to 6.x (WebSecurityConfigurerAdapter removal, SecurityFilterChain)
- Spring MVC configuration modernization
- Spring Boot 2.x to 3.x upgrade paths
- Spring Data JPA with Jakarta Persistence API
- Dependency version compatibility for Spring 6 ecosystem

## Instructions
- When migrating code, preserve existing functionality and behavior
- Always migrate javax.* imports to jakarta.* equivalents where applicable
- For Spring Security, replace WebSecurityConfigurerAdapter with component-based SecurityFilterChain beans
- Replace deprecated Spring APIs with their Spring 6 equivalents
- Update configuration properties that changed between Spring Boot 2.x and 3.x
- Flag javax.* packages that do NOT have jakarta equivalents (javax.crypto, javax.xml, javax.naming)
- Always explain why a change is being made

## Constraints
- Do not change business logic or application behavior
- Do not downgrade Java version (Java 21 from Module 2 is required)
- Preserve all existing test coverage
- Keep javax.crypto.*, javax.xml.*, and javax.naming.* imports unchanged
```

**(c) Best Practices for Prompting**

Use the Spring Migration Agent through Kiro Chat with Context Keys for targeted guidance:

```
Ask Kiro (using the Spring Migration Agent):
"Using the Spring Migration Agent, analyze
#File:sample-app/src/main/java/com/enterprise/user/config/SecurityConfig.java
and migrate it to Spring 6 patterns."
```

```
Ask Kiro:
"Using the Spring Migration Agent, scan #Folder:sample-app/src/main/java
for all files that need Spring 5→6 migration and list them by priority."
```

Tips for effective agent use:
- Use #File context key to point the agent at specific configuration files
- Use #Folder context key for package-wide scanning of javax imports
- Delegate one migration pattern at a time (e.g., security first, then namespace, then config)
- Ask the agent to explain its changes when the migration involves behavioral differences
- Review each transformation before moving to the next file

#### Exercise 3.2: Activate the Java Framework Migration Power
**Tool: Kiro Powers**

In Module 2, you built a "Java Framework Migration" Power with the Power Builder. Now you will activate it and extend its context with Spring 5→6 and Jakarta namespace migration guidance.

**Step 1: Activate the Power**

1. Open the Kiro Powers panel in the sidebar
2. Find "Java Framework Migration" in your local Powers
3. Click "Activate" to load its documentation and steering files into your workspace context

Once activated, Kiro Chat has access to the Power's migration documentation alongside the Spring Migration Agent.

**Step 2: Extend with Spring migration context**

The Power's steering files can be extended with Spring-specific guidance. Add a new steering file to the Power:

```markdown
# Spring 5→6 Migration Patterns (add to Power's steering/)

## Namespace Migration
- All javax.servlet.* → jakarta.servlet.*
- All javax.persistence.* → jakarta.persistence.*
- All javax.validation.* → jakarta.validation.*
- All javax.annotation.* → jakarta.annotation.*
- KEEP: javax.crypto.*, javax.xml.*, javax.naming.* (no jakarta equivalent)

## Spring Security Migration
- WebSecurityConfigurerAdapter → SecurityFilterChain @Bean
- authorizeRequests() → authorizeHttpRequests()
- antMatchers() → requestMatchers()
- .and() chaining → lambda DSL configuration

## Spring MVC Migration
- WebMvcConfigurerAdapter (removed) → WebMvcConfigurer (interface)
- @RequestMapping with method → @GetMapping, @PostMapping, etc.

## Configuration Properties
- spring.redis.* → spring.data.redis.*
- spring.elasticsearch.* → spring.data.elasticsearch.*
- server.max-http-header-size → server.max-http-request-header-size
```

**Step 3: Use the Power during migration**

With the Power activated, ask Kiro questions that leverage its documentation:

```
Ask Kiro:
"According to the Java Framework Migration Power, what is the complete list
of javax packages that need jakarta migration for Spring 6?"
```

```
Ask Kiro:
"Using the migration Power's guidance, what are the common pitfalls
when migrating Spring Security to Spring 6?"
```

---

### Part 2: Dependency Migration (25 minutes)

#### Exercise 3.3: Analyze Current Dependencies
**Tool: Kiro Chat with Context Keys — Dependency Analysis**

**Step 1: Get Spring 6 requirements**

Use the #File context key to share your pom.xml directly with Kiro Chat instead of pasting content manually:

```
Ask Kiro:
"I'm migrating from Spring 5.2.3 to Spring 6.
Analyze #File:sample-app/pom.xml and tell me:
1. Which Spring dependencies need version updates?
2. Which dependencies are incompatible with Spring 6?
3. What new dependencies do I need to add?"
```

**Step 2: Create dependency update plan**
```
Ask Kiro:
"Using the Spring Migration Agent, create a step-by-step plan to update
dependencies from Spring 5.2.3 to Spring 6.
Include version numbers and any breaking changes I should know about."
```

#### Exercise 3.4: Update Spring Framework Dependencies
**Tool: Kiro Chat with Context Keys — Dependency Generation**

**Generate updated pom.xml:**
```
Ask Kiro:
"Using the Spring Migration Agent, generate updated Spring 6 dependencies
for #File:sample-app/pom.xml.
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

<!-- Ask Kiro: "Update these Spring dependencies to Spring 6" -->

<!-- AFTER (Spring 6) - Kiro suggestion -->
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

#### Exercise 3.5: Add Jakarta EE Dependencies
**Tool: Kiro Chat with Context Keys — Jakarta Migration**

**Identify javax dependencies:**
```
Ask Kiro:
"Using the Spring Migration Agent, list all javax.* dependencies in
#File:sample-app/pom.xml that need to be replaced with jakarta.* for Spring 6."
```

**Update to Jakarta:**
```xml
<!-- Ask Kiro: "Convert these javax dependencies to jakarta for Spring 6" -->

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

<!-- AFTER (Kiro suggestion) -->
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

### Part 3: Jakarta Namespace Migration Skill (25 minutes)

#### Exercise 3.6: Create a Jakarta Namespace Migration Skill
**Tool: Kiro Skills**

The javax.* → jakarta.* namespace migration is a repetitive, pattern-based transformation that affects many files. Instead of manually prompting for each file, you will create a Kiro Skill that automates this pattern across your entire codebase.

**(a) What the Skill Automates**

The "Jakarta Namespace Migration" Skill automates:
- `javax.servlet.*` → `jakarta.servlet.*` (Servlet API)
- `javax.persistence.*` → `jakarta.persistence.*` (JPA / Jakarta Persistence)
- `javax.validation.*` → `jakarta.validation.*` (Bean Validation)
- `javax.annotation.*` → `jakarta.annotation.*` (Common Annotations)
- `javax.transaction.*` → `jakarta.transaction.*` (JTA)
- `javax.inject.*` → `jakarta.inject.*` (Dependency Injection)
- `javax.ws.rs.*` → `jakarta.ws.rs.*` (JAX-RS)
- Skips packages that have no jakarta equivalent: `javax.crypto.*`, `javax.xml.*`, `javax.naming.*`
- Updates both import statements and fully-qualified class references in code

**(b) How to Create the Skill**

1. Open the Kiro Skills panel in the sidebar
2. Click "Create Skill" and name it `jakarta-namespace-migration`
3. Define the skill's SKILL.md with the transformation patterns:

```markdown
# Jakarta Namespace Migration Skill

## Purpose
Automate the javax.* to jakarta.* namespace migration required for Spring 6 / Jakarta EE 9+.

## Patterns

### Import Replacements
- Replace `import javax.servlet.` with `import jakarta.servlet.`
- Replace `import javax.persistence.` with `import jakarta.persistence.`
- Replace `import javax.validation.` with `import jakarta.validation.`
- Replace `import javax.annotation.` with `import jakarta.annotation.`
- Replace `import javax.transaction.` with `import jakarta.transaction.`
- Replace `import javax.inject.` with `import jakarta.inject.`
- Replace `import javax.ws.rs.` with `import jakarta.ws.rs.`

### Fully-Qualified References
- Replace `javax.servlet.` with `jakarta.servlet.` in code (not just imports)
- Replace `javax.persistence.` with `jakarta.persistence.` in code
- Apply same pattern for all migrated packages

### Exclusions (DO NOT migrate)
- `javax.crypto.*` — Java SE package, no jakarta equivalent
- `javax.xml.*` — Java SE package, no jakarta equivalent
- `javax.naming.*` — Java SE package, no jakarta equivalent
- `javax.sql.*` — Java SE package, no jakarta equivalent
- `javax.net.*` — Java SE package, no jakarta equivalent

### Validation
- After migration, verify no javax imports remain for migrated packages
- Flag any ambiguous cases for manual review
```

**(c) When and How to Invoke the Skill**

Invoke the skill through Kiro Chat to process individual files or entire packages:

```
Ask Kiro:
"Run the jakarta-namespace-migration skill on
#File:sample-app/src/main/java/com/enterprise/user/entity/User.java"
```

```
Ask Kiro:
"Run the jakarta-namespace-migration skill across all files in
#Folder:sample-app/src/main/java/com/enterprise/user/"
```

The skill applies all namespace replacements consistently, handling edge cases like fully-qualified references and skipping packages that should remain as javax. After the skill runs, review the changes in the diff view.

#### Exercise 3.7: Verify Complete Namespace Migration
**Tool: Kiro Chat with Context Keys — Verification**

**Search for remaining javax:**
```bash
# In terminal
grep -r "import javax\." src/
```

Use the #Terminal context key to share the grep results directly with Kiro Chat:

```
Ask Kiro:
"Using the Spring Migration Agent, review #Terminal output.
Which of these remaining javax imports should be converted to jakarta
and which should be kept as javax?"
```

**Handle edge cases:**
```
Ask Kiro:
"These javax imports don't have jakarta equivalents:
- javax.crypto.*
- javax.xml.*
- javax.naming.*
Should I keep them or is there an alternative?"
```

---

### Part 4: Spring Security Upgrade Skill (15 minutes)

#### Exercise 3.8: Create a Spring Security Upgrade Skill
**Tool: Kiro Skills**

The Spring Security migration from `WebSecurityConfigurerAdapter` to the component-based `SecurityFilterChain` pattern is a well-defined transformation. You will create a Kiro Skill that automates this pattern so it can be applied consistently across security configuration classes.

**(a) What the Skill Automates**

The "Spring Security Upgrade" Skill automates:
- Removing `extends WebSecurityConfigurerAdapter` from security configuration classes
- Converting `configure(HttpSecurity http)` override → `@Bean SecurityFilterChain filterChain(HttpSecurity http)`
- Converting `configure(AuthenticationManagerBuilder auth)` override → `@Bean UserDetailsService` or `@Bean AuthenticationManager`
- Replacing `authorizeRequests()` → `authorizeHttpRequests()`
- Replacing `antMatchers()` → `requestMatchers()`
- Converting `.and()` chaining → lambda DSL configuration
- Adding `Customizer.withDefaults()` for default configurations
- Adding `return http.build()` to SecurityFilterChain methods

**(b) How to Create the Skill**

1. Open the Kiro Skills panel in the sidebar
2. Click "Create Skill" and name it `spring-security-upgrade`
3. Define the skill's SKILL.md:

```markdown
# Spring Security Upgrade Skill

## Purpose
Automate the migration from WebSecurityConfigurerAdapter (Spring Security 5.x)
to component-based SecurityFilterChain (Spring Security 6.x).

## Patterns

### Class-Level Changes
- Remove `extends WebSecurityConfigurerAdapter`
- Class remains annotated with `@Configuration` and `@EnableWebSecurity`

### HttpSecurity Configuration
- Convert `protected void configure(HttpSecurity http)` to
  `@Bean public SecurityFilterChain filterChain(HttpSecurity http)`
- Add `return http.build()` at the end of the method
- Replace `authorizeRequests()` with `authorizeHttpRequests()`
- Replace `antMatchers(...)` with `requestMatchers(...)`
- Convert `.and()` chaining to lambda DSL:
  - `.formLogin()` → `.formLogin(Customizer.withDefaults())`
  - `.httpBasic()` → `.httpBasic(Customizer.withDefaults())`
  - `.csrf().disable()` → `.csrf(csrf -> csrf.disable())`
  - `.cors()` → `.cors(Customizer.withDefaults())`

### Authentication Configuration
- Convert `protected void configure(AuthenticationManagerBuilder auth)` to
  `@Bean public UserDetailsService userDetailsService()` or
  `@Bean public AuthenticationManager authenticationManager()`
- Extract in-memory users to `InMemoryUserDetailsManager`

### Required Imports
- Add `import org.springframework.security.web.SecurityFilterChain`
- Add `import org.springframework.security.config.Customizer`
- Remove `import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter`
```

**(c) When and How to Invoke the Skill**

Invoke the skill on security configuration files:

```
Ask Kiro:
"Run the spring-security-upgrade skill on
#File:sample-app/src/main/java/com/enterprise/user/config/SecurityConfig.java"
```

For projects with multiple security configuration classes:

```
Ask Kiro:
"Run the spring-security-upgrade skill on all security configuration files in
#Folder:sample-app/src/main/java/com/enterprise/user/config/"
```

The skill transforms the entire security configuration pattern in one pass. Review the diff carefully — security configurations can have subtle behavioral differences between Spring Security 5.x and 6.x.

---

### Part 5: Spring Configuration Updates (30 minutes)

#### Exercise 3.9: Update Security Configuration
**Tool: Kiro Chat with Spring Migration Agent — Configuration Migration**

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

// Ask Kiro:
"Migrate this Spring Security configuration to Spring 6. 
WebSecurityConfigurerAdapter is deprecated."

// AFTER (Kiro suggestion - Spring 6)
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

#### Exercise 3.10: Update Web Configuration
**Tool: Kiro Chat with Spring Migration Agent — WebMvc Configuration**

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

// Ask Kiro:
"Update this WebMvcConfigurer for Spring 6 best practices.
Are there any deprecated methods or better approaches?"

// Review Kiro's suggestions for:
// - CORS configuration updates
// - View resolver changes
// - Any new Spring 6 features to adopt
```

#### Exercise 3.11: Update Data Source Configuration
**Tool: Kiro Chat with Spring Migration Agent — Database Configuration**

**Modernize DataSource setup:**
```java
// Ask Kiro:
"Generate Spring 6 DataSource configuration for:
- Database: SQL Server
- Connection pool: HikariCP
- JPA with Hibernate
- Transaction management

Include best practices for Spring 6."

// Apply Kiro's generated configuration
```

**Example Kiro response to apply:**
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

#### Exercise 3.12: Update Controller Annotations
**Tool: Kiro Chat + Kiro Code Suggestions**

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

// Ask Kiro:
"Modernize this controller for Spring 6 best practices.
Use specific HTTP method annotations and any new Spring 6 features."

// AFTER (Kiro suggestion)
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

### Part 6: Application Properties Update (10 minutes)

#### Exercise 3.13: Migrate Configuration Properties
**Tool: Kiro Chat with Context Keys — Properties Migration**

**Update application.properties:**

Use the #File context key to share the properties file directly:

```properties
# Ask Kiro:
"Using the Spring Migration Agent, review
#File:sample-app/src/main/resources/application.properties
for Spring 6 compatibility. Are any properties deprecated?
What new properties should I add?"

# Apply Kiro's suggestions for:
# - Deprecated property replacements
# - New Spring 6 properties
# - Performance tuning options
```

**Update application.yml:**
```yaml
# Ask Kiro:
"Convert this application.properties to application.yml with Spring 6 best practices:
[paste properties]"

# Apply Kiro's generated YAML configuration
```

#### Exercise 3.14: Update Logging Configuration
**Tool: Kiro Chat with Spring Migration Agent — Logging Setup**

```
Ask Kiro:
"Generate Spring 6 compatible logging configuration for:
- Framework: Logback
- Log levels: INFO for app, DEBUG for SQL
- File output: logs/application.log
- Console output with colors"

Apply Kiro's logback-spring.xml configuration
```

---

### Part 7: Validation and Testing (15 minutes)

#### Exercise 3.15: Compile and Fix Errors
**Tool: Terminal + Kiro Chat with Context Keys**

**Build project:**
```bash
mvn clean compile

# For each error:
# 1. Copy error message
# 2. Ask Kiro: "How do I fix this Spring 6 compilation error: [error]"
# 3. Apply fix
# 4. Rebuild
```

Use the #Problems context key to share all compilation errors directly with Kiro Chat:

```
Ask Kiro:
"Using the Spring Migration Agent, review #Problems and help me fix
the Spring 6 compilation errors. Prioritize by severity."
```

**Common Spring 6 errors:**
```
Error: Cannot resolve method 'authorizeRequests()'
Ask Kiro: "authorizeRequests() not found in Spring 6. What's the replacement?"

Error: WebSecurityConfigurerAdapter cannot be resolved
Ask Kiro: "How do I replace WebSecurityConfigurerAdapter in Spring 6?"

Error: javax.servlet.http.HttpServletRequest not found
Ask Kiro: "javax.servlet not found after Spring 6 upgrade. What's missing?"
```

#### Exercise 3.16: Application Startup Test
**Tool: Kiro Chat with Context Keys — Runtime Validation**

**Start application:**
```bash
mvn spring-boot:run

# If startup fails, ask Kiro:
"Application fails to start with Spring 6:
[paste stack trace]
What's the issue and how do I fix it?"
```

**Verify endpoints:**
```
Ask Kiro:
"Generate curl commands to test these endpoints after Spring 6 migration:
- GET /api/users
- POST /api/users
- GET /api/users/{id}
- DELETE /api/users/{id}"

Execute curl commands and verify responses
```

#### Exercise 3.17: Integration Testing
**Tool: Kiro Chat with Spring Migration Agent — Test Generation**

**Test database connectivity:**
```
Ask Kiro:
"Generate Spring 6 integration test for SQL Server database connection.
Include:
- Test configuration
- Connection verification
- Basic CRUD operations"

Apply and run generated test
```

**Test messaging (if applicable):**
```
Ask Kiro:
"Generate Spring 6 integration test for IBM MQ connection.
Verify:
- Connection establishment
- Message sending
- Message receiving"

Apply and run generated test
```

---

## Module 3 Completion Checklist

**Spring Migration Agent and Power:**
- [ ] Spring Migration Agent created and configured in `.kiro/agents/`
- [ ] Java Framework Migration Power activated and extended with Spring context
- [ ] Agent and Power used for migration guidance

**Kiro Skills Created:**
- [ ] Jakarta Namespace Migration Skill created and tested
- [ ] Spring Security Upgrade Skill created and tested
- [ ] Skills used for automated file-level transformations

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

## Key Kiro IDE Features Used

| Feature | Purpose | Usage |
|---------|---------|-------|
| Kiro Chat | Dependency updates, configuration generation, error resolution | 15-30 times |
| Kiro Code Suggestions | Inline code completions during migration edits | Continuous |
| Spring Migration Custom Agent | Specialized agent for Spring 5→6 and Jakarta namespace migration | Per-file delegation |
| Jakarta Namespace Migration Skill | Automates javax.* → jakarta.* package rename across files | Per-file or per-folder |
| Spring Security Upgrade Skill | Automates WebSecurityConfigurerAdapter → SecurityFilterChain pattern | Per security config file |
| Java Framework Migration Power | Activated from Module 2, extended with Spring 5→6 migration guidance | 1 Power activated and extended |
| Context Keys (#File, #Folder, #Problems) | Targeted context sharing with Kiro Chat for precise guidance | Throughout module |

---

## Common Issues & Solutions

**Issue: NoClassDefFoundError for javax classes**
```
Solution:
Ask Kiro: "Getting NoClassDefFoundError for javax.servlet after Spring 6 upgrade. What's missing?"

Or run the Jakarta Namespace Migration Skill to catch any missed files:
"Run the jakarta-namespace-migration skill on #Folder:sample-app/src/main/java/"

Kiro will suggest:
- Add jakarta.servlet dependency
- Verify all javax imports converted
- Check transitive dependencies
```

**Issue: Security configuration not working**
```
Solution:
Run the Spring Security Upgrade Skill on the affected file:
"Run the spring-security-upgrade skill on
#File:sample-app/src/main/java/com/enterprise/user/config/SecurityConfig.java"

Or ask the Spring Migration Agent directly:
"Using the Spring Migration Agent, review #Problems related to Spring Security
and suggest fixes."

Kiro will identify:
- Deprecated methods
- Missing beans
- Configuration errors
```

**Issue: Database connection fails**
```
Solution:
Ask Kiro: "Database connection fails with Spring 6:
[paste error]
How do I fix the DataSource configuration?"

Kiro will help with:
- Driver compatibility
- Configuration properties
- Connection pool settings
```

**Issue: Jakarta Namespace Migration Skill misses some files**
```
Solution:
- Run grep to find remaining javax imports: grep -r "import javax\." src/
- Share results with Kiro Chat using #Terminal context key
- Manually review edge cases (javax.crypto, javax.xml should NOT be migrated)
- Refine the skill's SKILL.md if needed and re-run
```

---

## Spring 6 Best Practices

**Ask Kiro using the Spring Migration Agent for recommendations:**
```
"Using the Spring Migration Agent, what Spring 6 best practices should I follow for:
1. REST API design
2. Security configuration
3. Database access
4. Error handling
5. Testing

Review #Folder:sample-app/src/main/java/ and suggest improvements."

Apply Kiro's recommendations throughout codebase
```

---

## Next Steps

After completing Module 3, you should have:
1. Spring 6 fully integrated
2. All configurations updated
3. Application running on Spring 6
4. Basic integration tests passing
5. Spring Migration Agent and Skills ready for reuse
6. Java Framework Migration Power extended with Spring context

**Proceed to Module 4: Testing & Validation**
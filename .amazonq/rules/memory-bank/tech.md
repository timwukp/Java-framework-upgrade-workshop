# Technology Stack and Dependencies

## Programming Languages and Versions

### Current State (Pre-Migration)
- **Java**: 1.8 (JDK 8)
- **Maven**: 3.x (build tool)
- **Source/Target Compatibility**: Java 1.8

### Target State (Post-Migration)
- **Java**: 21 (LTS version)
- **Maven**: 3.x (compatible with Java 21)
- **Source/Target Compatibility**: Java 21

## Framework Versions

### Spring Framework Stack (Current)
```xml
<spring.version>5.2.3.RELEASE</spring.version>
<spring.boot.version>2.2.4.RELEASE</spring.boot.version>
```

### Spring Framework Stack (Target)
```xml
<spring.version>6.1.0</spring.version>
<spring.boot.version>3.2.0</spring.boot.version>
```

### Core Dependencies (Current State)
```xml
<!-- Spring Framework 5.2.3 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>

<!-- Spring Boot 2.2.4 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.2.4.RELEASE</version>
</dependency>

<!-- javax namespace -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
```

## Database and Persistence

### Database Drivers
- **SQL Server**: mssql-jdbc 7.4.1.jre8 (current) → 12.x+ (target)
- **Connection Pool**: HikariCP 3.4.2 (current) → 5.x+ (target)
- **JPA**: javax.persistence-api 2.2 (current) → jakarta.persistence-api 3.x (target)

### ORM and Data Access
- **Spring Data JPA**: Included in Spring Boot starter
- **Hibernate**: Managed by Spring Boot (5.4.x current → 6.x+ target)
- **Validation**: javax.validation 2.0.1.Final (current) → jakarta.validation 3.x (target)

## Testing Framework

### Current Testing Stack
```xml
<!-- JUnit 4 -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>

<!-- Mockito -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.2.4</version>
</dependency>
```

### Target Testing Stack
```xml
<!-- JUnit 5 (Jupiter) -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.x</version>
</dependency>

<!-- Mockito (updated) -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.x</version>
</dependency>
```

## Build System Configuration

### Maven Compiler Plugin
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>  <!-- Current -->
        <target>1.8</target>  <!-- Current -->
        <!-- Target: <source>21</source> <target>21</target> -->
    </configuration>
</plugin>
```

### Spring Boot Maven Plugin
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>2.2.4.RELEASE</version>  <!-- Current -->
    <!-- Target: 3.2.0 -->
</plugin>
```

## Development Commands

### Build and Test Commands
```bash
# Compile application
mvn clean compile

# Run tests
mvn test

# Package application
mvn clean package

# Run Spring Boot application
mvn spring-boot:run

# Run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Migration Verification Commands
```bash
# Check Java version in POM
grep "<java.version>" pom.xml

# Check Spring version
grep "<spring.version>" pom.xml

# Count javax imports (should be 0 after migration)
grep -r "import javax\." src/main/java | wc -l

# Check for deprecated patterns
grep "WebSecurityConfigurerAdapter" src/main/java/com/enterprise/user/config/SecurityConfig.java

# Verify JUnit version
grep "org.junit.Test" src/test/java/com/enterprise/user/service/UserServiceTest.java
```

## Platform-Specific Requirements

### JBoss EAP (BDP Platform - 25 apps)
- **Java 21 Support**: JBoss EAP 8.0+
- **Jakarta EE**: Full Jakarta EE 10 support
- **Deployment**: WAR packaging with jboss-web.xml

### WebSphere (BPT Platform - 2 apps)
- **Java 21 Support**: WebSphere Liberty 23.0.0.9+
- **Jakarta EE**: Jakarta EE 9.1/10 support
- **Deployment**: WAR/EAR with server.xml configuration

### Mainframe (BCN Platform)
- **Java 21**: IBM Semeru Runtime
- **Memory Optimization**: Reduced heap requirements
- **Performance**: Optimized for mainframe constraints

## External System Integrations

### Database Systems
- **SQL Server**: JDBC driver compatibility with Java 21
- **DB2**: IBM DB2 JDBC driver updates
- **MongoDB**: Java driver 4.x+ for Java 21 support

### Messaging Systems
- **IBM MQ**: JMS 3.0 (Jakarta) compatibility
- **Connection Factories**: Updated for Jakarta namespace

## Security and Utilities

### Security Dependencies
```xml
<!-- Spring Security (current) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>2.2.4.RELEASE</version>
</dependency>
```

### Utility Libraries
```xml
<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>  <!-- Current -->
    <!-- Target: 1.18.30+ for Java 21 support -->
</dependency>
```

## Migration Compatibility Matrix

| Component | Java 8 + Spring 5 | Java 21 + Spring 6 | Migration Required |
|-----------|-------------------|--------------------|--------------------|
| Spring Framework | 5.2.3.RELEASE | 6.1.0 | Yes - Major version |
| Spring Boot | 2.2.4.RELEASE | 3.2.0 | Yes - Major version |
| JUnit | 4.12 | 5.10.x | Yes - API changes |
| javax.* | 2.x | jakarta.* 3.x | Yes - Namespace change |
| Hibernate | 5.4.x | 6.x | Automatic with Spring Boot |
| HikariCP | 3.4.2 | 5.x | Yes - Version update |
| Lombok | 1.18.10 | 1.18.30+ | Yes - Java 21 support |
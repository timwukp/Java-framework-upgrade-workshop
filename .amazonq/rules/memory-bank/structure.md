# Project Structure and Architecture

## Directory Organization

### Root Level Structure
```
Java-framework-upgrade-workshop/
├── .amazonq/rules/memory-bank/          # Amazon Q Developer memory bank documentation
├── sample-app/                          # Core sample application for migration
├── Module-*.md                          # Workshop module guides (1-5)
├── Amazon-Q-Developer-IDE-Workshop.md   # Main workshop documentation
├── INSTRUCTOR-QUICK-START.md            # Instructor setup guide
├── PARTICIPANT-SETUP.md                 # Participant prerequisites
├── Developer-Test-Walkthrough.md        # Testing procedures
├── Quick-Reference-Guide.md             # Command reference
└── Workshop-Agenda.md                   # Schedule and timeline
```

### Sample Application Structure
```
sample-app/
├── pom.xml                              # Maven configuration (Java 8, Spring 5.2.3)
├── README.md                            # Application documentation and verification
├── src/main/java/com/enterprise/user/   # Main application code
│   ├── UserManagementApplication.java   # Spring Boot main class
│   ├── entity/User.java                 # JPA entity with javax imports
│   ├── repository/UserRepository.java   # Spring Data JPA repository
│   ├── service/UserService.java         # Business logic layer
│   ├── controller/UserController.java   # REST API endpoints
│   └── config/SecurityConfig.java       # Spring Security configuration
├── src/main/resources/
│   └── application.properties           # Application configuration
└── src/test/java/com/enterprise/user/
    └── service/UserServiceTest.java     # JUnit 4 test suite
```

## Core Components and Relationships

### Application Architecture
- **Layered Architecture**: Controller → Service → Repository → Entity pattern
- **Spring Boot Application**: Auto-configuration with embedded server
- **RESTful API**: HTTP endpoints for user management operations
- **JPA Integration**: Database persistence with Spring Data JPA
- **Security Layer**: Authentication and authorization with Spring Security

### Component Relationships
```
UserController (REST Layer)
    ↓ depends on
UserService (Business Layer)
    ↓ depends on
UserRepository (Data Layer)
    ↓ depends on
User (Entity Layer)
    ↓ persisted to
Database (SQL Server/DB2)
```

### Configuration Components
- **SecurityConfig**: Extends WebSecurityConfigurerAdapter (Spring 5 pattern)
- **Application Properties**: Database connection, server configuration
- **Maven POM**: Dependency management and build configuration

## Architectural Patterns

### Pre-Migration Patterns (Current State)
- **Java 8 Date API**: Using java.util.Date instead of LocalDateTime
- **javax Namespace**: Using javax.persistence, javax.validation, javax.servlet
- **Spring 5 Security**: WebSecurityConfigurerAdapter pattern
- **JUnit 4 Testing**: @Before, @Test, Assert.assertEquals patterns
- **Old Spring Annotations**: @RequestMapping instead of @GetMapping/@PostMapping

### Target Architecture Patterns (Post-Migration)
- **Java 21 Features**: Modern date/time API, enhanced performance
- **jakarta Namespace**: Jakarta EE 9+ compliance
- **Spring 6 Security**: SecurityFilterChain functional configuration
- **JUnit 5 Testing**: @BeforeEach, @Test, Assertions.assertEquals patterns
- **Modern Spring Annotations**: Specific HTTP method annotations

### Migration Strategy
1. **Phase 1**: Java 8 → Java 21 (Module 2)
2. **Phase 2**: Spring 5.2.3 → Spring 6 (Module 3)
3. **Phase 3**: Testing framework updates (Module 4)
4. **Phase 4**: Platform-specific validation (Module 5)

## Workshop Module Architecture

### Module Dependencies
```
Module 1 (Setup) → Module 2 (Java) → Module 3 (Spring) → Module 4 (Testing) → Module 5 (Platform)
```

### Module Scope
- **Module 1**: Environment setup and initial assessment
- **Module 2**: Java version upgrade and API modernization
- **Module 3**: Spring framework and dependency updates
- **Module 4**: Test framework migration and validation
- **Module 5**: Platform-specific deployment validation

## Platform Integration Points

### Target Platforms
- **BDP Platform**: JBoss EAP deployment (25 applications)
- **BPT Platform**: WebSphere deployment (2 applications)
- **BCN Platform**: Mainframe deployment (specialized requirements)

### External Integrations
- **Databases**: SQL Server, DB2, MongoDB
- **Messaging**: IBM MQ
- **Connection Pooling**: HikariCP
- **Security**: Enterprise authentication systems

## Documentation Architecture

### Workshop Guides
- **Instructor Materials**: Quick-start, agenda, test results
- **Participant Materials**: Setup guide, module walkthroughs
- **Reference Materials**: Quick reference, troubleshooting guides

### Code Documentation
- **README Files**: Application state verification and migration targets
- **Inline Comments**: Code examples showing before/after patterns
- **Migration Markers**: Clear identification of patterns requiring updates
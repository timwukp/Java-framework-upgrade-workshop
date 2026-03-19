# Java Framework Migration Workshop — AWS Kiro IDE

> **Comprehensive hands-on workshop for migrating Java 8 + Spring 5.2.3 applications to Java 21 + Spring 6 using AWS Kiro IDE**

[![Java](https://img.shields.io/badge/Java-8%20→%2021-orange)](https://openjdk.org/projects/jdk/21/)
[![Spring](https://img.shields.io/badge/Spring-5.2.3%20→%206.1.0-green)](https://spring.io/projects/spring-framework)
[![Workshop](https://img.shields.io/badge/Duration-8%20hours-blue)](./Workshop-Agenda.md)
[![Kiro IDE](https://img.shields.io/badge/Kiro-IDE-purple)](https://kiro.dev/)

## 🎯 Workshop Overview

This repository contains a **complete enterprise-grade workshop** designed to guide development teams through Java framework modernization using Kiro IDE. The workshop targets **27 enterprise applications** across BDP (25 apps), BPT (2 apps), and BCN platforms, providing hands-on experience with real-world migration scenarios.

### 🚀 What You'll Learn

- **Java 8 → Java 21 Migration**: Modern language features, API updates, and performance improvements
- **Spring 5.2.3 → Spring 6 Migration**: Framework modernization, Jakarta EE namespace migration, and security updates
- **Testing Framework Updates**: JUnit 4 → JUnit 5 migration with modern testing practices
- **Platform Deployment**: JBoss EAP, WebSphere, and mainframe compatibility
- **Kiro IDE Mastery**: AI-assisted migration using Specs, Hooks, Steering, Skills, Custom Agents, Powers, Chat, and Code Suggestions

## 📋 Table of Contents

- [Quick Start](#-quick-start)
- [Repository Structure](#-repository-structure)
- [Workshop Structure](#-workshop-structure)
- [Sample Application](#-sample-application)
- [Technology Stack](#-technology-stack)
- [Prerequisites](#-prerequisites)
- [Module Guides](#-module-guides)
- [Platform Support](#-platform-support)
- [Getting Help](#-getting-help)
- [Contributing](#-contributing)

## 🗂️ Repository Structure

```
Java-framework-upgrade-workshop/
├── .kiro/                               # Kiro IDE configuration (steering, agents, hooks, specs)
│   ├── steering/                        # Steering files for migration context
│   ├── agents/                          # Custom agents for workshop tasks
│   ├── hooks/                           # Agent hooks for automation
│   └── specs/                           # Kiro Specs for structured planning
├── sample-app/                          # Sample Java application for migration
├── Module-1-Environment-Setup.md        # Module 1: Setup & Assessment
├── Module-2-Java-Migration.md           # Module 2: Java 8 → 21
├── Module-3-Spring-Migration.md         # Module 3: Spring 5 → 6
├── Module-4-Testing-Validation.md       # Module 4: Testing & Validation
├── Module-5-Platform-Validation.md      # Module 5: Platform Validation
├── Kiro-IDE-Workshop.md                 # Main workshop guide
├── Quick-Reference-Guide.md             # Kiro IDE features reference
├── Workshop-Agenda.md                   # Schedule and timeline
├── INSTRUCTOR-QUICK-START.md            # Instructor setup guide
├── PARTICIPANT-SETUP.md                 # Participant prerequisites
├── Developer-Test-Walkthrough.md        # Testing procedures
├── TRAINING-KICKSTART.md                # Training quick start
├── LICENSE                              # MIT License
└── README.md                            # This file
```

## 🚀 Quick Start

### For Workshop Participants

1. **Clone the repository**:
   ```bash
   git clone https://github.com/timwukp/Java-framework-upgrade-workshop.git
   cd Java-framework-upgrade-workshop
   ```

2. **Verify prerequisites**:
   ```bash
   java -version    # Should show Java 21
   mvn -version     # Should show Maven 3.8+
   git --version    # Should show Git 2.x+
   ```

3. **Set up the sample application**:
   ```bash
   cd sample-app
   mvn clean compile
   mvn test
   ```

4. **Install Kiro IDE**:
   - Download Kiro IDE from [kiro.dev](https://kiro.dev/)
   - Install and launch Kiro IDE
   - Sign in with your Kiro account

5. **Open the workshop guide**: [Kiro IDE Workshop](./Kiro-IDE-Workshop.md)

6. **Start with Module 1**: [Environment Setup](./Module-1-Environment-Setup.md)

### For Instructors

See the [Instructor Quick Start Guide](./INSTRUCTOR-QUICK-START.md) for setup instructions and workshop delivery guidance.

## 🏗️ Workshop Structure

### Core Workshop (8 hours: 9:00 AM - 5:00 PM)

| Module | Duration | Focus Area | Key Activities |
|--------|----------|------------|----------------|
| **[Module 1](./Module-1-Environment-Setup.md)** | 90 min | Environment Setup & Assessment | Kiro IDE setup, Steering files, Powers catalog, migration planning |
| **[Module 2](./Module-2-Java-Migration.md)** | 120 min | Java 8 → Java 21 Migration | Kiro Specs, Custom Agent, Skill, Power Builder |
| **[Module 3](./Module-3-Spring-Migration.md)** | 120 min | Spring 5 → Spring 6 Migration | Custom Agent, Skills (Jakarta, Security), Power activation |
| **[Module 4](./Module-4-Testing-Validation.md)** | 90 min | Testing & Validation | Kiro Hooks, JUnit 4→5 Skill, Context Keys |

### Optional Extended Session (90 minutes)

| Module | Duration | Focus Area | Key Activities |
|--------|----------|------------|----------------|
| **[Module 5](./Module-5-Platform-Validation.md)** | 90 min | Platform-Specific Validation | Platform Deployment Power, JBoss EAP, WebSphere, mainframe |

## 📱 Sample Application

The workshop includes a **complete user management service** that demonstrates real-world enterprise patterns:

### Application Features
- **REST API**: Full CRUD operations for user management
- **Spring Security**: Authentication and authorization
- **JPA Integration**: Database persistence with Spring Data JPA
- **Comprehensive Testing**: Unit and integration tests
- **Enterprise Patterns**: Layered architecture, dependency injection, validation

### Current State (Pre-Migration)
```
📦 sample-app/
├── 🔧 pom.xml                          # Java 8, Spring 5.2.3, JUnit 4
├── 📁 src/main/java/com/enterprise/user/
│   ├── 🚀 UserManagementApplication.java # Spring Boot main class
│   ├── 📊 entity/User.java              # JPA entity (javax.*, Date API)
│   ├── 🗄️ repository/UserRepository.java # Spring Data JPA
│   ├── ⚙️ service/UserService.java       # Business logic
│   ├── 🌐 controller/UserController.java # REST endpoints (old annotations)
│   └── 🔒 config/SecurityConfig.java     # Spring Security (deprecated pattern)
└── 🧪 src/test/java/                    # JUnit 4 test suite
```

### Migration Targets
- ✅ **Java 21**: Modern language features and performance
- ✅ **Spring 6.1.0**: Latest framework with Jakarta EE support
- ✅ **Spring Boot 3.2.0**: Modern auto-configuration
- ✅ **JUnit 5**: Modern testing framework
- ✅ **Jakarta Namespace**: EE 9+ compliance
- ✅ **Modern APIs**: LocalDateTime, SecurityFilterChain, etc.

## 🛠️ Technology Stack

### Migration Path

| Component | Before (Current) | After (Target) | Migration Type |
|-----------|------------------|----------------|----------------|
| **Java** | 1.8 | 21 (LTS) | Major version upgrade |
| **Spring Framework** | 5.2.3.RELEASE | 6.1.0 | Major version upgrade |
| **Spring Boot** | 2.2.4.RELEASE | 3.2.0 | Major version upgrade |
| **JUnit** | 4.12 | 5.10.x | Framework migration |
| **Namespace** | javax.* | jakarta.* | Package migration |
| **Date API** | java.util.Date | java.time.LocalDateTime | API modernization |
| **Security** | WebSecurityConfigurerAdapter | SecurityFilterChain | Pattern migration |

### Platform Compatibility

| Platform | Applications | Java 21 Support | Jakarta EE Support |
|----------|-------------|------------------|-------------------|
| **JBoss EAP** | 25 apps (BDP) | EAP 8.0+ | Jakarta EE 10 |
| **WebSphere** | 2 apps (BPT) | Liberty 23.0.0.9+ | Jakarta EE 9.1/10 |
| **Mainframe** | BCN platform | IBM Semeru Runtime | Optimized deployment |

### External Integrations
- **Databases**: SQL Server, DB2, MongoDB
- **Messaging**: IBM MQ (JMS 3.0)
- **Connection Pooling**: HikariCP
- **Security**: Enterprise authentication systems

## 📋 Prerequisites

### Required Software
- **Java 21 JDK** (OpenJDK or Oracle)
- **Maven 3.8+** or Gradle 7+
- **Git 2.x+**
- **Kiro IDE** (standalone AI-powered IDE — download from [kiro.dev](https://kiro.dev/))

### Kiro IDE Setup
- Kiro account (sign up at [kiro.dev](https://kiro.dev/))
- Kiro IDE installed and signed in

### Knowledge Prerequisites
- Java development experience
- Spring Framework familiarity
- Maven/Gradle build tools
- Basic Git operations
- REST API concepts

### Verification Commands
```bash
# Verify Java 21
java -version

# Verify Maven
mvn -version

# Verify Git
git --version

# Test sample application
cd sample-app
mvn clean compile test
```

## 📚 Module Guides

### Core Modules

1. **[Module 1: Environment Setup & Assessment](./Module-1-Environment-Setup.md)**
   - Kiro IDE setup, Steering files, and Powers catalog
   - Project analysis and migration planning
   - Risk assessment and baseline establishment

2. **[Module 2: Java 8 → Java 21 Migration](./Module-2-Java-Migration.md)**
   - Code transformation using Kiro Specs workflow
   - Java Migration Custom Agent and Java 8→21 Migration Skill
   - Power Builder: Java Framework Migration Power

3. **[Module 3: Spring 5 → Spring 6 Migration](./Module-3-Spring-Migration.md)**
   - Spring Migration Custom Agent with Jakarta Namespace Migration Skill
   - Spring Security Upgrade Skill
   - Kiro Chat with Context Keys for framework updates

4. **[Module 4: Testing & Validation](./Module-4-Testing-Validation.md)**
   - Kiro Hooks for automated code review
   - JUnit 4→5 Migration Skill
   - Kiro Chat with #Problems and #Git Diff Context Keys

### Optional Module

5. **[Module 5: Platform-Specific Validation](./Module-5-Platform-Validation.md)**
   - Platform Deployment Power for JBoss EAP, WebSphere, and mainframe
   - Kiro Chat for platform-specific guidance

### Additional Resources

- **[Kiro IDE Workshop Guide](./Kiro-IDE-Workshop.md)**: Main workshop document with full Kiro IDE feature walkthrough
- **[Workshop Agenda](./Workshop-Agenda.md)**: Detailed schedule and timeline
- **[Quick Reference Guide](./Quick-Reference-Guide.md)**: Kiro IDE features reference and troubleshooting
- **[Participant Setup](./PARTICIPANT-SETUP.md)**: Pre-workshop preparation
- **[Developer Test Walkthrough](./Developer-Test-Walkthrough.md)**: Testing procedures

## 🏢 Platform Support

### Enterprise Deployment Targets

#### JBoss EAP (25 Applications - BDP Platform)
- **Version**: JBoss EAP 8.0+ for Java 21 support
- **Features**: Full Jakarta EE 10 compliance
- **Deployment**: WAR packaging with jboss-deployment-structure.xml
- **Configuration**: Module exclusions and ClassLoader optimization

#### WebSphere Liberty (2 Applications - BPT Platform)
- **Version**: WebSphere Liberty 23.0.0.9+ for Java 21 support
- **Features**: Jakarta EE 9.1/10 support
- **Deployment**: WAR/EAR with server.xml configuration
- **Configuration**: Feature enablement and resource definitions

#### Mainframe (BCN Platform)
- **Runtime**: IBM Semeru Runtime for Java 21
- **Optimization**: Memory-optimized configurations
- **Integration**: DB2 and IBM MQ connectivity
- **Performance**: Mainframe-specific JVM tuning

## 🆘 Getting Help

### During the Workshop

1. **Kiro IDE**: Primary tool for guidance and troubleshooting — use Kiro Chat with Context Keys (#File, #Problems, #Git Diff) for targeted help
   ```
   Ask Kiro: "How do I fix this Java 21 migration error: [error message]" #Problems
   Ask Kiro: "Convert this Spring 5 security configuration to Spring 6" #File
   Ask Kiro: "Migrate this JUnit 4 test to JUnit 5" #File
   ```

2. **Instructor Support**: Hands-on assistance and guidance
3. **Peer Collaboration**: Learn from other participants
4. **Documentation**: Comprehensive guides and references

### Post-Workshop Support

- **Kiro IDE Documentation**: [Kiro IDE](https://kiro.dev/docs)
- **Spring Migration Guide**: [Spring Framework 6.0](https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-6.x)
- **Java Migration Guide**: [Oracle Java 21](https://docs.oracle.com/en/java/javase/21/migrate/)

### Common Issues and Solutions

See the [Quick Reference Guide](./Quick-Reference-Guide.md) for:
- Common migration errors and fixes
- Kiro IDE best practices
- Platform-specific troubleshooting
- Performance optimization tips

## 🤝 Contributing

### Workshop Improvements

We welcome contributions to improve the workshop experience:

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/improvement-name`
3. **Make your changes** with clear documentation
4. **Test thoroughly** with the sample application
5. **Submit a pull request** with detailed description

### Areas for Contribution

- Additional platform configurations
- Enhanced testing scenarios
- Performance optimization examples
- Security best practices
- Documentation improvements

### Feedback

- **Workshop Feedback**: Use the post-workshop survey
- **Technical Issues**: Create GitHub issues with detailed descriptions
- **Feature Requests**: Discuss in GitHub discussions

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](./LICENSE) file for details.

## 📞 Support

- **Kiro IDE**: [Documentation and Support](https://kiro.dev/docs)
- **Spring Migration Guide**: [Upgrading to Spring 6.x](https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-6.x)
- **Java Migration Guide**: [Oracle Java 21 Migration](https://docs.oracle.com/en/java/javase/21/migrate/)
- **Issues**: [GitHub Issues](https://github.com/timwukp/Java-framework-upgrade-workshop/issues)

---

## 🎉 Success Metrics

By completing this workshop, participants will:

- ✅ Successfully migrate a complete Java 8 + Spring 5 application to Java 21 + Spring 6
- ✅ Master Kiro IDE for AI-assisted development including Specs, Hooks, Steering, Skills, Custom Agents, and Powers
- ✅ Understand modern Java and Spring framework patterns
- ✅ Be equipped to migrate production enterprise applications
- ✅ Have platform-specific deployment knowledge for JBoss EAP, WebSphere, and mainframe

**Ready to modernize your Java applications? Start with [Module 1: Environment Setup](./Module-1-Environment-Setup.md)!**

---

*Workshop Version: 2.0 (Kiro IDE) | Last Updated: March 2026*

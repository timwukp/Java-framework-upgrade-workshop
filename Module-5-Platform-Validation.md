# Module 5: Platform-Specific Validation (90 minutes)

## Hands-On Training Guide - Optional Extended Session

### Overview
This module covers platform-specific deployment and validation for:
- **BDP Platform**: JBoss EAP (25 applications)
- **BPT Platform**: WebSphere (2 applications)
- **BCN Platform**: Mainframe

---

## Part 0: Build a Platform Deployment Power (10 minutes)

Before diving into platform-specific exercises, you'll create a **Platform Deployment Power** that bundles deployment knowledge for all three target platforms into a reusable, shareable package. This Power gives Kiro deep context about your organization's deployment environments so it can provide more accurate, platform-aware guidance throughout this module.

### What Is the Platform Deployment Power?

A Kiro Power is a packaged bundle of documentation, steering files, and optionally MCP servers that extend Kiro IDE's capabilities for a specific domain. The **Platform Deployment Power** packages:

- **POWER.md**: A comprehensive reference covering JBoss EAP, WebSphere, and Mainframe deployment patterns, common pitfalls, and best practices for Java 21 + Spring 6 applications
- **Steering files**: Platform-specific configuration templates and deployment checklists (e.g., `jboss-deployment.md`, `websphere-deployment.md`, `mainframe-deployment.md`)
- **Optional MCP server**: Could expose tools for validating deployment descriptors or generating platform-specific configurations

### Exercise 0.1: Build the Power with Power Builder

**Step 1: Open Power Builder**

In Kiro IDE, open the Powers management panel and select **Build a Power**. This launches the Power Builder, which guides you through creating a custom Power.

**Step 2: Define the Power structure**

Create the following file structure for your Power:

```
platform-deployment-power/
├── POWER.md
├── steering/
│   ├── jboss-deployment.md
│   ├── websphere-deployment.md
│   └── mainframe-deployment.md
```

**Step 3: Write POWER.md**

The `POWER.md` file is the Power's main documentation. It should describe the Power's purpose and provide deployment guidance:

```markdown
# Platform Deployment Power

## Purpose
Provides deployment knowledge for migrating Java 21 + Spring 6 applications
to enterprise platforms: JBoss EAP, WebSphere, and Mainframe (z/OS).

## Platforms Covered
- **JBoss EAP**: Module exclusions, deployment descriptors, datasource config
- **WebSphere**: ClassLoader policies, IBM deployment descriptors, resource config
- **Mainframe**: JVM tuning, memory optimization, DB2 integration

## Usage
Activate this Power when working on platform-specific deployment tasks.
Kiro will use the steering files to provide platform-aware guidance.
```

**Step 4: Add platform steering files**

Each steering file provides Kiro with platform-specific context. For example, `steering/jboss-deployment.md`:

```markdown
# JBoss EAP Deployment Guide

## Target Environment
- JBoss EAP 8.x with Java 21 and Jakarta EE 10 support
- Spring Framework 6 with embedded Hibernate and Jackson

## Key Patterns
- Exclude conflicting JBoss modules via jboss-deployment-structure.xml
- Use application-provided Jakarta EE APIs instead of server-provided
- Configure datasources via standalone.xml or Spring configuration

## Common Pitfalls
- ClassNotFoundException when JBoss modules conflict with application dependencies
- Hibernate version mismatch between JBoss-provided and application-embedded versions
```

Create similar steering files for WebSphere and Mainframe with platform-specific deployment patterns.

**Step 5: Validate and save the Power**

Use the Power Builder's validation step to confirm the Power structure is correct and all files are properly formatted. Save the Power to your workspace.

### Exercise 0.2: Activate the Power

**Step 1:** In the Powers management panel, locate your newly built **Platform Deployment Power** and click **Activate**.

**Step 2:** Verify activation by asking Kiro Chat:
```
Ask Kiro:
"What platforms does the Platform Deployment Power cover?
Summarize the deployment guidance available for each platform."
```

Kiro should reference the Power's documentation and steering files in its response.

### Exercise 0.3: Share the Power with Your Team

To share the Platform Deployment Power with other team members:

1. **Export the Power**: From the Powers management panel, select your Power and choose **Export**. This creates a distributable Power package.
2. **Distribute**: Share the exported Power file via your team's artifact repository, shared drive, or version control system.
3. **Team installation**: Team members can import the Power through their own Powers management panel by selecting **Import Power** and pointing to the shared package.

This ensures every team member working on platform deployments has the same deployment knowledge available in their Kiro IDE.

---

## Part 1: BDP Platform - JBoss EAP (35 minutes)

### Exercise 5.1: JBoss EAP Compatibility Check
**Tool: Kiro Chat - Platform Analysis**

**Step 1: Verify JBoss version**
```
Ask Kiro:
"What JBoss EAP version supports:
- Java 21
- Spring Framework 6
- Jakarta EE 10

What are the minimum version requirements?"
```

**Step 2: Identify conflicts**
```
Ask Kiro:
"Analyze my Spring 6 application for JBoss EAP deployment conflicts:
- Module conflicts
- ClassLoader issues
- Dependency overlaps
- Configuration requirements

Dependencies:
[paste pom.xml dependencies]"
```

### Exercise 5.2: Create JBoss Deployment Descriptor
**Tool: Kiro Chat - Descriptor Generation**

**Generate jboss-deployment-structure.xml:**
```
Ask Kiro:
"Generate jboss-deployment-structure.xml for Spring 6 application on JBoss EAP.
Exclude JBoss modules that conflict with:
- Spring Framework 6
- Hibernate (using embedded version)
- Jackson (using embedded version)
- Jakarta EE APIs (using application versions)"
```

**Apply generated descriptor:**
```xml
<!-- Kiro will generate something like: -->
<?xml version="1.0" encoding="UTF-8"?>
<jboss-deployment-structure>
    <deployment>
        <exclusions>
            <module name="org.springframework.spring" />
            <module name="org.hibernate" />
            <module name="com.fasterxml.jackson.core.jackson-core" />
            <module name="jakarta.persistence.api" />
            <module name="jakarta.validation.api" />
        </exclusions>
        <dependencies>
            <module name="org.jboss.logging" />
        </dependencies>
    </deployment>
</jboss-deployment-structure>
```

### Exercise 5.3: Configure JBoss-Specific Settings
**Tool: Kiro Chat - JBoss Configuration**

**Generate jboss-web.xml:**
```
Ask Kiro:
"Generate jboss-web.xml for Spring 6 application with:
- Context root: /myapp
- Security domain: java:/jaas/myapp
- Virtual host: default-host"
```

**Configure datasource:**
```
Ask Kiro:
"Generate JBoss EAP datasource configuration for:
- Database: SQL Server
- JNDI name: java:jboss/datasources/MyAppDS
- Connection pool: min=5, max=20
- Validation query

Include both standalone.xml snippet and Spring configuration."
```

### Exercise 5.4: Package for JBoss Deployment
**Tool: Kiro Chat - Build Configuration**

**Update Maven for WAR packaging:**
```
Ask Kiro:
"Update my pom.xml to package Spring 6 application as WAR for JBoss EAP:
- Packaging: war
- Exclude embedded Tomcat
- Include JBoss-specific dependencies
- Configure Maven WAR plugin"
```

**Build WAR file:**
```bash
mvn clean package

# Verify WAR structure
jar -tf target/myapp.war

# Ask Kiro if structure looks wrong:
"Is this WAR structure correct for JBoss EAP deployment?
[paste jar -tf output]"
```

### Exercise 5.5: Deploy and Test on JBoss
**Tool: Kiro Chat - Deployment Troubleshooting**

**Deploy to JBoss:**
```bash
# Copy WAR to JBoss
cp target/myapp.war $JBOSS_HOME/standalone/deployments/

# Monitor deployment
tail -f $JBOSS_HOME/standalone/log/server.log
```

**If deployment fails:**
```
Ask Kiro:
"JBoss EAP deployment fails with error:
[paste error from server.log]

Application: Spring 6 + Java 21
JBoss version: [version]

How do I fix this?"
```

**Test deployed application:**
```bash
# Health check
curl http://localhost:8080/myapp/actuator/health

# API test
curl http://localhost:8080/myapp/api/users

# Ask Kiro if issues:
"Application deployed but endpoints return 404:
[paste curl output]
What's wrong with my JBoss configuration?"
```

---

## Part 2: BPT Platform - WebSphere (30 minutes)

### Exercise 5.6: WebSphere Compatibility Analysis
**Tool: Kiro Chat - WebSphere Planning**

**Check WebSphere version:**
```
Ask Kiro:
"What WebSphere Application Server version supports:
- Java 21
- Spring Framework 6
- Jakarta EE 10

What are the compatibility requirements and limitations?"
```

**Identify WebSphere-specific issues:**
```
Ask Kiro:
"What are common issues deploying Spring 6 applications to WebSphere?
How do I handle:
- ClassLoader policies
- Shared libraries
- Parent-last class loading
- WebSphere-specific APIs"
```

### Exercise 5.7: Create WebSphere Deployment Descriptors
**Tool: Kiro Chat - WebSphere Configuration**

**Generate ibm-web-ext.xml:**
```
Ask Kiro:
"Generate ibm-web-ext.xml for Spring 6 application on WebSphere with:
- Context root: /myapp
- ClassLoader mode: PARENT_LAST
- WAR class loader policy: SINGLE
- File serving: disabled"
```

**Generate ibm-web-bnd.xml:**
```
Ask Kiro:
"Generate ibm-web-bnd.xml for Spring 6 application with:
- Virtual host: default_host
- Resource references for datasources
- Security role mappings"
```

### Exercise 5.8: Configure WebSphere Resources
**Tool: Kiro Chat - Resource Configuration**

**DataSource configuration:**
```
Ask Kiro:
"Provide WebSphere Admin Console steps to configure:
- JDBC Provider for SQL Server
- DataSource with JNDI: jdbc/MyAppDS
- Connection pool settings
- Test connection

Also provide Spring configuration to use this datasource."
```

**JMS configuration (if applicable):**
```
Ask Kiro:
"Provide WebSphere configuration for IBM MQ:
- Queue Connection Factory
- Queue: MY.APP.QUEUE
- JNDI bindings
- Spring JMS configuration"
```

### Exercise 5.9: Package for WebSphere
**Tool: Kiro Chat - WebSphere Packaging**

**Update build configuration:**
```
Ask Kiro:
"Update pom.xml for WebSphere deployment:
- Package as WAR
- Exclude embedded server
- Add WebSphere-specific dependencies
- Configure shared libraries"
```

**Build and validate:**
```bash
mvn clean package

# Ask Kiro to validate:
"Validate this WAR for WebSphere deployment:
[paste WAR structure]

Are there any WebSphere-specific issues?"
```

### Exercise 5.10: Deploy to WebSphere
**Tool: Kiro Chat - Deployment Guide**

**Get deployment steps:**
```
Ask Kiro:
"Provide step-by-step WebSphere deployment instructions:
1. Admin Console access
2. Application installation
3. Configuration steps
4. Start application
5. Verify deployment
6. Test endpoints"
```

**Troubleshoot deployment:**
```
If deployment fails, ask Kiro:
"WebSphere deployment error:
[paste error from SystemOut.log]

How do I resolve this for Spring 6 application?"
```

---

## Part 3: BCN Platform - Mainframe (25 minutes)

### Exercise 5.11: Mainframe Deployment Analysis
**Tool: Kiro Chat - Mainframe Considerations**

**Understand constraints:**
```
Ask Kiro:
"What are key considerations for deploying Java 21 + Spring 6 on mainframe:
- Memory constraints
- CPU optimization
- I/O efficiency
- Integration with mainframe systems (DB2, CICS, etc.)
- Performance tuning"
```

**Optimize for mainframe:**
```
Ask Kiro:
"How do I optimize Spring 6 application for mainframe deployment:
- Reduce memory footprint
- Minimize startup time
- Optimize thread usage
- Configure garbage collection
- Tune connection pools"
```

### Exercise 5.12: Mainframe-Specific Configuration
**Tool: Kiro Chat - Configuration Optimization**

**JVM tuning:**
```
Ask Kiro:
"Generate JVM arguments for Java 21 on mainframe with:
- Heap size: 512MB max
- Garbage collector: optimized for low pause
- Thread stack size: minimal
- JIT compilation: balanced
- Monitoring: enabled"
```

**Spring configuration:**
```
Ask Kiro:
"Generate mainframe-optimized Spring 6 configuration:
- Minimal auto-configuration
- Lazy initialization where possible
- Reduced thread pools
- Optimized connection pools
- Disabled unnecessary features"
```

### Exercise 5.13: DB2 Integration
**Tool: Kiro Chat - DB2 Configuration**

**Configure DB2 connectivity:**
```
Ask Kiro:
"Generate Spring 6 configuration for DB2 on mainframe:
- JDBC driver: DB2 for z/OS
- Connection pool: optimized for mainframe
- Transaction management
- Query optimization hints
- Error handling"
```

**Test DB2 connection:**
```
Ask Kiro:
"Generate integration test for DB2 mainframe connection:
- Connection validation
- Basic CRUD operations
- Transaction handling
- Performance benchmarks
- Error scenarios"
```

### Exercise 5.14: Mainframe Deployment Package
**Tool: Kiro Chat - Packaging Strategy**

**Create deployment package:**
```
Ask Kiro:
"What should I include in mainframe deployment package:
- Application JAR/WAR
- Configuration files
- JVM arguments
- Startup scripts
- Monitoring setup
- Rollback procedures"
```

**Generate startup script:**
```
Ask Kiro:
"Generate mainframe startup script for Java 21 + Spring 6 application:
- Set environment variables
- Configure JVM arguments
- Start application
- Log output
- Health check
- Error handling"
```

---

## Part 4: Cross-Platform Validation (10 minutes)

### Exercise 5.15: Platform Comparison Matrix
**Tool: Kiro Chat - Comparison Analysis**

**Generate comparison:**
```
Ask Kiro:
"Create a comparison matrix for Java 21 + Spring 6 deployment across:
- JBoss EAP
- WebSphere
- Mainframe

Compare:
- Deployment complexity
- Configuration differences
- Performance characteristics
- Monitoring approaches
- Common issues"
```

### Exercise 5.16: Create Platform-Specific Checklists
**Tool: Kiro Chat - Checklist Generation**

**For each platform:**
```
Ask Kiro:
"Generate deployment checklist for [JBoss EAP/WebSphere/Mainframe]:

Pre-deployment:
- [ ] ...

Deployment:
- [ ] ...

Post-deployment:
- [ ] ...

Validation:
- [ ] ...

Rollback:
- [ ] ..."
```

---

## Module 5 Completion Checklist

**JBoss EAP (BDP - 25 apps):**
- [ ] JBoss version compatibility verified
- [ ] Deployment descriptors created
- [ ] Module exclusions configured
- [ ] WAR packaging successful
- [ ] Test deployment successful
- [ ] All endpoints responding
- [ ] Integration tests passing

**WebSphere (BPT - 2 apps):**
- [ ] WebSphere version compatibility verified
- [ ] IBM deployment descriptors created
- [ ] ClassLoader configuration set
- [ ] Resources configured (datasource, JMS)
- [ ] WAR packaging successful
- [ ] Test deployment successful
- [ ] All endpoints responding

**Mainframe (BCN):**
- [ ] Mainframe constraints understood
- [ ] JVM tuning configured
- [ ] Spring configuration optimized
- [ ] DB2 integration tested
- [ ] Deployment package created
- [ ] Startup scripts generated
- [ ] Performance benchmarks met

**Cross-Platform:**
- [ ] Comparison matrix created
- [ ] Platform-specific checklists ready
- [ ] Common issues documented
- [ ] Rollback procedures defined

---

## Key Kiro IDE Features Used

| Feature | Purpose | Usage |
|---------|---------|-------|
| **Kiro Chat** | Platform analysis, configuration generation, troubleshooting, and optimization guidance | Throughout all exercises |
| **Kiro Code Suggestions** | Inline completions for deployment descriptors, XML configurations, and startup scripts | During configuration editing |
| **Platform Deployment Power** | Bundled deployment knowledge for JBoss EAP, WebSphere, and Mainframe — provides platform-aware context to Kiro | Activated in Part 0, used throughout |

---

## Common Platform Issues & Solutions

### JBoss EAP Issues

**Issue: ClassNotFoundException for Spring classes**
```
Solution:
Ask Kiro:
"ClassNotFoundException for Spring classes on JBoss:
[paste error]
What modules should I exclude in jboss-deployment-structure.xml?"
```

**Issue: Hibernate version conflict**
```
Solution:
Ask Kiro:
"Hibernate version conflict on JBoss EAP:
[paste error]
How do I force application to use embedded Hibernate?"
```

### WebSphere Issues

**Issue: ClassLoader conflicts**
```
Solution:
Ask Kiro:
"ClassLoader conflict on WebSphere:
[paste error]
What ClassLoader policy should I use in ibm-web-ext.xml?"
```

**Issue: Slow startup time**
```
Solution:
Ask Kiro:
"Spring 6 application takes 5 minutes to start on WebSphere.
How do I optimize startup time?"
```

### Mainframe Issues

**Issue: Out of memory errors**
```
Solution:
Ask Kiro:
"OutOfMemoryError on mainframe with 512MB heap:
[paste error]
How do I reduce Spring 6 memory footprint?"
```

**Issue: DB2 connection pool exhaustion**
```
Solution:
Ask Kiro:
"DB2 connection pool exhausted on mainframe:
[paste error]
How do I optimize connection pool for mainframe constraints?"
```

---

## Platform-Specific Best Practices

### JBoss EAP
```
Ask Kiro:
"What are JBoss EAP best practices for Spring 6 applications:
1. Module management
2. ClassLoader configuration
3. Resource management
4. Monitoring and logging
5. Performance tuning"
```

### WebSphere
```
Ask Kiro:
"What are WebSphere best practices for Spring 6 applications:
1. ClassLoader policies
2. Shared library usage
3. Resource configuration
4. Security integration
5. Performance optimization"
```

### Mainframe
```
Ask Kiro:
"What are mainframe best practices for Java 21 + Spring 6:
1. Memory management
2. CPU optimization
3. I/O efficiency
4. Integration patterns
5. Monitoring strategies"
```

---

## Production Readiness

### Exercise 5.17: Final Platform Validation
**Tool: Kiro Chat - Production Checklist**

**Generate production checklist:**
```
Ask Kiro:
"Generate production readiness checklist for Java 21 + Spring 6 migration across:
- 25 JBoss EAP applications
- 2 WebSphere applications
- Mainframe applications

Include:
- Technical validation
- Performance benchmarks
- Security verification
- Monitoring setup
- Rollback procedures
- Documentation requirements"
```

---

## Next Steps

After completing Module 5, you should have:
1. Platform-specific configurations for all target environments
2. Successful test deployments on each platform
3. Platform-specific troubleshooting guides
4. Production deployment procedures
5. Rollback plans for each platform

**Ready for Production Migration:**
- Begin with pilot applications (BPT - 2 apps)
- Roll out to BDP applications (25 apps)
- Complete BCN mainframe migration
- Monitor and optimize in production
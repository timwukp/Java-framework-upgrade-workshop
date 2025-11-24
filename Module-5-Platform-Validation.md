# Module 5: Platform-Specific Validation (90 minutes)

## Hands-On Training Guide - Optional Extended Session

### Overview
This module covers platform-specific deployment and validation for:
- **BDP Platform**: JBoss EAP (25 applications)
- **BPT Platform**: WebSphere (2 applications)
- **BCN Platform**: Mainframe

---

## Part 1: BDP Platform - JBoss EAP (35 minutes)

### Exercise 5.1: JBoss EAP Compatibility Check
**Tool: Q Chat - Platform Analysis**

**Step 1: Verify JBoss version**
```
Ask Q:
"What JBoss EAP version supports:
- Java 21
- Spring Framework 6
- Jakarta EE 10

What are the minimum version requirements?"
```

**Step 2: Identify conflicts**
```
Ask Q:
"Analyze my Spring 6 application for JBoss EAP deployment conflicts:
- Module conflicts
- ClassLoader issues
- Dependency overlaps
- Configuration requirements

Dependencies:
[paste pom.xml dependencies]"
```

### Exercise 5.2: Create JBoss Deployment Descriptor
**Tool: Q Chat - Descriptor Generation**

**Generate jboss-deployment-structure.xml:**
```
Ask Q:
"Generate jboss-deployment-structure.xml for Spring 6 application on JBoss EAP.
Exclude JBoss modules that conflict with:
- Spring Framework 6
- Hibernate (using embedded version)
- Jackson (using embedded version)
- Jakarta EE APIs (using application versions)"
```

**Apply generated descriptor:**
```xml
<!-- Q will generate something like: -->
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
**Tool: Q Chat - JBoss Configuration**

**Generate jboss-web.xml:**
```
Ask Q:
"Generate jboss-web.xml for Spring 6 application with:
- Context root: /myapp
- Security domain: java:/jaas/myapp
- Virtual host: default-host"
```

**Configure datasource:**
```
Ask Q:
"Generate JBoss EAP datasource configuration for:
- Database: SQL Server
- JNDI name: java:jboss/datasources/MyAppDS
- Connection pool: min=5, max=20
- Validation query

Include both standalone.xml snippet and Spring configuration."
```

### Exercise 5.4: Package for JBoss Deployment
**Tool: Q Chat - Build Configuration**

**Update Maven for WAR packaging:**
```
Ask Q:
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

# Ask Q if structure looks wrong:
"Is this WAR structure correct for JBoss EAP deployment?
[paste jar -tf output]"
```

### Exercise 5.5: Deploy and Test on JBoss
**Tool: Q Chat - Deployment Troubleshooting**

**Deploy to JBoss:**
```bash
# Copy WAR to JBoss
cp target/myapp.war $JBOSS_HOME/standalone/deployments/

# Monitor deployment
tail -f $JBOSS_HOME/standalone/log/server.log
```

**If deployment fails:**
```
Ask Q:
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

# Ask Q if issues:
"Application deployed but endpoints return 404:
[paste curl output]
What's wrong with my JBoss configuration?"
```

---

## Part 2: BPT Platform - WebSphere (30 minutes)

### Exercise 5.6: WebSphere Compatibility Analysis
**Tool: Q Chat - WebSphere Planning**

**Check WebSphere version:**
```
Ask Q:
"What WebSphere Application Server version supports:
- Java 21
- Spring Framework 6
- Jakarta EE 10

What are the compatibility requirements and limitations?"
```

**Identify WebSphere-specific issues:**
```
Ask Q:
"What are common issues deploying Spring 6 applications to WebSphere?
How do I handle:
- ClassLoader policies
- Shared libraries
- Parent-last class loading
- WebSphere-specific APIs"
```

### Exercise 5.7: Create WebSphere Deployment Descriptors
**Tool: Q Chat - WebSphere Configuration**

**Generate ibm-web-ext.xml:**
```
Ask Q:
"Generate ibm-web-ext.xml for Spring 6 application on WebSphere with:
- Context root: /myapp
- ClassLoader mode: PARENT_LAST
- WAR class loader policy: SINGLE
- File serving: disabled"
```

**Generate ibm-web-bnd.xml:**
```
Ask Q:
"Generate ibm-web-bnd.xml for Spring 6 application with:
- Virtual host: default_host
- Resource references for datasources
- Security role mappings"
```

### Exercise 5.8: Configure WebSphere Resources
**Tool: Q Chat - Resource Configuration**

**DataSource configuration:**
```
Ask Q:
"Provide WebSphere Admin Console steps to configure:
- JDBC Provider for SQL Server
- DataSource with JNDI: jdbc/MyAppDS
- Connection pool settings
- Test connection

Also provide Spring configuration to use this datasource."
```

**JMS configuration (if applicable):**
```
Ask Q:
"Provide WebSphere configuration for IBM MQ:
- Queue Connection Factory
- Queue: MY.APP.QUEUE
- JNDI bindings
- Spring JMS configuration"
```

### Exercise 5.9: Package for WebSphere
**Tool: Q Chat - WebSphere Packaging**

**Update build configuration:**
```
Ask Q:
"Update pom.xml for WebSphere deployment:
- Package as WAR
- Exclude embedded server
- Add WebSphere-specific dependencies
- Configure shared libraries"
```

**Build and validate:**
```bash
mvn clean package

# Ask Q to validate:
"Validate this WAR for WebSphere deployment:
[paste WAR structure]

Are there any WebSphere-specific issues?"
```

### Exercise 5.10: Deploy to WebSphere
**Tool: Q Chat - Deployment Guide**

**Get deployment steps:**
```
Ask Q:
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
If deployment fails, ask Q:
"WebSphere deployment error:
[paste error from SystemOut.log]

How do I resolve this for Spring 6 application?"
```

---

## Part 3: BCN Platform - Mainframe (25 minutes)

### Exercise 5.11: Mainframe Deployment Analysis
**Tool: Q Chat - Mainframe Considerations**

**Understand constraints:**
```
Ask Q:
"What are key considerations for deploying Java 21 + Spring 6 on mainframe:
- Memory constraints
- CPU optimization
- I/O efficiency
- Integration with mainframe systems (DB2, CICS, etc.)
- Performance tuning"
```

**Optimize for mainframe:**
```
Ask Q:
"How do I optimize Spring 6 application for mainframe deployment:
- Reduce memory footprint
- Minimize startup time
- Optimize thread usage
- Configure garbage collection
- Tune connection pools"
```

### Exercise 5.12: Mainframe-Specific Configuration
**Tool: Q Chat - Configuration Optimization**

**JVM tuning:**
```
Ask Q:
"Generate JVM arguments for Java 21 on mainframe with:
- Heap size: 512MB max
- Garbage collector: optimized for low pause
- Thread stack size: minimal
- JIT compilation: balanced
- Monitoring: enabled"
```

**Spring configuration:**
```
Ask Q:
"Generate mainframe-optimized Spring 6 configuration:
- Minimal auto-configuration
- Lazy initialization where possible
- Reduced thread pools
- Optimized connection pools
- Disabled unnecessary features"
```

### Exercise 5.13: DB2 Integration
**Tool: Q Chat - DB2 Configuration**

**Configure DB2 connectivity:**
```
Ask Q:
"Generate Spring 6 configuration for DB2 on mainframe:
- JDBC driver: DB2 for z/OS
- Connection pool: optimized for mainframe
- Transaction management
- Query optimization hints
- Error handling"
```

**Test DB2 connection:**
```
Ask Q:
"Generate integration test for DB2 mainframe connection:
- Connection validation
- Basic CRUD operations
- Transaction handling
- Performance benchmarks
- Error scenarios"
```

### Exercise 5.14: Mainframe Deployment Package
**Tool: Q Chat - Packaging Strategy**

**Create deployment package:**
```
Ask Q:
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
Ask Q:
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
**Tool: Q Chat - Comparison Analysis**

**Generate comparison:**
```
Ask Q:
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
**Tool: Q Chat - Checklist Generation**

**For each platform:**
```
Ask Q:
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

## Key Q Developer Commands Used

| Command | Purpose | Usage Count |
|---------|---------|-------------|
| Q Chat | Platform analysis | 10-15 times |
| Q Chat | Configuration generation | 15-20 times |
| Q Chat | Troubleshooting | 10-15 times |
| Q Chat | Optimization | 5-10 times |

---

## Common Platform Issues & Solutions

### JBoss EAP Issues

**Issue: ClassNotFoundException for Spring classes**
```
Solution:
Ask Q:
"ClassNotFoundException for Spring classes on JBoss:
[paste error]
What modules should I exclude in jboss-deployment-structure.xml?"
```

**Issue: Hibernate version conflict**
```
Solution:
Ask Q:
"Hibernate version conflict on JBoss EAP:
[paste error]
How do I force application to use embedded Hibernate?"
```

### WebSphere Issues

**Issue: ClassLoader conflicts**
```
Solution:
Ask Q:
"ClassLoader conflict on WebSphere:
[paste error]
What ClassLoader policy should I use in ibm-web-ext.xml?"
```

**Issue: Slow startup time**
```
Solution:
Ask Q:
"Spring 6 application takes 5 minutes to start on WebSphere.
How do I optimize startup time?"
```

### Mainframe Issues

**Issue: Out of memory errors**
```
Solution:
Ask Q:
"OutOfMemoryError on mainframe with 512MB heap:
[paste error]
How do I reduce Spring 6 memory footprint?"
```

**Issue: DB2 connection pool exhaustion**
```
Solution:
Ask Q:
"DB2 connection pool exhausted on mainframe:
[paste error]
How do I optimize connection pool for mainframe constraints?"
```

---

## Platform-Specific Best Practices

### JBoss EAP
```
Ask Q:
"What are JBoss EAP best practices for Spring 6 applications:
1. Module management
2. ClassLoader configuration
3. Resource management
4. Monitoring and logging
5. Performance tuning"
```

### WebSphere
```
Ask Q:
"What are WebSphere best practices for Spring 6 applications:
1. ClassLoader policies
2. Shared library usage
3. Resource configuration
4. Security integration
5. Performance optimization"
```

### Mainframe
```
Ask Q:
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
**Tool: Q Chat - Production Checklist**

**Generate production checklist:**
```
Ask Q:
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
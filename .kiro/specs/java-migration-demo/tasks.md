# Java Migration Tasks

## Overview

Migration from Java 8 to Java 21 for the sample application.

## Tasks

- [ ] 1. Update Maven compiler configuration
  - [ ] 1.1 Change source/target from 1.8 to 21 in pom.xml
  - [ ] 1.2 Update maven-compiler-plugin version to 3.11+
  - [ ] 1.3 Verify project compiles with new settings

- [ ] 2. Modernize Date/Time APIs
  - [ ] 2.1 Replace java.util.Date with java.time.LocalDateTime
  - [ ] 2.2 Update date formatting to use DateTimeFormatter
  - [ ] 2.3 Update entity lifecycle callbacks for new date types

- [ ] 3. Remove deprecated API usage
  - [ ] 3.1 Identify all deprecated API calls
  - [ ] 3.2 Replace with Java 21 equivalents
  - [ ] 3.3 Verify no deprecation warnings remain

- [ ] 4. Update dependencies for Java 21 compatibility
  - [ ] 4.1 Update Lombok to 1.18.30+
  - [ ] 4.2 Update database drivers
  - [ ] 4.3 Resolve any version conflicts

- [ ] 5. Validate and test
  - [ ] 5.1 Run full test suite
  - [ ] 5.2 Check for runtime issues
  - [ ] 5.3 Performance baseline comparison

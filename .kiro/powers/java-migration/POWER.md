# Java Framework Migration Power

A Kiro Power that packages Java 8 to 21 migration knowledge, patterns, and automation into a reusable bundle.

## Overview

This Power provides Kiro IDE with specialized knowledge for migrating Java applications from JDK 8 to JDK 21. When activated, it gives Kiro context about migration patterns, common pitfalls, and recommended approaches.

## What This Power Provides

### Documentation
- Java 8 to 21 migration best practices
- API replacement mappings (deprecated -> modern equivalents)
- Language feature adoption guidelines (records, sealed classes, pattern matching)
- Performance considerations for Java 21

### Steering Files
- `migration-patterns.md` - Common migration patterns and transformations
- `compatibility-checklist.md` - Pre-migration compatibility verification steps
- `dependency-matrix.md` - Dependency version compatibility for Java 21

### Optional MCP Server Integration
<!-- If you have custom tooling, document it here -->
- Custom analysis tools for identifying migration candidates
- Automated deprecation scanners

## Prerequisites

- Kiro IDE installed and configured
- Java 21 JDK available on the system
- Maven 3.9+ or Gradle 8+ build tool

## How to Install

1. Open Kiro IDE Powers panel
2. Search for "Java Framework Migration" in the catalog
3. Click Install
4. Activate the Power when working on Java migration projects

## How to Build This Power

1. Open Kiro IDE and navigate to Power Builder
2. Create a new Power with this POWER.md as the root document
3. Add steering files for migration patterns
4. (Optional) Configure MCP server for custom tooling
5. Validate the Power structure
6. Share with your team via the Powers catalog

## How to Use

Once activated:
- Ask Kiro about Java migration patterns and it will reference this Power's knowledge
- Use the included steering files to guide automated transformations
- Reference the compatibility checklist before starting migration work

## Power Structure

```
java-migration/
├── POWER.md              (this file - Power documentation)
├── steering/
│   ├── migration-patterns.md
│   ├── compatibility-checklist.md
│   └── dependency-matrix.md
└── mcp/                  (optional)
    └── server-config.json
```

## Sharing with Your Team

1. Export the Power as a bundle from Kiro IDE
2. Share via your organization's artifact repository
3. Team members install from the shared catalog
4. Everyone gets consistent migration guidance

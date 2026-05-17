# Platform Deployment Power

A Kiro Power that bundles platform-specific deployment knowledge for enterprise application servers (JBoss EAP, WebSphere, Mainframe).

## Overview

This Power provides Kiro IDE with deployment expertise across multiple enterprise platforms. When activated, it helps validate application compatibility and generates platform-specific configurations.

## What This Power Provides

### Documentation
- JBoss EAP 8.0 deployment guide and configuration patterns
- WebSphere Liberty 23.x migration and deployment guide
- IBM Mainframe (z/OS) Java deployment considerations
- Cross-platform compatibility validation checklist

### Steering Files
- `jboss-deployment.md` - JBoss EAP deployment patterns and jboss-web.xml configuration
- `websphere-deployment.md` - WebSphere Liberty server.xml configuration patterns
- `mainframe-deployment.md` - IBM Semeru Runtime optimization for z/OS
- `platform-matrix.md` - Feature support matrix across all platforms

### Optional MCP Server Integration
- Platform health check tooling
- Configuration validation endpoints
- Deployment pipeline integration

## Supported Platforms

| Platform | Version | Java Support | Jakarta EE |
|----------|---------|--------------|------------|
| JBoss EAP | 8.0+ | Java 21 | Jakarta EE 10 |
| WebSphere Liberty | 23.0.0.9+ | Java 21 | Jakarta EE 9.1/10 |
| IBM z/OS (Mainframe) | Semeru Runtime | Java 21 | N/A |

## Prerequisites

- Application successfully migrated to Java 21 + Spring 6
- Jakarta EE namespace migration completed
- All tests passing in local environment

## How to Install

1. Open Kiro IDE Powers panel
2. Search for "Platform Deployment" in the catalog
3. Click Install
4. Activate when preparing for platform-specific deployment

## How to Build This Power

1. Open Kiro IDE Power Builder
2. Create new Power with this POWER.md as root
3. Add platform-specific steering files
4. Configure MCP server for platform validation tools (optional)
5. Validate and publish

## How to Use

Once activated:
- Ask Kiro to generate platform-specific deployment configurations
- Use steering files for deployment validation checklists
- Reference platform matrix for feature compatibility checks

## Power Structure

```
platform-deployment/
├── POWER.md              (this file - Power documentation)
├── steering/
│   ├── jboss-deployment.md
│   ├── websphere-deployment.md
│   ├── mainframe-deployment.md
│   └── platform-matrix.md
└── mcp/                  (optional)
    └── server-config.json
```

## Sharing with Your Team

1. Export as a Power bundle
2. Publish to your organization's Powers catalog
3. Platform engineering teams install and activate as needed
4. Ensures consistent deployment practices across teams

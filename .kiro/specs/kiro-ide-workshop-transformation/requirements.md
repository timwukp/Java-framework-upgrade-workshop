# Requirements Document

## Introduction

This feature transforms the Java Framework Migration Workshop from using "Amazon Q Developer IDE Extension" to using "AWS Kiro IDE" as the development tool. The workshop's core purpose remains unchanged: guiding teams through migrating a Java 8 + Spring 5.2.3 enterprise application to Java 21 + Spring 6. Kiro IDE replaces Amazon Q Developer as the AI-assisted tool participants use throughout the migration, showcasing its full feature set: Specs, Hooks, Steering, Skills, Custom Agents, Powers, Chat, Code Suggestions, and Context Keys. All 14+ markdown files, the sample-app README, and the `.amazonq/rules/` directory must be updated. The sample application source code and all Java/Spring/platform deployment technical content remain untouched.

## Glossary

- **Kiro_IDE**: AWS Kiro, a standalone AI-powered IDE (not a VS Code/IntelliJ extension) used as the workshop's primary development tool
- **Kiro_Chat**: The conversational AI interface within Kiro IDE for migration guidance, code generation, and troubleshooting
- **Kiro_Specs**: Structured workflow in Kiro IDE (requirements → design → tasks) for planning and executing migration work; replaces the `/transform` command
- **Kiro_Hooks**: Automated agent actions triggered by IDE events (e.g., file edits, saves) for continuous code review; replaces the `/review` command
- **Kiro_Steering**: Project-level instruction files at `.kiro/steering/*.md` that provide Kiro with migration-specific context and constraints
- **Kiro_Skills**: Reusable, domain-specific capabilities that can be created, optimized, and triggered within Kiro IDE to automate repetitive migration patterns (e.g., a Java 8→21 migration skill, a Spring 5→6 migration skill, a JUnit 4→5 skill)
- **Kiro_Custom_Agents**: User-defined specialized sub-agents within Kiro IDE that can be configured for specific tasks (e.g., a Java migration agent, a Spring migration agent), each with tailored instructions and tool access
- **Kiro_Powers**: Packaged bundles of documentation, workflow guides (steering files), and optionally MCP servers that extend Kiro IDE's capabilities for specific domains. Powers can be installed from a catalog, built with the Power Builder, and activated on-demand to provide specialized tools and knowledge
- **Kiro_Power_Builder**: A built-in Kiro Power for creating and testing custom Powers. Used to package migration-specific documentation, steering guides, and MCP server integrations into installable, shareable Power bundles
- **Kiro_Code_Suggestions**: Inline code completions provided by Kiro IDE during development
- **Context_Keys**: Special chat references (#File, #Folder, #Problems, #Terminal, #Git Diff) for providing targeted context to Kiro Chat
- **Workshop_Files**: The collection of markdown files and sample-app directory constituting the workshop materials
- **Q_Reference**: Any mention of Amazon Q Developer, Q Chat, `/transform`, `/review`, Builder ID, IAM Identity Center auth, or Q extension installation in the workshop materials

## Requirements

### Requirement 1: Workshop File Rename and Branding

**User Story:** As a workshop maintainer, I want the main workshop file and all branding updated to reflect Kiro IDE, so that the workshop identity is consistent.

#### Acceptance Criteria

1. GIVEN the file `Amazon-Q-Developer-IDE-Workshop.md` exists, WHEN the transformation runs, THEN it SHALL be renamed to `Kiro-IDE-Workshop.md`
2. GIVEN other markdown files link to `Amazon-Q-Developer-IDE-Workshop.md`, WHEN the rename occurs, THEN all cross-references SHALL be updated to `Kiro-IDE-Workshop.md`
3. GIVEN the README.md contains Amazon Q Developer badges and shield URLs, WHEN the transformation runs, THEN they SHALL be replaced with Kiro IDE equivalents or removed if no equivalent exists
4. GIVEN the README.md title references "Amazon Q Developer IDE Extension", WHEN the transformation runs, THEN it SHALL reference "AWS Kiro IDE"

### Requirement 2: Global Text Replacement

**User Story:** As a workshop participant, I want all Amazon Q Developer terminology replaced with Kiro IDE terminology, so that the materials accurately describe the tool I'm using.

#### Acceptance Criteria

1. GIVEN any markdown file contains "Amazon Q Developer", WHEN the transformation runs, THEN every occurrence SHALL be replaced with "Kiro IDE"
2. GIVEN any markdown file contains standalone "Amazon Q" (not part of a longer already-handled phrase), WHEN the transformation runs, THEN it SHALL be replaced with "Kiro"
3. GIVEN any markdown file contains "Q Developer", WHEN the transformation runs, THEN it SHALL be replaced with "Kiro IDE"
4. GIVEN any markdown file contains "Q Chat", WHEN the transformation runs, THEN it SHALL be replaced with "Kiro Chat"
5. GIVEN any markdown file contains "Q icon", "Q panel", or similar Q UI references, WHEN the transformation runs, THEN they SHALL be replaced with Kiro IDE equivalents

### Requirement 3: IDE Setup and Authentication

**User Story:** As a workshop participant, I want setup instructions that reflect Kiro IDE as a standalone IDE with its own authentication, so that I can correctly prepare my environment.

#### Acceptance Criteria

1. GIVEN PARTICIPANT-SETUP.md lists VS Code or IntelliJ as IDE options, WHEN the transformation runs, THEN Kiro IDE SHALL be the single IDE choice
2. GIVEN any file contains VS Code/IntelliJ extension installation steps for Amazon Q, WHEN the transformation runs, THEN they SHALL be replaced with Kiro IDE download and installation steps
3. GIVEN any file references "AWS Builder ID" or "IAM Identity Center" for Q authentication, WHEN the transformation runs, THEN they SHALL be replaced with Kiro IDE sign-in instructions
4. GIVEN Module 1 describes installing and configuring the Amazon Q extension, WHEN the transformation runs, THEN those steps SHALL become Kiro IDE installation, sign-in, and workspace setup
5. GIVEN the pre-workshop checklist references Amazon Q extension verification, WHEN the transformation runs, THEN it SHALL reference Kiro IDE installation verification

### Requirement 4: Java Migration Workflow with Specs, Skills, and Custom Agents (Module 2)

**User Story:** As a workshop participant, I want the Java 8 → Java 21 migration workflow to use Kiro Specs, a Java Migration Skill, and a custom Java Migration Agent instead of the `/transform` command, so that I learn the Kiro-native approach to structured, AI-assisted code transformation.

#### Acceptance Criteria

1. GIVEN Module 2 instructs participants to run `/transform` for Java version upgrade, WHEN the transformation runs, THEN those instructions SHALL be replaced with: (a) creating a Kiro_Specs workflow for the Java migration, (b) using a Kiro_Custom_Agent configured as a "Java Migration Agent" with Java 8→21 expertise, and (c) using Kiro_Chat to request file-level transformations
2. GIVEN any module references the Command Palette "Amazon Q: Transform" action, WHEN the transformation runs, THEN it SHALL be replaced with Kiro_Specs creation and execution steps
3. GIVEN the Quick Reference Guide lists `/transform` as a command, WHEN the transformation runs, THEN the entry SHALL be replaced with Kiro_Specs workflow description
4. GIVEN Module 2 describes transformation progress tracking via Q Developer, WHEN the transformation runs, THEN it SHALL describe tracking via Kiro_Specs task completion
5. GIVEN Module 2 covers Java API modernization (e.g., Date→LocalDateTime, deprecated API removal), WHEN the transformation runs, THEN it SHALL introduce a "Java 8→21 Migration" Kiro_Skill that participants create to automate repetitive Java modernization patterns

### Requirement 5: Spring Migration Workflow with Skills and Custom Agents (Module 3)

**User Story:** As a workshop participant, I want the Spring 5 → Spring 6 migration workflow to leverage a custom Spring Migration Agent and reusable Kiro Skills, so that I learn how to build specialized AI agents for framework-specific migrations.

#### Acceptance Criteria

1. GIVEN Module 3 covers Spring framework migration, WHEN the transformation runs, THEN it SHALL introduce a Kiro_Custom_Agent configured as a "Spring Migration Agent" with Spring 5→6 and Jakarta namespace expertise
2. GIVEN Module 3 covers Jakarta EE namespace migration (javax.* → jakarta.*), WHEN the transformation runs, THEN it SHALL introduce a "Jakarta Namespace Migration" Kiro_Skill that automates the package rename pattern across files
3. GIVEN Module 3 covers Spring Security modernization (WebSecurityConfigurerAdapter → SecurityFilterChain), WHEN the transformation runs, THEN it SHALL introduce a "Spring Security Upgrade" Kiro_Skill for this specific pattern
4. GIVEN Module 3 uses Q Chat for Spring migration guidance, WHEN the transformation runs, THEN those instructions SHALL use Kiro_Chat with the Spring Migration Agent and relevant Context_Keys (#File for individual files, #Folder for package-wide changes)

### Requirement 6: Testing and Validation with Skills and Hooks (Module 4)

**User Story:** As a workshop participant, I want the testing and code review workflow to use Kiro Hooks, a JUnit Migration Skill, and Kiro Chat instead of the `/review` command, so that I learn automated review and test migration with Kiro.

#### Acceptance Criteria

1. GIVEN Module 4 instructs participants to run `/review` for security validation, WHEN the transformation runs, THEN those instructions SHALL be replaced with configuring Kiro_Hooks for automated review on file save and using Kiro_Chat for on-demand review
2. GIVEN Module 4 covers JUnit 4 → JUnit 5 migration, WHEN the transformation runs, THEN it SHALL introduce a "JUnit 4→5 Migration" Kiro_Skill that automates test annotation conversion, assertion updates, and lifecycle method changes
3. GIVEN any module references the Command Palette "Amazon Q: Review Code" action, WHEN the transformation runs, THEN it SHALL be replaced with Kiro_Hooks setup steps
4. GIVEN the Quick Reference Guide lists `/review` as a command, WHEN the transformation runs, THEN the entry SHALL be replaced with Kiro_Hooks description and usage
5. GIVEN any file describes review results from Q Developer, WHEN the transformation runs, THEN it SHALL describe review results from Kiro_Hooks output

### Requirement 7: Kiro Powers for Java Framework Migration

**User Story:** As a workshop participant, I want to learn how to use and build Kiro Powers for Java framework migration, so that I can package migration knowledge into reusable, shareable bundles that extend Kiro IDE's capabilities.

#### Acceptance Criteria

1. GIVEN Module 1 covers environment setup, WHEN the transformation runs, THEN it SHALL include instructions for browsing and installing relevant Powers from the Kiro Powers catalog (e.g., AWS documentation Power) via the Powers management panel
2. GIVEN Module 2 covers Java migration, WHEN the transformation runs, THEN it SHALL introduce using the Kiro_Power_Builder to create a "Java Framework Migration" Power that packages: (a) migration documentation and best practices as POWER.md, (b) steering files for Java 8→21 migration patterns, and (c) optionally an MCP server for migration-specific tooling
3. GIVEN Module 3 covers Spring migration, WHEN the transformation runs, THEN it SHALL demonstrate activating and using the "Java Framework Migration" Power built in Module 2, and extending it with Spring 5→6 and Jakarta namespace migration guidance
4. GIVEN Module 5 covers platform-specific validation, WHEN the transformation runs, THEN it SHALL demonstrate how a Power can bundle platform-specific deployment knowledge (JBoss EAP, WebSphere, Mainframe) into a shareable "Platform Deployment" Power
5. GIVEN a Power is introduced in a module, WHEN the instructions describe it, THEN they SHALL include: (a) the Power's purpose and contents, (b) how to install or build it, (c) how to activate it and use its tools/documentation, and (d) how to share it with team members

### Requirement 8: Kiro Chat and Context Keys

**User Story:** As a workshop participant, I want chat interaction instructions to use Kiro Chat with Context Keys, so that I learn effective patterns for AI-assisted migration.

#### Acceptance Criteria

1. GIVEN any module contains "Ask Q:" prompt patterns, WHEN the transformation runs, THEN they SHALL be replaced with "Ask Kiro:" patterns
2. GIVEN a module instructs participants to paste code into chat manually, WHEN the transformation runs, THEN it SHALL suggest using Context_Keys (#File, #Folder) where appropriate
3. GIVEN troubleshooting sections reference asking Q for help, WHEN the transformation runs, THEN they SHALL reference Kiro Chat with #Problems context key for compilation errors
4. GIVEN review sections reference asking Q to review changes, WHEN the transformation runs, THEN they SHALL reference Kiro Chat with #Git Diff context key

### Requirement 9: Kiro Steering Files

**User Story:** As a workshop participant, I want the workshop to introduce Kiro Steering Files for project-level migration guidance, so that I learn how to configure Kiro for my project context.

#### Acceptance Criteria

1. GIVEN Module 1 covers project setup, WHEN the transformation runs, THEN it SHALL include instructions for creating `.kiro/steering/` files with migration-specific context (Java 8→21, Spring 5→6 goals and constraints)
2. GIVEN the `.amazonq/rules/memory-bank/` directory contains project guidance files, WHEN the transformation runs, THEN their content SHALL be evaluated and migrated to `.kiro/steering/*.md` format where applicable
3. GIVEN a steering file example is added, WHEN participants read it, THEN it SHALL clearly describe the migration scope, target versions, and constraints relevant to the workshop

### Requirement 10: Kiro Skills Best Practices

**User Story:** As a workshop participant, I want a dedicated section on creating and managing Kiro Skills, so that I learn how to build reusable AI capabilities for my own migration projects.

#### Acceptance Criteria

1. GIVEN the Quick Reference Guide exists, WHEN the transformation runs, THEN it SHALL include a "Kiro Skills" section explaining how to create, test, optimize, and trigger skills for migration tasks
2. GIVEN the workshop introduces multiple skills (Java 8→21, Jakarta Namespace, Spring Security, JUnit 4→5), WHEN participants complete the workshop, THEN each skill SHALL have been introduced in the module where it is most relevant and the Quick Reference Guide SHALL list all skills with their purpose
3. GIVEN a skill is introduced in a module, WHEN the instructions describe it, THEN they SHALL include: (a) what the skill automates, (b) how to create it, and (c) when it triggers or how to invoke it

### Requirement 11: Kiro Custom Agents Best Practices

**User Story:** As a workshop participant, I want guidance on creating and using custom sub-agents for each migration phase, so that I learn how to decompose complex migrations into specialized AI agents.

#### Acceptance Criteria

1. GIVEN the Quick Reference Guide exists, WHEN the transformation runs, THEN it SHALL include a "Kiro Custom Agents" section explaining how to create, configure, and use custom agents for migration tasks
2. GIVEN the workshop introduces custom agents (Java Migration Agent, Spring Migration Agent), WHEN participants complete the workshop, THEN each agent SHALL have been introduced in the module where it is most relevant and the Quick Reference Guide SHALL list all agents with their purpose and configuration
3. GIVEN a custom agent is introduced in a module, WHEN the instructions describe it, THEN they SHALL include: (a) the agent's purpose and expertise scope, (b) how to create and configure it, and (c) best practices for prompting and delegating tasks to it
4. GIVEN Module 1 covers environment setup, WHEN the transformation runs, THEN it SHALL include guidance on planning which custom agents to create based on migration scope (e.g., one agent per major framework migration)

### Requirement 12: Kiro Powers Best Practices

**User Story:** As a workshop participant, I want a dedicated section on using and building Kiro Powers, so that I understand how to extend Kiro IDE with packaged domain knowledge and tools for my organization's migration needs.

#### Acceptance Criteria

1. GIVEN the Quick Reference Guide exists, WHEN the transformation runs, THEN it SHALL include a "Kiro Powers" section explaining: (a) what Powers are (documentation + steering + optional MCP servers), (b) how to browse and install Powers from the catalog, (c) how to activate a Power and use its tools, and (d) how to build custom Powers with the Power Builder
2. GIVEN the workshop introduces Powers (Java Framework Migration Power, Platform Deployment Power), WHEN participants complete the workshop, THEN each Power SHALL have been introduced in the module where it is most relevant and the Quick Reference Guide SHALL list all Powers with their purpose
3. GIVEN the Quick Reference Guide covers Power Builder, WHEN participants read it, THEN it SHALL explain the Power structure (POWER.md, steering files, optional MCP servers), how to validate a Power, and how to share it with a team

### Requirement 13: Quick Reference Guide

**User Story:** As a workshop participant, I want the Quick Reference Guide to document all Kiro IDE features including Skills, Custom Agents, and Powers, so that I have a complete reference during the workshop.

#### Acceptance Criteria

1. GIVEN the Quick Reference Guide contains an "Essential Q Developer Commands" table, WHEN the transformation runs, THEN it SHALL be replaced with a "Kiro IDE Features" table covering Specs, Hooks, Steering, Chat, Code Suggestions, Context Keys, Skills, Custom Agents, and Powers
2. GIVEN the guide contains "Using /transform" and "Using /review" subsections, WHEN the transformation runs, THEN they SHALL become "Using Kiro Specs" and "Using Kiro Hooks" subsections
3. GIVEN the guide contains "Q Developer Pro Tips", WHEN the transformation runs, THEN they SHALL become "Kiro IDE Tips" referencing Kiro-specific features including Skills, Custom Agents, and Powers
4. GIVEN the guide contains example queries for Q, WHEN the transformation runs, THEN they SHALL use Kiro Chat syntax with Context Keys

### Requirement 14: Module Feature Summary Tables

**User Story:** As a workshop participant, I want the feature usage tables at the end of each module to reflect all Kiro IDE features used including Powers, so that I can track what I practiced.

#### Acceptance Criteria

1. GIVEN a module contains a "Key Q Developer Commands Used" table, WHEN the transformation runs, THEN it SHALL become "Key Kiro IDE Features Used"
2. GIVEN a command table entry lists `/transform`, WHEN the transformation runs, THEN it SHALL be replaced with "Kiro Specs" with updated description
3. GIVEN a command table entry lists `/review`, WHEN the transformation runs, THEN it SHALL be replaced with "Kiro Hooks" with updated description
4. GIVEN a command table entry lists "Q Chat" or "Inline suggestions", WHEN the transformation runs, THEN they SHALL become "Kiro Chat" and "Kiro Code Suggestions" respectively
5. GIVEN a module introduces a Kiro_Skill, Kiro_Custom_Agent, or Kiro_Power, WHEN the transformation runs, THEN the module's feature table SHALL include entries for each feature introduced in that module

### Requirement 15: Supporting Documents Update

**User Story:** As a workshop maintainer, I want all supporting documents to reference Kiro IDE and its full feature set, so that the entire workshop package is consistent.

#### Acceptance Criteria

1. GIVEN Workshop-Agenda.md references Amazon Q Developer in session descriptions, WHEN the transformation runs, THEN all references SHALL use Kiro IDE terminology
2. GIVEN INSTRUCTOR-QUICK-START.md contains Q Developer setup and demo instructions, WHEN the transformation runs, THEN they SHALL reference Kiro IDE setup and demos including Skills, Custom Agents, and Powers demonstrations
3. GIVEN TRAINING-KICKSTART.md contains Q Developer verification steps, WHEN the transformation runs, THEN they SHALL reference Kiro IDE verification
4. GIVEN Developer-Test-Walkthrough.md and ACTUAL-TEST-RESULTS.md reference Q Developer features, WHEN the transformation runs, THEN they SHALL use Kiro IDE equivalents
5. GIVEN sample-app/README.md references Amazon Q features, WHEN the transformation runs, THEN they SHALL reference Kiro IDE features (Specs, Chat, Hooks, Skills, Custom Agents, Powers)

### Requirement 16: Content Preservation

**User Story:** As a workshop maintainer, I want all Java migration content, Spring migration content, platform deployment content, and sample application code to remain unchanged, so that the technical guidance stays accurate.

#### Acceptance Criteria

1. GIVEN the sample-app/src directory contains Java source files, WHEN the transformation runs, THEN all Java source files SHALL remain unchanged
2. GIVEN the sample-app/pom.xml defines build configuration, WHEN the transformation runs, THEN pom.xml SHALL remain unchanged
3. GIVEN modules contain Java code examples, Maven configurations, and Spring configurations, WHEN the transformation runs, THEN all code examples SHALL remain unchanged
4. GIVEN modules contain platform deployment instructions (JBoss EAP, WebSphere, Mainframe), WHEN the transformation runs, THEN all platform content SHALL remain unchanged
5. GIVEN the workshop has a 5-module structure with 8-hour core + 90-minute optional session, WHEN the transformation runs, THEN the schedule structure SHALL remain unchanged

### Requirement 17: Link and Reference Integrity

**User Story:** As a workshop participant, I want all internal links to remain valid and external Q Developer links to be updated, so that I can navigate the materials without issues.

#### Acceptance Criteria

1. GIVEN a markdown file links to `Amazon-Q-Developer-IDE-Workshop.md`, WHEN the transformation runs, THEN the link SHALL point to `Kiro-IDE-Workshop.md`
2. GIVEN internal links point to module files, setup files, or reference files that are not renamed, WHEN the transformation runs, THEN those links SHALL remain unchanged
3. GIVEN an external link points to Amazon Q Developer documentation, WHEN the transformation runs, THEN it SHALL be replaced with the corresponding Kiro IDE documentation URL or a placeholder `[Kiro IDE Documentation URL]` if unknown
4. GIVEN post-workshop resource links reference Amazon Q documentation, WHEN the transformation runs, THEN they SHALL reference Kiro IDE documentation

# Hook Template Reference

Companion documentation for `hook-template.json`. Use this as a guide when creating new Kiro hooks.

## Available Trigger Types

| Type | Description |
|------|-------------|
| `fileSaved` | Triggers when a file matching the pattern is saved |
| `promptSubmit` | Triggers before a user prompt is processed |
| `agentStop` | Triggers after the agent completes a task |
| `preTaskExecution` | Triggers before a spec task starts executing |
| `preToolUse` | Triggers before a tool is invoked (use `toolTypes` to filter) |
| `userTriggered` | Triggers only when manually invoked by the user |

## Available Action Types

| Type | Description |
|------|-------------|
| `askAgent` | Sends the prompt to the agent for execution |

## Pattern Examples

- `src/**/*.java` - all Java files under src/
- `**/*.md` - all Markdown files
- `sample-app/src/main/**/*.java` - specific directory

## Tips

- Set `enabled` to `false` while testing
- Keep prompts focused on a single concern
- Reference steering files for large context instead of inlining
- Use specific file patterns to avoid unnecessary triggers

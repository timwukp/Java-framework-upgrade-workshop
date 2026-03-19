---
inclusion: manual
---

# MCP_DOCKER Server - Complete Tool Reference

This document lists all tools available under the MCP_DOCKER server. Use this to determine if a user's prompt requires MCP tools.

## Tool Categories & Tools

### AWS CLI & General
- `call_aws` - Execute AWS CLI commands
- `suggest_aws_commands` - Suggest AWS CLI commands from natural language
- `prompt_understanding` - Understand user queries for AWS advice

### AWS Cost & Billing
- `cost_explorer` - Cost and usage data via Cost Explorer API
- `cost_optimization` - Cost Optimization Hub recommendations
- `cost_comparison` - Month-to-month cost comparisons
- `cost_anomaly` - Cost anomaly detection
- `aws_pricing` - AWS pricing analysis
- `get_pricing` - Detailed pricing from Price List API
- `get_pricing_service_codes` - Available service codes
- `get_pricing_service_attributes` - Filterable pricing attributes
- `get_pricing_attribute_values` - Valid attribute values
- `get_price_list_urls` - Bulk pricing data file URLs
- `generate_cost_report` - Generate cost analysis reports
- `compute_optimizer` - Compute Optimizer recommendations
- `budgets` - AWS budget information
- `free_tier_usage` - Free Tier usage info
- `sp_performance` - Savings Plans coverage/utilization
- `ri_performance` - Reserved Instance coverage/utilization
- `storage_lens` - S3 Storage Lens metrics via Athena SQL
- `bcm_pricing_calc` - BCM Pricing Calculator workload estimates
- `rec_details` - Detailed cost optimization recommendations

### AWS Billing Conductor
- `list_billing_groups` - List billing groups
- `list_billing_group_cost_reports` - Billing group cost reports
- `get_billing_group_cost_report` - Detailed billing group cost report
- `list_account_associations` - Linked account associations
- `list_pricing_plans` - Pricing plans
- `list_pricing_rules` - Pricing rules
- `list_pricing_plans_for_rule` - Plans for a specific rule
- `list_pricing_rules_for_plan` - Rules for a specific plan
- `list_custom_line_items` - Custom line items
- `list_custom_line_item_versions` - Custom line item versions
- `list_resources_associated_to_custom_line_item` - Resources for custom line items

### AWS CDK
- `CDKGeneralGuidance` - CDK best practices
- `CheckCDKNagSuppressions` - CDK Nag suppression checks
- `ExplainCDKNagRule` - CDK Nag rule explanations
- `analyze_cdk_project` - Analyze CDK project services
- `GetAwsSolutionsConstructPattern` - Solutions Constructs patterns
- `SearchGenAICDKConstructs` - GenAI CDK constructs

### AWS Terraform
- `ExecuteTerraformCommand` - Run Terraform commands
- `ExecuteTerragruntCommand` - Run Terragrunt commands
- `RunCheckovScan` - Checkov security scans
- `SearchAwsProviderDocs` - AWS provider docs
- `SearchAwsccProviderDocs` - AWSCC provider docs
- `SearchSpecificAwsIaModules` - AWS-IA modules
- `SearchUserProvidedModule` - User-provided modules
- `analyze_terraform_project` - Analyze Terraform project

### AWS Glue
- `manage_aws_glue_jobs` - ETL jobs and job runs
- `manage_aws_glue_crawlers` - Crawlers
- `manage_aws_glue_databases` - Data Catalog databases
- `manage_aws_glue_tables` - Data Catalog tables
- `manage_aws_glue_catalog` - Data Catalog management
- `manage_aws_glue_connections` - Data Catalog connections
- `manage_aws_glue_partitions` - Table partitions
- `manage_aws_glue_sessions` - Interactive sessions
- `manage_aws_glue_statements` - Session statements
- `manage_aws_glue_workflows` - Workflows
- `manage_aws_glue_triggers` - Triggers
- `manage_aws_glue_classifiers` - Classifiers
- `manage_aws_glue_encryption` - Encryption settings
- `manage_aws_glue_resource_policies` - Resource policies
- `manage_aws_glue_security_configurations` - Security configs
- `manage_aws_glue_usage_profiles` - Usage profiles
- `manage_aws_glue_crawler_management` - Crawler schedules/metrics

### AWS Athena
- `manage_aws_athena_query_executions` - Query execution
- `manage_aws_athena_named_queries` - Saved queries
- `manage_aws_athena_workgroups` - Workgroups
- `manage_aws_athena_data_catalogs` - Data catalogs
- `manage_aws_athena_databases_and_tables` - Databases and tables

### AWS EMR
- `manage_aws_emr_clusters` - EMR cluster lifecycle
- `manage_aws_emr_ec2_instances` - EMR EC2 instances
- `manage_aws_emr_ec2_steps` - EMR processing steps

### AWS IAM (Data Processing)
- `get_roles_for_service` - Roles for a service
- `get_policies_for_role` - Policies on a role
- `create_data_processing_role` - Create processing roles
- `add_inline_policy` - Add inline policies

### AWS S3 (Data Processing)
- `list_s3_buckets` - List S3 buckets
- `upload_to_s3` - Upload code to S3
- `analyze_s3_usage_for_data_processing` - S3 usage analysis

### AWS Lambda
- `LambdaLayerDocumentationProvider` - Lambda layer docs

### AWS Bedrock & AgentCore
- `get_bedrock_patterns` - Bedrock architecture patterns
- `GenerateBedrockAgentSchema` - Bedrock Agent schemas
- `search_agentcore_docs` - AgentCore documentation search
- `fetch_agentcore_doc` - Fetch AgentCore doc content
- `manage_agentcore_runtime` - AgentCore Runtime deployment
- `manage_agentcore_gateway` - AgentCore Gateway management
- `manage_agentcore_memory` - AgentCore Memory management

### AWS Documentation
- `search_documentation` - Search AWS docs
- `read_documentation` - Read AWS doc pages
- `read_sections` - Read specific doc sections
- `recommend` - Content recommendations

### GitHub
- `get_me` - Authenticated user info
- `search_repositories`, `search_code`, `search_issues`, `search_pull_requests`, `search_users`
- `create_repository`, `fork_repository`
- `create_branch`, `list_branches`, `list_commits`, `get_commit`
- `list_tags`, `get_tag`, `list_releases`, `get_latest_release`, `get_release_by_tag`
- `get_file_contents`, `create_or_update_file`, `delete_file`, `push_files`
- `list_issues`, `issue_read`, `issue_write`, `list_issue_types`, `sub_issue_write`
- `list_pull_requests`, `pull_request_read`, `create_pull_request`, `update_pull_request`
- `merge_pull_request`, `update_pull_request_branch`
- `pull_request_review_write`, `add_comment_to_pending_review`, `add_reply_to_pull_request_comment`
- `add_issue_comment`, `request_copilot_review`, `assign_copilot_to_issue`
- `get_label`, `get_teams`, `get_team_members`

### Browser Automation
- `start_browser_session`, `stop_browser_session`, `list_browser_sessions`, `get_browser_session`
- `browser_navigate`, `browser_click`, `browser_type`, `browser_snapshot`
- `browser_take_screenshot`, `browser_evaluate`, `browser_console_messages`
- `browser_network_requests`, `browser_tabs`, `browser_press_key`
- `browser_select_option`, `browser_hover`, `browser_drag`, `browser_fill_form`
- `browser_handle_dialog`, `browser_wait_for`, `browser_navigate_back`
- `browser_navigate_forward`, `browser_mouse_wheel`, `browser_resize`
- `browser_close`, `browser_upload_file`, `browser_file_upload`, `browser_run_code`

### Perplexity AI
- `perplexity_ask` - Conversational AI
- `perplexity_reason` - Reasoning tasks
- `perplexity_research` - Deep research

### Session & MCP Management
- `session_sql` - Query session database
- `mcp_find` - Find MCP servers in catalog
- `mcp_add` - Add MCP server
- `mcp_remove` - Remove MCP server
- `mcp_exec` - Execute MCP tool
- `mcp_config_set` - Configure MCP server
- `code_mode` - Create combined JS tools

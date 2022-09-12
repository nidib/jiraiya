# Jiraiya - Jira with super metric powers

## Usage guide
This application exposes the following services:

| Service | Description |
|---|---|
| backend/core | The main backend api, where all the data from jira is fetched and processed |
| frontend/dashboard | A dashboard that consumes the api above, and provides options to fetch data from jira |


## Development guide
### backend/core
- Currently the only way to develop this application is by rebuilding its image every time there is a change on the source code. This can be done by running at the project root:
  - `$ ./scripts/start.sh up`
### frontend/dashboard
- Not implemented


## Environment variables
The following environment variables can be overwritten by creating a `.env` file at the root of the project

| Environment variable | Description | Default value |
|---|---|---|
| JIRA_URL | The domain that points to your jira application | |
| JIRA_USERNAME | The jira username used to authenticate | |
| JIRA_PASSWORD | The jira password used to authenticate | |
| DATABASE_USER | Database username | admin |
| DATABASE_PASSWORD | Database password | admin |
| DATABASE_PORT | Port to expose the Postgres database | 5432 |
| BACKEND_CORE_PORT | Port to expose the backend/core app | 8080 |
| FRONTEND_DASHBOARD_PORT | Port to expose the frontend/dashboard app | 4173 |
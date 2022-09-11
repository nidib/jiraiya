CREATE SCHEMA IF NOT EXISTS "jiraiya";

CREATE TABLE IF NOT EXISTS "jiraiya"."board" (
	"id" INT NOT NULL,
	"name" VARCHAR(45) NOT NULL,
	"type" VARCHAR(45) NOT NULL,

	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."epic" (
	"id" INT NOT NULL,
	"key" VARCHAR(45) NOT NULL,
	"name" VARCHAR(350) NOT NULL,
	"summary" VARCHAR(350),
	"done" BOOLEAN NOT NULL,

	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."sprint" (
	"id" INT NOT NULL,
	"name" VARCHAR(90) NOT NULL,
	"state" VARCHAR(90) NOT NULL,
	"start_date" TIMESTAMP,
	"end_date" TIMESTAMP,
	"complete_date" TIMESTAMP,
	"activated_date" TIMESTAMP,

	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."user" (
	"key" VARCHAR(45) NOT NULL,
	"name" VARCHAR(45) NOT NULL,
	"display_name" VARCHAR(90),
	"email_address" VARCHAR(45),

	PRIMARY KEY ("key")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."project" (
	"id" INT NOT NULL,
	"key" VARCHAR(45) NOT NULL,
	"name" VARCHAR(45) NOT NULL,
	"lead_key" VARCHAR(45),

	PRIMARY KEY ("id"),
	FOREIGN KEY ("lead_key") REFERENCES "jiraiya"."user"("key")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."issue_type" (
	"id" INT NOT NULL,
	"description" VARCHAR(200),
	"name" VARCHAR(45),

	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."priority" (
	"id" INT NOT NULL,
	"description" VARCHAR(200) NOT NULL,
	"name" VARCHAR(45),

	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."status_category" (
	"id" INT NOT NULL,
	"key" VARCHAR(45) NOT NULL,
	"name" VARCHAR(45) NOT NULL,

	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."status" (
	"id" INT NOT NULL,
	"name" VARCHAR(45) NOT NULL,
	"status_category_id" INT NOT NULL,

	PRIMARY KEY ("id"),
	FOREIGN KEY ("status_category_id") REFERENCES "jiraiya"."status_category"("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."version" (
	"id" INT NOT NULL,
	"name" VARCHAR(45) NOT NULL,
	"description" VARCHAR(350),
	"archived" BOOLEAN NOT NULL,
	"released" BOOLEAN NOT NULL,
	"project_id" INT NOT NULL,

	PRIMARY KEY ("id"),
	FOREIGN KEY ("project_id") REFERENCES "jiraiya"."project"("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."issue" (
	"id" INT NOT NULL,
	"key" VARCHAR(45) NOT NULL,
	"summary" VARCHAR(350),
	"user_key" VARCHAR(45),
	"time_in_progress" INTERVAL,
	"time_in_code_review" INTERVAL,
	"time_in_ready_to_test" INTERVAL,
	"time_in_test" INTERVAL,
	"issue_type_id" INT,
	"priority_id" INT,
	"sprint_id" INT,
	"status_id" INT,
	"status_category_id" INT,

	PRIMARY KEY ("id"),
	FOREIGN KEY ("user_key") REFERENCES "jiraiya"."user"("key"),
	FOREIGN KEY ("issue_type_id") REFERENCES "jiraiya"."issue_type"("id"),
	FOREIGN KEY ("priority_id") REFERENCES "jiraiya"."priority"("id"),
	FOREIGN KEY ("sprint_id") REFERENCES "jiraiya"."sprint"("id"),
	FOREIGN KEY ("status_id") REFERENCES "jiraiya"."status"("id"),
	FOREIGN KEY ("status_category_id") REFERENCES "jiraiya"."status_category"("id")
);

CREATE TABLE IF NOT EXISTS "jiraiya"."issue_status_change" (
	"id" INT NOT NULL,
	"field" VARCHAR(90),
	"from" VARCHAR(90),
	"to" VARCHAR(90),
	"happened_at" TIMESTAMP NOT NULL,
	"time_in_status" INT,
	"issue_id" INT NOT NULL,

	PRIMARY KEY ("id"),
	FOREIGN KEY ("issue_id") REFERENCES "jiraiya"."issue"("id")
);

CREATE OR REPLACE VIEW "jiraiya"."sprint_issues_stats" AS
	SELECT
		i.summary AS "task",
		it.name AS "type",
		p.name AS "priority",
		s.name AS "status",
		u.display_name AS "assignee"
	FROM
		"jiraiya"."issue" AS i
	LEFT JOIN "jiraiya"."status" AS s ON i.status_id = s.id
	LEFT JOIN "jiraiya"."user" AS u ON i.user_key = u.key
	LEFT JOIN "jiraiya"."issue_type" AS it ON i.issue_type_id = it.id
	LEFT JOIN "jiraiya"."priority" AS p ON i.priority_id = p.id;
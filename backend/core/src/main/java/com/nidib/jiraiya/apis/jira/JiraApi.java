package com.nidib.jiraiya.apis.jira;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class JiraApi {
	private static final URI baseURL = URI.create(System.getenv("JIRA_URL"));
	private static final String username = System.getenv("JIRA_USERNAME");
	private static final String password = System.getenv("JIRA_PASSWORD");

	public String GET(String path) {
		String url = baseURL.resolve(path).toString();

		HttpResponse<String> response = Unirest.get(url)
			.basicAuth(username, password)
			.header("Accept", "application/json")
			.socketTimeout(15000)
			.asString();

		if (response.getStatus() != 200) {
			throw new RuntimeException("Endpoint " + path + " returned " + response.getStatus());
		}

		return response.getBody();
	}
}
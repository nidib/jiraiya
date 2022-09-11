package com.nidib.jiraiya.apis.jira;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.nidib.jiraiya.apis.jira.dtos.JiraPaginatedValuesDTO;
import org.springframework.web.util.UriComponentsBuilder;

public class JiraEntityConverter<T> {
	private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	private final TypeFactory type = TypeFactory.defaultInstance();
	private final JiraApi jiraApi;
	private final Class<T> entity;

	public JiraEntityConverter(JiraApi jiraApi, Class<T> entity) {
		this.jiraApi = jiraApi;
		this.entity = entity;
	}

	public T getOne(String endpoint) {
		String response = jiraApi.GET(endpoint);
		T item = null;

		try {
			item = objectMapper.readValue(response, entity);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return item;
	}

	public List<T> getMany(String endpoint) {
		String response = jiraApi.GET(endpoint);
		List<T> items = null;
		String data;
		JsonNode values;

		try {
			values = objectMapper.readTree(response).get("values");

			if (values == null)
				data = response;
			else
				data = values.toString();

			items = objectMapper.readValue(data, type.constructCollectionType(ArrayList.class, entity));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return items;
	}

	public List<T> getManyPaginated(String endpoint) {
		JiraPaginatedValuesDTO<T> paginatedValuesDTO;
		List<T> allValues = new ArrayList<>();
		int startAt = 0;

		try {
			do {
				String url = UriComponentsBuilder.fromUri(new URI(endpoint)).queryParam("startAt", startAt).build().toString();

				paginatedValuesDTO = objectMapper.readValue(
					jiraApi.GET(url),
					type.constructParametricType(JiraPaginatedValuesDTO.class, entity)
				);
				allValues.addAll(paginatedValuesDTO.getValues());
				startAt += paginatedValuesDTO.getMaxResults();
			} while (paginatedValuesDTO.getValues().size() >= paginatedValuesDTO.getMaxResults());
		} catch (JsonProcessingException | URISyntaxException e) {
			e.printStackTrace();
		}

		return allValues;
	}
}
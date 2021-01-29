package org.o7planning.fontend.service;

import java.util.List;

import org.o7planning.fontend.model.Service1;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Service1Service {
	public static final String REST_SERVICE_URI = "https://dothanhhai.herokuapp.com/service/";
	RestTemplate restTemplate = new RestTemplate();

	public List<Service1> getAllService1() throws JsonMappingException, JsonProcessingException {
		String service1s = restTemplate.getForObject(REST_SERVICE_URI, String.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(service1s, new TypeReference<List<Service1>>() {
		});
	}

	public void insertService1(Service1 service1) {
		restTemplate.postForObject(REST_SERVICE_URI, service1, Service1.class);
	}

	public void updateService1(Service1 service1) {
		Long id = service1.getId();
		restTemplate.put(REST_SERVICE_URI + id, service1);
	}

	public void deleteService1(Long id) {
		restTemplate.delete(REST_SERVICE_URI + id);
	}

	public Service1 getService1ById(Long id) {
		Service1 service1 = restTemplate.getForObject(REST_SERVICE_URI + id, Service1.class);
		return service1;
	}
}

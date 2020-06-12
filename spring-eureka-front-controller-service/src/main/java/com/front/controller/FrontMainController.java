package com.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.front.DTO.ColorDTO;
import com.front.aspects.LogMethodParam;
import com.front.modal.Data;
import com.front.services.ColorService;

@RestController
public class FrontMainController {

	
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(path = "/healthStatus", method = RequestMethod.GET)
	public ResponseEntity<Object> isServiceUp() {
		return ResponseEntity.ok("UP");

	}

	@RequestMapping(value = "/concatenate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
	public ResponseEntity<Object> getAccumlatedResult(@RequestBody Data data) throws JsonProcessingException {
		String response1 = restTemplate.exchange("http://hello-service/hello", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}, "").getBody();
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(data);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);

		try {
			String response2 = restTemplate.exchange("http://concatenate-service/concatenate", HttpMethod.POST, entity,String.class).getBody();
			return ResponseEntity.ok(response1 + " "+ response2);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();

		}


	}
	
	@Autowired
	ColorService colorService;
	
	@RequestMapping(path = "/data/{id}", method = RequestMethod.GET)
	@LogMethodParam(startA = true, endA = true)
	public ResponseEntity<Object> getData(@PathVariable int id) throws JsonProcessingException {
		//ColorService colorService = new ColorServiceImpl();
		ColorDTO data = colorService.getColorData(id);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(data);
		return ResponseEntity.ok(json);

	}
	
	@RequestMapping(path = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getDatas() throws JsonProcessingException {
		//ColorService colorService = new ColorServiceImpl();
		List<ColorDTO> list = colorService.getColorDatas();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(list);
		return ResponseEntity.ok(json);

	}

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

}

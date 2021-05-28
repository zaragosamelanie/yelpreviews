package com.yelp.reviews.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yelp.reviews.model.ProcessedReview;
import com.yelp.reviews.model.Response;
import com.yelp.reviews.model.Review;
import com.yelp.reviews.service.Service;

@RestController
@RequestMapping("/reviews")
public class Controller {
	
	@Autowired
	Service service;
	
	final static String TOKEN = "5BFjAEWF6y4k3Ejk-fqJt7MNgljRHfwZ26aQtVUCRby04ah7z-e6RyxUIGm_ljWBxyYlQxsDn48swgHMeUyYJA-MrOblW1yv61j55RtxMMSdIRxS8VuwxhitY9CsYHYx";

	@GetMapping
	public ResponseEntity<List<ProcessedReview>> getReviewsUsingBusinessID(String businessID) {
		String URI = UriComponentsBuilder.newInstance()
			      .scheme("https").host("api.yelp.com/").pathSegment("v3","businesses",businessID, "reviews")
			      .build(). toUriString();
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + TOKEN);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String json = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class).getBody();
        
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
        	Response response = objectMapper.readValue(json, Response.class);
        	Review[] reviews = response.getReviews();
        	List <ProcessedReview> processedReview = service.processedReview(reviews);
        	
        	return ResponseEntity.status(HttpStatus.OK).body(processedReview);
            
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        
        return ResponseEntity.noContent().build();
	}

}

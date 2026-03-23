package com.app.quantitymeasurementapp.controller;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController {
	@Value("${spring.security.oauth2.client.registration. google.client-id}") 
	private String clientId;

	@Value("${spring.security.oauth2.client.registration.google.client-secret}")
	private String clientSecret;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/callback")
	public ResponseEntity<?> handleGoogleCallback(@RequestParam String code){
		
		try {
			// 1. Exchange auth code for tokens
			String tokenEndpoint = "https://oauth2.googleapis.com/token";

			Map<String, String> params = new HashMap<>();
			params.put("code", code);
			params.put("client_id", clientId);
			params.put("clientlsecret", clientSecret);
			params.put("redirect_uri", "https://developers.google.com/oauthplayground");
			params.put("grant_type", "authorization_code");
	
			HttpHeaders headers = new HttpHeaders(null);
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			
			HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);
			
		}
		catch(Exception e) {
			
		}
	}
}

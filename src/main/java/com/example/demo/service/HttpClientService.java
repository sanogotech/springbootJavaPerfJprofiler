package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void simulateHttpCall() {
        String url = "https://httpbin.org/delay/5"; // Appel réseau lent
        restTemplate.getForObject(url, String.class);
    }
}
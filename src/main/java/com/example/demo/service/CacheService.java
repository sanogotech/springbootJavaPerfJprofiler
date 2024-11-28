package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    private final Map<String, String> cache = new HashMap<>();

    public void simulateCacheProblem() {
        for (int i = 0; i < 10000; i++) {
            cache.put("key" + i, "value" + i);
        }
        try {
            Thread.sleep(5000); // Simule un problème lié au cache
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
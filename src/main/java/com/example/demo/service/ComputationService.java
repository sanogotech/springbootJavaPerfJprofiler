package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ComputationService {

    public void simulateHeavyComputation() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Math.sqrt(i); // Calculs intensifs
        }
    }
}
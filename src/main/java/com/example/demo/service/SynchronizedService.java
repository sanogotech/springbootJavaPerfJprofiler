package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SynchronizedService {

    public synchronized void simulateSynchronization() {
        try {
            Thread.sleep(5000); // Simule un traitement lent
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadPoolService {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public void simulateThreadPoolOverload() {
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(3000); // Simule une tâche longue
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}

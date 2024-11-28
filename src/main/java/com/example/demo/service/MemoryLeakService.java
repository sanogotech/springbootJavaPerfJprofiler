package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryLeakService {

    private static final List<Object> cache = new ArrayList<>();

    public void simulateMemoryLeak() {
        while (true) {
            cache.add(new byte[1024 * 1024]); // Ajoute des blocs de 1MB
            if (cache.size() > 100) break; // Evite une boucle infinie
        }
    }
}



package com.example.demo.controller;

import com.example.demo.service.*;
import com.example.demo.service.ComputationService;
import com.example.demo.service.MemoryLeakService;
import com.example.demo.service.SynchronizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private MemoryLeakService memoryLeakService;

    @Autowired
    private SynchronizedService synchronizedService;

    @Autowired
    private ComputationService computationService;

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private ThreadPoolService threadPoolService;

    @GetMapping("/database")
    public String simulateDatabaseIssue() {
        databaseService.simulateNPlusOneProblem();
        return "Database issue simulated!";
    }

    @GetMapping("/memory-leak")
    public String simulateMemoryLeak() {
        memoryLeakService.simulateMemoryLeak();
        return "Memory leak simulated!";
    }

    @GetMapping("/synchronized")
    public String simulateSynchronizedIssue() {
        synchronizedService.simulateSynchronization();
        return "Synchronization issue simulated!";
    }

    @GetMapping("/computation")
    public String simulateComputationIssue() {
        computationService.simulateHeavyComputation();
        return "Computation issue simulated!";
    }

    @GetMapping("/http")
    public String simulateHttpIssue() {
        httpClientService.simulateHttpCall();
        return "HTTP issue simulated!";
    }

    @GetMapping("/cache")
    public String simulateCacheIssue() {
        cacheService.simulateCacheProblem();
        return "Cache issue simulated!";
    }

    @GetMapping("/thread-pool")
    public String simulateThreadPoolIssue() {
        threadPoolService.simulateThreadPoolOverload();
        return "Thread pool issue simulated!";
    }
}

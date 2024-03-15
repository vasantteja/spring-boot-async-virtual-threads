package com.example.demo.controller;

import com.example.demo.service.AsyncTaskCollector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AsyncController {

    private final AsyncTaskCollector asyncTaskCollector;

    //write an endpoint here to execute the async task
    public AsyncController(AsyncTaskCollector asyncTaskCollector) {
        this.asyncTaskCollector = asyncTaskCollector;
    }

    @GetMapping("/executeAsyncTask")
    public ResponseEntity<?> executeAsyncTask() {
        try {
            log.info("Start processing the request on thread {}", Thread.currentThread().getName());
            asyncTaskCollector.executeAsyncTask();
            log.info("End processing the request on thread {}", Thread.currentThread().getName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}

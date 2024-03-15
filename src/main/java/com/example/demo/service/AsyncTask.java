package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncTask {

    @Async
    public CompletableFuture<String> asyncMethodWithReturnType(int i) throws InterruptedException {
        log.info("Execute method asynchronously on thread {} for index {}", Thread.currentThread().getName(), i);
        try {
            if (i % 2 == 0) {
                long waitTime = i * 10L;
                Thread.sleep(waitTime);
                log.info("Waited for {} seconds", waitTime);
            } else {
                Thread.sleep(i);
            }
            log.info("Completed task for index {} on thread {}", i, Thread.currentThread().getName());
            return CompletableFuture.completedFuture(Thread.currentThread().getName());
        } catch (Exception e) {
            throw e;
        }
    }
}

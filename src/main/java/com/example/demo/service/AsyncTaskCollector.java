package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncTaskCollector {

    private final AsyncTask asyncTask;

    public AsyncTaskCollector(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    public void executeAsyncTask() throws InterruptedException {
        List<CompletableFuture> futureList=new ArrayList<>();
        try {
            for (int i = 0; i < 100; i++) {
                futureList.add(asyncTask.asyncMethodWithReturnType(i));
            }
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
            log.info("All tasks are completed");
        } catch (Exception e) {
            log.error("Exception occurred while processing the request", e);
            throw e;
        }
    }
}

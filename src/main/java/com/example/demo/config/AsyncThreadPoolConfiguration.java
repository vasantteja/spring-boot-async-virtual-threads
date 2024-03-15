package com.example.demo.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.VirtualThreadExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@Slf4j
public class AsyncThreadPoolConfiguration {

    @Bean("virtualThreadExecutor")
    public Executor getAsyncExecutor() {
        VirtualThreadExecutor executor = new VirtualThreadExecutor("virtualThreadExecutor");
        return executor;
    }
}

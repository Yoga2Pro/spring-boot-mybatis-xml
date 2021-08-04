package com.neo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync

public class ThreadPoolConfig {

    @Bean(name= "UserThreadPoolExecutor")
    public Executor getUserThreadPoolExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("UserThreadPoolExecutor-");
        executor.initialize();
        return executor;
    }

}

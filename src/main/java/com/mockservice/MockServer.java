package com.mockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class MockServer {
    public static void main(String[] args) {
        new MockServer().start(args);
    }

    public void start(String[] args) {
        SpringApplication.run(MockServer.class, args);
    }
}

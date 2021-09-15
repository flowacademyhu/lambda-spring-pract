package hu.flowacademy.demo.config;

import hu.flowacademy.demo.service.SimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class Config {
    @Bean
    public SimpleService simpleService() {
//        if (System.getenv("DO_STUFF").equals("true")) {
//            throw new RuntimeException();
//        }
        return new SimpleService("my name is");
    }
}

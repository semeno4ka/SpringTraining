package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class Spring17RestConsumeApIsApplication {

    public static void main(String[] args) {

        SpringApplication.run(Spring17RestConsumeApIsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
//    @Bean
//    public ModelMapper mapper() {
//        return new ModelMapper();
//    }
}

package com.qianyu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BackstageSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackstageSpringbootApplication.class, args);
    }


}

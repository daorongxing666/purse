package com.example.purse_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.purse_demo.mapper")
public class PurseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurseDemoApplication.class, args);
    }

}

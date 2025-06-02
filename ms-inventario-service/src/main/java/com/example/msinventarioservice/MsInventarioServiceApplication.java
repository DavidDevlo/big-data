package com.example.msinventarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsInventarioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsInventarioServiceApplication.class, args);
    }

}

package com.example.msventa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
public class MsVentaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsVentaApplication.class, args);
    }

}

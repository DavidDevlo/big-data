package com.example.msproductoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients falta en los otros microsevicios
public class MsProductoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductoServiceApplication.class, args);
    }

}

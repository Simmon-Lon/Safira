package com.simmon.shopstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.simmon.shopstore.repository")
public class ShopstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopstoreApplication.class, args);
    }
}

package com.pharmacy.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pharmacy")
public class PharmacyWarehouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(PharmacyWarehouseApplication.class, args);
    }
}


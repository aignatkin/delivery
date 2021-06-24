package ru.aignatkin.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DeliveryApplication {
    private static Logger log = Logger.getLogger(DeliveryApplication.class.getName());

    public static void main (String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
        log.info("Application started");
    }
}

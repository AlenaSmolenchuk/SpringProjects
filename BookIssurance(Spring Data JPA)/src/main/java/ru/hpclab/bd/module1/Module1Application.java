package ru.hpclab.bd.module1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ru.hpclab.bd.module1.entity")
public class Module1Application {

    public static void main(final String[] args) {
        SpringApplication.run(Module1Application.class, args);
    }
}

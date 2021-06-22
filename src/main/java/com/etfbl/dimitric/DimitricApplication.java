package com.etfbl.dimitric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.etfbl.dimitric.config")
public class DimitricApplication {

    public static void main(String[] args) {
        SpringApplication.run(DimitricApplication.class, args);
    }

}

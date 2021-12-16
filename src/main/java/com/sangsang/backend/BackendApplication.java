package com.sangsang.backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
    private static final Logger LOGGER = LogManager.getLogger(BackendApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);
        LOGGER.info("START BACKEND WEBSERVER");
    }

}

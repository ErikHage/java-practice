package com.tfr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRunnableApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... strings) throws Exception {
		logger.debug("Starting Application");

        try {
            //do stuff here
        } catch(Exception ex) {
            logger.error("Exception when executing application", ex);
        }

        logger.debug("Execution Completed");

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunnableApplication.class, args);
	}
}

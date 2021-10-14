package com.payMyBuddy.transfert;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransfertApplication {
	private static final Logger logger = LogManager.getLogger(TransfertApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransfertApplication.class, args);
		logger.info("app initialized");
	}
}

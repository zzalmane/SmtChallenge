package com.smaato.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmaatoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmaatoDemoApplication.class, args);
	}

}

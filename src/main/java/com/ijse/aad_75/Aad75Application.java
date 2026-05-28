package com.ijse.aad_75;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration - mark as a config class
//@ComponentScan - fina aa our controllers and services automatically
//@EnableAutoConfiguration - auto configure the application
@SpringBootApplication
public class Aad75Application {

	public static void main(String[] args) {
		SpringApplication.run(Aad75Application.class, args);
	}

}

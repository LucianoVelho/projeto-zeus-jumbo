package com.zessh.jumpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class JumpoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumpoApplication.class, args);
	}

}

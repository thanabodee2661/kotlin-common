package com.thanabodee2661.springcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.thanabodee2661")
@EnableWebMvc
public class SpringCommonApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCommonApplication.class, args);
	}
}
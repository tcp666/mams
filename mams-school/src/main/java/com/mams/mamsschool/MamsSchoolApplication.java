package com.mams.mamsschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {
		"com.mams",
		"com.mams.mamsschool.controller",
		"com.mams.mamsschool.entity",
		"com.mams.mamsschool.mapper",
		"com.mams.mamsschool.service"})
public class MamsSchoolApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MamsSchoolApplication.class, args);
		
	}
}

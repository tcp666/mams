package com.mams.mamsschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
		"com.mams",
		"com.mams.mamsschool.controller",
		"com.mams.mamsschool.entity",
		"com.mams.mamsschool.mapper",
		"com.mams.mamsschool.service"})
public class MamsSchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(MamsSchoolApplication.class, args);
		
	}
}

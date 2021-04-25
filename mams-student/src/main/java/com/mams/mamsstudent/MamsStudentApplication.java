package com.mams.mamsstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"" +
		"com.mams",
		"com.mams.mamscommon.utils",
		"com.mams.mamsstudent.controller",
		"com.mams.mamsstudent.entity",
		"com.mams.mamsstudent.mapper",
		"com.mams.mamsstudent.service"})
public class MamsStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamsStudentApplication.class, args);

	}
}

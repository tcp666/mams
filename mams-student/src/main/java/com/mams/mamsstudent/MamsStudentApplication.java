package com.mams.mamsstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mams.mamsstudent","com.mams.mamsstudent.service"})
public class MamsStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamsStudentApplication.class, args);
	}

}

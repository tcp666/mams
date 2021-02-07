package com.mams.mamscommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mams.mamscommon","com.mams.mamscommon.service"})
public class MamsCommonApplication {
	public static void main(String[] args) {
		SpringApplication.run(MamsCommonApplication.class, args);
	}
	
}

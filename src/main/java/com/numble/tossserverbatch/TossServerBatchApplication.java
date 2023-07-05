package com.numble.tossserverbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TossServerBatchApplication {
	public static void main(String[] args) {
		System.out.println("run start toss-server-batch");
		SpringApplication.run(TossServerBatchApplication.class, args);

	}

}

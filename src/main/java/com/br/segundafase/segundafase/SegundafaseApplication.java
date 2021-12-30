package com.br.segundafase.segundafase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SegundafaseApplication {

	public static void main(String[] args){
		SpringApplication.run(SegundafaseApplication.class, args);
	}

}
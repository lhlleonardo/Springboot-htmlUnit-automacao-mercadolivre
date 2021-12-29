package com.br.segundafase.segundafase;

import com.br.segundafase.segundafase.service.DemandaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SegundafaseApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SegundafaseApplication.class, args);

		DemandaService demandaService = new DemandaService();

		System.out.println(demandaService.retornarItemProcurado("Kindle"));
	}
}
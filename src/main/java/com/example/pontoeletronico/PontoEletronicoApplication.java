package com.example.pontoeletronico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utils.SenhaUtils;

@SpringBootApplication
public class PontoEletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoEletronicoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
	return args -> {
		String senhaEncoded = SenhaUtils.gerarBcrypt("123456");
		System.out.println("Senha encoded :" + senhaEncoded);

		senhaEncoded = SenhaUtils.gerarBcrypt("123456");
		System.out.println("Senha encoded novamente: " + senhaEncoded);

		System.out.println("Senha válida: " + SenhaUtils.senhavalida("123456", senhaEncoded));
		};
	}

}

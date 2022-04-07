package com.example.pontoeletronico;
import java.util.List;

import com.example.pontoeletronico.entities.Empresa;
import com.example.pontoeletronico.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PontoEletronicoApplication {

	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PontoEletronicoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Solution IT");
			empresa.setCnpj("74645215000104");

			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);

			Empresa empresaDb = empresaRepository.findById(1L).get();
			System.out.println("Empresa por ID: " + empresaDb);

			empresaDb.setRazaoSocial("Solution IT Web");
			this.empresaRepository.save(empresaDb);

			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);

			this.empresaRepository.deleteById(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());

		};
	}
}

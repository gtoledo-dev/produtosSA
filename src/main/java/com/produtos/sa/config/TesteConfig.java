package com.produtos.sa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.produtos.sa.entities.Cliente;
import com.produtos.sa.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cl1 = new Cliente(null, "Maria", "55533344422", "25/08/1987");
		Cliente cl2 = new Cliente(null, "Rebeca", "77766655544", "25/09/1989");
		
		clienteRepository.saveAll(Arrays.asList(cl1, cl2));
		
	}

}

package com.produtos.sa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.produtos.sa.entities.Categoria;
import com.produtos.sa.entities.Cliente;
import com.produtos.sa.entities.Pedido;
import com.produtos.sa.entities.enums.PedidoStatus;
import com.produtos.sa.repositories.CategoriaRepository;
import com.produtos.sa.repositories.ClienteRepository;
import com.produtos.sa.repositories.PedidoRepository;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Cliente cl1 = new Cliente(null, "Maria", "55533344422", "25/08/1987");
		Cliente cl2 = new Cliente(null, "Rebeca", "77766655544", "25/09/1989");
		
		Pedido p1 = new Pedido(null, Instant.parse("2021-06-20T19:53:07Z"), PedidoStatus.EFETUADO_PAGAMENTO, cl1);
		Pedido p2 = new Pedido(null, Instant.parse("2021-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO,cl2);
		Pedido p3 = new Pedido(null, Instant.parse("2021-08-20T17:48:23Z"), PedidoStatus.ENTREGUE,cl1);
		
		clienteRepository.saveAll(Arrays.asList(cl1, cl2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
	}

}

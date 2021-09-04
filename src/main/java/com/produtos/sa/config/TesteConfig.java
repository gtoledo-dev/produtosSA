package com.produtos.sa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.produtos.sa.entities.Categoria;
import com.produtos.sa.entities.Cliente;
import com.produtos.sa.entities.Pagamento;
import com.produtos.sa.entities.Pedido;
import com.produtos.sa.entities.PedidoItem;
import com.produtos.sa.entities.Produto;
import com.produtos.sa.entities.enums.PedidoStatus;
import com.produtos.sa.repositories.CategoriaRepository;
import com.produtos.sa.repositories.ClienteRepository;
import com.produtos.sa.repositories.PedidoItemRepository;
import com.produtos.sa.repositories.PedidoRepository;
import com.produtos.sa.repositories.ProdutoRepository;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto pr1 = new Produto(null, "Previdência Particular", "A nova aposentadoria", 20.0);
		Produto pr2 = new Produto(null, "Smart TV", "55 polegadas", 2000.0);
		Produto pr3 = new Produto(null, "Notebook", "14 polegadas", 1500.0);
		Produto pr4 = new Produto(null, "Desktop", "21 polegadas", 1300.0);
		Produto pr5 = new Produto(null, "Nunca foi sorte", "Motivacional", 25.0);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
		
		pr1.getCategorias().add(cat2);
		pr2.getCategorias().add(cat1);
		pr2.getCategorias().add(cat3);
		pr3.getCategorias().add(cat3);
		pr4.getCategorias().add(cat3);
		pr5.getCategorias().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
		
		Cliente cl1 = new Cliente(null, "Maria", "55533344422", "25/08/1987");
		Cliente cl2 = new Cliente(null, "Rebeca", "77766655544", "25/09/1989");
		
		Pedido p1 = new Pedido(null, Instant.parse("2021-06-20T19:53:07Z"), PedidoStatus.EFETUADO_PAGAMENTO, cl1);
		Pedido p2 = new Pedido(null, Instant.parse("2021-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO,cl2);
		Pedido p3 = new Pedido(null, Instant.parse("2021-08-20T17:48:23Z"), PedidoStatus.ENTREGUE,cl1);
		
		clienteRepository.saveAll(Arrays.asList(cl1, cl2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		PedidoItem pi1 = new PedidoItem(p1, pr1, 2, pr1.getPreco());
		PedidoItem pi2 = new PedidoItem(p1, pr3, 1, pr4.getPreco());
		PedidoItem pi3 = new PedidoItem(p2, pr3, 2, pr1.getPreco());
		PedidoItem pi4 = new PedidoItem(p3, pr5, 2, pr5.getPreco());
		
		pedidoItemRepository.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2021-06-20T21:53:07Z"), p1);
		p1.setPagamento(pag1);
		
		pedidoRepository.save(p1);
		
	}

}

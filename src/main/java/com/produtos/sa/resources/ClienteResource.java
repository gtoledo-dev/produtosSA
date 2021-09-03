package com.produtos.sa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.sa.entities.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@GetMapping
	public ResponseEntity<Cliente> findAll(){
		Cliente cliente = new Cliente(1L, "João", "33355522211", "20/07/1981");
		return ResponseEntity.ok().body(cliente);
	}

}

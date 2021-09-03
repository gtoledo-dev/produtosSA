package com.produtos.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.sa.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

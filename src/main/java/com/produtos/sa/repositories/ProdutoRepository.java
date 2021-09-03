package com.produtos.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.sa.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

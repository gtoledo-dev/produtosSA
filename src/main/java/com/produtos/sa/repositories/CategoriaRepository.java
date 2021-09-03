package com.produtos.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.sa.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

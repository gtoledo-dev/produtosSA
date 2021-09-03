package com.produtos.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.sa.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

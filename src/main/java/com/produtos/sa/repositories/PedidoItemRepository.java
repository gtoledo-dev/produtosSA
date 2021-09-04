package com.produtos.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.sa.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}

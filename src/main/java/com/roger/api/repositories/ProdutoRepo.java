package com.roger.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roger.api.models.Produto;



public interface ProdutoRepo extends JpaRepository<Produto, Long> {


    Optional<Produto> findBySku(String sku);
}

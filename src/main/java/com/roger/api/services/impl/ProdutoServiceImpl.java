package com.roger.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.api.models.Produto;
import com.roger.api.repositories.ProdutoRepo;
import com.roger.api.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepo repository;

    @Override
    public List<Produto> listarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return this.repository.save(produto);
    }

    @Override
    public Produto atualizar(Produto produto) {
       return this.repository.save(produto);
    }

    @Override
    public Optional<Produto> buscarSku(String sku) {
        return this.repository.findBySku(sku);
    }

    @Override
    public void deletar(Long id) {
        this.repository.deleteById(id);
    }
    
    
}

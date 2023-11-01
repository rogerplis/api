package com.roger.api.services;



import java.util.List;
import java.util.Optional;

import com.roger.api.models.Produto;

public interface ProdutoService {

    List<Produto> listarTodos();
    Produto cadastrar(Produto produto);
    Produto atualizar(Produto produto);
    Optional<Produto> buscarSku(String sku);
    void deletar(Long id);
    
    
}

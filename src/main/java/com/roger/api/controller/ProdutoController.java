package com.roger.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roger.api.models.Produto;
import com.roger.api.services.ProdutoService;

@RestController
@RequestMapping("api/v1/")
public class ProdutoController {

    @Autowired
    private ProdutoService service;



    @PostMapping("produto")
    public ResponseEntity<Object> cadastrar(@RequestBody Produto produto){
        String skuProduto = produto.getSku();

        if (service.buscarSku(skuProduto).isPresent()) {
            return ResponseEntity.ok("SKU ja cadastrado");
        } else {
            return ResponseEntity.ok(this.service.cadastrar(produto));
        }
        

    }
    
    @GetMapping("produtos")
    public ResponseEntity<List<Produto>> listaTodos(){
        return ResponseEntity.ok(this.service.listarTodos());
    }

    @PutMapping("produto/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable(name = "id")Long id, @RequestBody Produto produto){
        return ResponseEntity.ok(this.service.atualizar(produto));

    }

    @GetMapping("produto/{sku}")
    public ResponseEntity<Optional<Produto>> buscarSku(@PathVariable(name = "sku")String sku ){
        return ResponseEntity.ok(this.service.buscarSku(sku));

    }

    @DeleteMapping("produto/{id}")
    public ResponseEntity<String> remover(@PathVariable(name = "id")Long id){
        this.service.deletar(id);
        return ResponseEntity.ok("Produto excluido com sucesso!");
    }
}

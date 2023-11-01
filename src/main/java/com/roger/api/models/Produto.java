package com.roger.api.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    @Column(unique = true)
    private String sku;
    private String descricao;
    private BigDecimal price;
    private Boolean ativo;

    public Produto() {
    }

    public Produto(Long id, String sku, String descricao, BigDecimal price, Boolean ativo) {
        this.id = id;
        this.sku = sku;
        this.descricao = descricao;
        this.price = price;
        this.ativo = ativo;
    }

    

}

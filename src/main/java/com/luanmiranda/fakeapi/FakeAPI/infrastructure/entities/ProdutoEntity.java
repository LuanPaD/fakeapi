package com.luanmiranda.fakeapi.FakeAPI.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "ProdutoEntity")
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String nome;

    @Column(name = "price")
    private BigDecimal preco;

    @Column(name = "category")
    private String categoria;

    @Column(name = "description", length = 800)
    private String descricao;

    @Column(name = "image")
    private String imagem;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}

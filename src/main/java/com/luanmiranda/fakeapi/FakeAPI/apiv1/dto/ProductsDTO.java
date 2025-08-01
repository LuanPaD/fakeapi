package com.luanmiranda.fakeapi.FakeAPI.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {
    @JsonProperty(value = "id")
    @JsonIgnore
    private Long id;

    @JsonProperty(value = "entity_id")
    private String entityId;

    @JsonProperty(value = "title")
    private String nome;

    @JsonProperty(value = "price")
    private BigDecimal preco;

    @JsonProperty(value = "description")
    private String descricao;

    @JsonProperty(value = "category")
    private String categoria;

    @JsonProperty(value = "image")
    private String imagem;


}

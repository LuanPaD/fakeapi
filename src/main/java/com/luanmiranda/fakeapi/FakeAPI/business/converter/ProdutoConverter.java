package com.luanmiranda.fakeapi.FakeAPI.business.converter;

import com.luanmiranda.fakeapi.FakeAPI.apiv1.dto.ProductsDTO;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProdutoConverter {
    public ProdutoEntity toEntity(ProductsDTO dto) {
        return ProdutoEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .imagem(dto.getImagem())
                .dataInclusao(LocalDateTime.now())
                .build();
    }

    public ProdutoEntity toEntityUpdate(ProdutoEntity entity,ProductsDTO dto, String id) {
        return ProdutoEntity.builder()
                .id(id)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .preco(dto.getPreco() != null ? dto.getPreco() : entity.getPreco())
                .categoria(dto.getCategoria() != null ? dto.getCategoria() : entity.getCategoria())
                .descricao(dto.getDescricao() != null ? dto.getDescricao() : entity.getDescricao())
                .imagem(dto.getImagem() != null ? dto.getImagem() : entity.getImagem())
                .dataInclusao(entity.getDataInclusao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }

    public ProductsDTO toDTO(ProdutoEntity entity){
        return ProductsDTO.builder()
                .entityId(entity.getId())
                .nome(entity.getNome())
                .categoria(entity.getCategoria())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .imagem(entity.getImagem())
                .build();
    }

    public List<ProductsDTO> toListDTO(List<ProdutoEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }
}

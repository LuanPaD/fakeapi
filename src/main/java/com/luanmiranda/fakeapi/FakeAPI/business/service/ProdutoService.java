package com.luanmiranda.fakeapi.FakeAPI.business.service;

import com.luanmiranda.fakeapi.FakeAPI.apiv1.dto.ProductsDTO;
import com.luanmiranda.fakeapi.FakeAPI.business.converter.ProdutoConverter;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.entities.ProdutoEntity;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoConverter produtoConverter;

    public ProdutoEntity salvaProdutos(ProdutoEntity produto) {
        try {
            return produtoRepository.save(produto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o produto: " + e.getMessage());
        }
    }

    public ProductsDTO salvaProdutosDTO(ProductsDTO produtoDTO) {
        try {
            ProdutoEntity produtoEntity = produtoConverter.toEntity(produtoDTO);
            ProdutoEntity savedEntity = salvaProdutos(produtoEntity);
            return produtoConverter.toDTO(savedEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o produto: " + e.getMessage(), e);
        }
    }

    public List<ProdutoEntity> buscaTodosProdutos() {
        try {
            return produtoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }
    }

    public List<ProductsDTO> buscaTodosProdutosDTO() {
        try {
            List<ProdutoEntity> produtos = buscaTodosProdutos();
            return produtoConverter.toListDTO(produtos);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os produtos DTO: " + e.getMessage(), e);
        }
    }

    public Boolean existeProdutoPorNome(String nome) {
        try {
            return produtoRepository.existsByNome(nome);

        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao verificar a existência do produto pelo nome: %s", nome), e);        }
    }

    public ProductsDTO buscaProdutoPorNome(String nome) {
        try {
            if (!existeProdutoPorNome(nome)) {
                return null;
            }

            return produtoConverter.toDTO(produtoRepository.findByNome(nome));
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar produto pelo nome: %s", nome), e);
        }
    }

    public void deletaProduto(String nome) {
        try {
            produtoRepository.deleteByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao deletar produto pelo nome: %s", nome), e);
        }
    }

    public ProductsDTO updateProduto(String id, ProductsDTO produtoDTO) {
        try {
            ProdutoEntity produtoEntity = produtoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException(format("Produto com ID %s não encontrado.", id)));

            ProdutoEntity produtoAtualizado = produtoConverter.toEntityUpdate(produtoEntity, produtoDTO, id);

            salvaProdutos(produtoAtualizado);

            return produtoConverter.toDTO(produtoRepository.findByNome(produtoEntity.getNome()));
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao atualizar produto com ID %s: %s", id, e.getMessage()), e);
        }
    }
}

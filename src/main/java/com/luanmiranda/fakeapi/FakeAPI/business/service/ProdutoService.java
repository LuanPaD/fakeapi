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

    public List<ProdutoEntity> buscaTodosProdutos() {
        try {
            return produtoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }
    }

    public Boolean existeProdutoPorNome(String nome) {
        try {
            return produtoRepository.existsByNome(nome);

        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao verificar a existência do produto pelo nome: %s", nome), e);        }
    }

    public ProdutoEntity buscaProdutoPorNome(String nome) {
        try {
            return produtoRepository.findByNome(nome);
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
    //TODO Finalizar
    public ProductsDTO updateProduto(String id, ProductsDTO produtoDTO) {
        try {
            ProdutoEntity produtoEntity = produtoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException(format("Produto com ID %s não encontrado.", id)));

            produtoEntity.setNome(produtoDTO.getNome());
            produtoEntity.setPreco(produtoDTO.getPreco());
            produtoEntity.setCategoria(produtoDTO.getCategoria());
            produtoEntity.setDescricao(produtoDTO.getDescricao());
            produtoEntity.setImagem(produtoDTO.getImagem());

            ProdutoEntity updatedProduto = produtoRepository.save(produtoEntity);
            return produtoConverter.toDTO(updatedProduto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o produto: " + e.getMessage(), e);
        }
    }
}

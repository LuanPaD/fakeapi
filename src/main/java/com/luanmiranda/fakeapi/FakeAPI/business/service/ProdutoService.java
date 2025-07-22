package com.luanmiranda.fakeapi.FakeAPI.business.service;

import com.luanmiranda.fakeapi.FakeAPI.infrastructure.entities.ProdutoEntity;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

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
}

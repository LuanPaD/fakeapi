package com.luanmiranda.fakeapi.FakeAPI.business.service;

import com.luanmiranda.fakeapi.FakeAPI.apiv1.dto.ProductsDTO;
import com.luanmiranda.fakeapi.FakeAPI.business.converter.ProdutoConverter;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;
    private final ProdutoConverter produtoConverter;
    private final ProdutoService produtoService;

    public List<ProductsDTO> buscarProdutos() {
        List<ProductsDTO> produtosDTO = cliente.buscaListaProdutos();

        produtosDTO.forEach(produto -> {
            produtoService.salvaProdutos(produtoConverter.toEntity(produto));
        });

        return produtoConverter.toListDTO(produtoService.buscaTodosProdutos());
    }
}

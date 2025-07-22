package com.luanmiranda.fakeapi.FakeAPI.business.service;

import com.luanmiranda.fakeapi.FakeAPI.apiv1.dto.ProductsDTO;
import com.luanmiranda.fakeapi.FakeAPI.business.converter.ProdutoConverter;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;
    private final ProdutoConverter produtoConverter;
    private final ProdutoService produtoService;

    public List<ProductsDTO> buscarProdutos() {
        try {
            List<ProductsDTO> produtosDTO = cliente.buscaListaProdutos();

            produtosDTO.forEach(produto -> {
                if (produtoService.existeProdutoPorNome(produto.getNome())) {
                    return;
                }

                produtoService.salvaProdutos(produtoConverter.toEntity(produto));
            });

            return produtoConverter.toListDTO(produtoService.buscaTodosProdutos());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e gravar produtos: " + e.getMessage(), e);
        }
    }
}

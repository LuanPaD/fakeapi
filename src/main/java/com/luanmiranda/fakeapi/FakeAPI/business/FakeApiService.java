package com.luanmiranda.fakeapi.FakeAPI.business;

import com.luanmiranda.fakeapi.FakeAPI.apiv1.dto.ProductsDTO;
import com.luanmiranda.fakeapi.FakeAPI.infrastructure.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;

    public List<ProductsDTO> buscarProdutos() {
        return cliente.buscaListaProdutos();
    }
}

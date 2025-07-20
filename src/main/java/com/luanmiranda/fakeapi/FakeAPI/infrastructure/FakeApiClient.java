package com.luanmiranda.fakeapi.FakeAPI.infrastructure;

import com.luanmiranda.fakeapi.FakeAPI.apiv1.dto.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fake-api", url = "${fake-api.url:#{null}}")
public interface FakeApiClient {

    @GetMapping("/products")
    List<ProductsDTO> buscaListaProdutos();
}

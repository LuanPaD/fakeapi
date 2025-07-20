package com.luanmiranda.fakeapi.FakeAPI.apiv1.dto;

import com.luanmiranda.fakeapi.FakeAPI.business.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "Fake API", description = "Fake API para testes")
public class FakeApiController {
    private final FakeApiService fakeApiService;

    @Operation(summary = "Busca todos os produtos disponíveis", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @GetMapping("")
    public ResponseEntity<List<ProductsDTO>> buscaProdutos() {
        return ResponseEntity.ok(fakeApiService.buscarProdutos());
    }
}

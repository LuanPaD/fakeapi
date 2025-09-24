package com.luanmiranda.fakeapi.FakeAPI.apiv1.dto;

import com.luanmiranda.fakeapi.FakeAPI.business.service.FakeApiService;
import com.luanmiranda.fakeapi.FakeAPI.business.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "Fake API", description = "Fake API para testes")
public class FakeApiController {
    private final FakeApiService fakeApiService;
    private final ProdutoService produtoService;

    @Operation(summary = "Busca produtos da API e Salvar", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @PostMapping("/")
    public ResponseEntity<List<ProductsDTO>> buscaProdutos() {
        return ResponseEntity.ok(fakeApiService.buscarProdutos());
    }

    @Operation(summary = "Salva novos produtos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @PostMapping("/api")
    public ResponseEntity<ProductsDTO> salvaProdutos(@RequestBody ProductsDTO productsDTO) {
        return ResponseEntity.ok(produtoService.salvaProdutosDTO(productsDTO));
    }

    @Operation(summary = "Faz atualizacao de produtos", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar os produtos"),
    })
    @PutMapping("/")
    public ResponseEntity<ProductsDTO> updateProdutos(@RequestParam String id, @RequestBody ProductsDTO productsDTO) {
        return ResponseEntity.ok(produtoService.updateProduto(id, productsDTO));
    }

    @Operation(summary = "Deleta produtos", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar os produtos"),
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> deletaProduto(@RequestParam ("nome") String nome) {
        produtoService.deletaProduto(nome);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar os produtos"),
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductsDTO>> buscaTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscaTodosProdutosDTO());
    }

    @Operation(summary = "Busca produto por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o produto"),
    })
    @GetMapping("/{nome}")
    public ResponseEntity<ProductsDTO> buscaProdutoPorNome(@PathVariable ("nome") String nome) {
        try {
            ProductsDTO produto = produtoService.buscaProdutoPorNome(nome);
            return (produto != null) ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

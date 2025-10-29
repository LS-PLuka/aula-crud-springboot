package com.example.primeiro_crud_spring.controller;

import com.example.primeiro_crud_spring.model.Produto;
import com.example.primeiro_crud_spring.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // endpoints
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
        Produto produto = produtoService.getProdutoById(id);
        return ResponseEntity.ok(produto);

    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}

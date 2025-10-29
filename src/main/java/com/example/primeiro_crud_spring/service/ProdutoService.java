package com.example.primeiro_crud_spring.service;

import com.example.primeiro_crud_spring.exceptions.RecursoNaoEncontradoException;
import com.example.primeiro_crud_spring.model.Produto;
import com.example.primeiro_crud_spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // metodos CRUD
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com id " + id + " não encontrado"));
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto com id " + id + " não encontrado");
        }

        produtoRepository.deleteById(id);
    }
}

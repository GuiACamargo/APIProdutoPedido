package com.atitus.APIProdutoPedido.controllers;

import com.atitus.APIProdutoPedido.entities.Produto;
import com.atitus.APIProdutoPedido.services.GenericService;
import com.atitus.APIProdutoPedido.services.ProdutoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto> {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    GenericService<Produto> getService() {
        return produtoService;
    }
}

package com.atitus.APIProdutoPedido.servicesimpl;

import com.atitus.APIProdutoPedido.entities.Produto;
import com.atitus.APIProdutoPedido.repositories.GenericRepository;
import com.atitus.APIProdutoPedido.repositories.ProdutoRepository;
import com.atitus.APIProdutoPedido.services.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public GenericRepository<Produto> getRepository() {
        return produtoRepository;
    }
}

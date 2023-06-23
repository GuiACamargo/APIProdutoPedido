package com.atitus.APIProdutoPedido.servicesimpl;

import com.atitus.APIProdutoPedido.entities.Pedido;
import com.atitus.APIProdutoPedido.repositories.GenericRepository;
import com.atitus.APIProdutoPedido.repositories.PedidoRepository;
import com.atitus.APIProdutoPedido.services.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public GenericRepository<Pedido> getRepository() {
        return pedidoRepository;
    }
}

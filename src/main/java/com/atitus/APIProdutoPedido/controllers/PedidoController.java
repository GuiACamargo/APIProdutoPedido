package com.atitus.APIProdutoPedido.controllers;

import com.atitus.APIProdutoPedido.services.GenericService;
import com.atitus.APIProdutoPedido.services.PedidoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atitus.APIProdutoPedido.entities.Pedido;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/pedidos")
public class PedidoController extends GenericController<Pedido>{

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    GenericService<Pedido> getService() {
        return pedidoService;
    }

}

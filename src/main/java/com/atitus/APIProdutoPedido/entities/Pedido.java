package com.atitus.APIProdutoPedido.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido extends GenericEntity {

    @Column(nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(nullable = false, name ="id_produto")
    private Produto produto;

    @Column(nullable = false)
    private double quantidade;

    public Pedido() {
    }

    public Pedido(Date data, Produto produto, double quantidade) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}

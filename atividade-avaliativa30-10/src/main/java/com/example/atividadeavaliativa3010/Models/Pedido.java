package com.example.atividadeavaliativa3010.Models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> listaDeCompras  = new ArrayList<>();
    
    public List<Produto> getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(List<Produto> listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public void addProduto(Produto produto) {
        this.listaDeCompras.add(produto);
    }
    public void addProduto(List<Produto> produtos) {
        this.listaDeCompras.addAll(produtos);
    }
    public void removeProduto(int id)
    {
        for (int i = 0; i < listaDeCompras.size(); i++) {
            if (listaDeCompras.get(i).getId() == id) {
                listaDeCompras.remove(i);
            }
        }
    }
    public void removeProduto(int id, int quantidade)
    {
        for (Produto produto : listaDeCompras) {
            if (produto.getId() == id) {
                produto.removerQuantidade(quantidade);
            }
        }
    }
}

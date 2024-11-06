package com.example.atividadeavaliativa3010.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pedido {
    private Stack<Produto> listaDeCompras  = new Stack<>();
    
    public Stack<Produto> getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(Stack<Produto> listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public void addProduto(Produto produto) {
        this.listaDeCompras.add(produto);
    }
    public void addProduto(Stack<Produto> produtos) {
        this.listaDeCompras.addAll(produtos);
    }
    public void removeProduto(int codigo)
    {
        for (int i = 0; i < listaDeCompras.size(); i++) {
            if (listaDeCompras.get(i).getId() == codigo) {
                listaDeCompras.remove(i);
            }
        }
    }
    public void adicionarQuantidade(int codigo, int quantidade)
    {
        getProduto(codigo).adicionarQuantidade(quantidade);
    }
    public void removerQuantidade(int codigo, int quantidade)
    {
        getProduto(codigo).removerQuantidade(quantidade);
    }
    public Produto getProduto(int id)
    {
        for (Produto produto : listaDeCompras) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}

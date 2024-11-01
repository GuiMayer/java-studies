package com.example.atividadeavaliativa3010.Models;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
    public static Mercado Instance;

    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Pedido> pedidos = new ArrayList();
    public Mercado(List<Produto> produtos)
    {
        if (Instance == null) {
            Instance = this;
        }

        setProdutos(produtos);
    }
    public Mercado()
    {
        if (Instance == null) {
            Instance = this;
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
    public void addProduto(List<Produto> produtos) {
        this.produtos.addAll(produtos);
    }

    public Produto getProduto(int id)
    {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void setProduto(int id, Produto produto)
    {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.set(i, produto);
            }
        }
    }
    public void removeProduto(int id)
    {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Produto produto : produtos) {
            stringBuilder.append(produto);
        }
        return stringBuilder.toString();
    }
}

package com.example.atividadeavaliativa3010.Models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mercado {
    public static Mercado Instance;

    public Mercado()
    {
        if (Instance == null) {
            Instance = this;
        }
        loadProdutos();
    }
    public Mercado(List<Produto> produtos)
    {
        if (Instance == null) {
            Instance = this;
        }
        loadProdutos();

        addProdutoAll(produtos);
    }
    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Pedido> pedidos = new Stack<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        SaveProdutos();
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        SaveProdutos();
    }

    public void addProdutoAll(List<Produto> produtos) {
        this.produtos.addAll(produtos);
        SaveProdutos();
    }

    public void editarProduto(int codigo, Produto produto) {
        Produto produtoExistente = getProduto(codigo);

        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            produtoExistente.setQuantidade(produto.getQuantidade());

            SaveProdutos();
        }
    }

    private void SaveProdutos()
    {
        Loader loader = new LoaderBin();
        loader.save(produtos);
    }

    private void loadProdutos()
    {
        File file = new File(LoaderBin.PRODUTOS_SAVE_FILE_NAME);
        Loader loader = new LoaderBin();
        if (file.exists()) {
            this.produtos = loader.load();
            Produto.setIdPool(produtos);
        }
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
    public void removeProduto(int codigo)
    {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == codigo) {
                produtos.remove(i);
            }
        }
    }
    public boolean existe(int codigo)
    {
        return getProduto(codigo) != null;
    }
    public void adicionarQuantidade(int codigo, int quantidade)
    {
        if (existe(codigo)) getProduto(codigo).adicionarQuantidade(quantidade);
    }
    public void removerQuantidade(int codigo, int quantidade)
    {
        if (existe(codigo)) getProduto(codigo).removerQuantidade(quantidade);
    }
    public String toString() {
        if (!produtos.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Produto produto : produtos) {
                stringBuilder.append(produto+"\n");
            }
            return stringBuilder.toString();
        }
        return "";
    }


    // --------------------------------------------------------
    //               PEDIDOS

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}

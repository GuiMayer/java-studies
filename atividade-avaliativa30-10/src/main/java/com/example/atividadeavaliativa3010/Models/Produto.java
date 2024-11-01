package com.example.atividadeavaliativa3010.Models;


import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {
    private static int idCounter;
    private static List<Integer> idPool = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;

    private String nome;

    private int quantidade;

    private double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        idCounter++;

        while (idPool.contains(idCounter)) {
            idCounter++;
        }

        this.id = idCounter;
        idPool.add(this.id);
    }
    public Produto(int id, String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;

        while (idPool.contains(id)) {
            id++;
        }

        this.id = id;
        idPool.add(this.id);
    }

    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    public static void setIdPool(List<Produto> produtos) {
        idPool.clear();
        if (produtos == null) {
            return;
        }
        for (Produto produto : produtos) {
            idPool.add(produto.id);
        }
    }
}

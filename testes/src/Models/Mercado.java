package Models;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
    public static Mercado Instance;

    public Mercado()
    {
        if (Instance == null) {
            Instance = this;
        }
    }
    private List<Produto> produtos = new ArrayList<Produto>();

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
}

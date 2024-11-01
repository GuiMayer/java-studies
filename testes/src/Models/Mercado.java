package Models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mercado {
    public static Mercado Instance;

    public Mercado()
    {
        if (Instance == null) {
            Instance = this;
        }
        File file = new File(LoaderBin.FILE_NAME);
        Loader loader = new LoaderBin();
        if (file.exists()) {
            produtos = loader.load();
        }
    }
    private List<Produto> produtos = new ArrayList<Produto>();

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

    private void SaveProdutos()
    {
        Loader loader = new LoaderBin();
        loader.save(produtos);
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

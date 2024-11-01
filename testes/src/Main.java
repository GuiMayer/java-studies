import Models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Loader loader = new LoaderBin();

        // Criar uma lista de produtos
        List<Produto> produtos = new ArrayList<>();
//        produtos.add(new Produto(1, "Produto A", 10, 29.99));
//        produtos.add(new Produto(2, "Produto B", 5, 19.99));

        // Salvar a lista em um arquivo binário
        //loader.save(produtos);

        // Carregar a lista do arquivo binário
        List<Produto> loadedProducts = loader.load();
        for (Produto p : loadedProducts) {
            System.out.println(p);
        }
    }
}
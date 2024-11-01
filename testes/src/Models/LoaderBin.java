package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoaderBin implements Loader {
    private static final String FILE_NAME = "save.bin"; // Nome do arquivo binário

    public void save(List<Produto> produtos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(produtos);
            System.out.println("Lista salva com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a lista: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Produto> load() {
        List<Produto> produtos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            produtos = (List<Produto>) ois.readObject(); // Lê a lista de produtos
            System.out.println("Lista carregada com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar a lista: " + e.getMessage());
            e.printStackTrace();
        }
        return produtos;
    }
}
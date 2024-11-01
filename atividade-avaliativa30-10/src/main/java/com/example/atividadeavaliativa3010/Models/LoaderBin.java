package com.example.atividadeavaliativa3010.Models;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoaderBin implements Loader {
    public static final String PRODUTOS_SAVE_FILE_NAME = "produtosSave.bin"; // Nome do arquivo binário

    public void save(List<Produto> produtos, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            showErrorDialog("Erro ao salvar a lista: " + e.getMessage());
        }
    }

    public void save(List<Produto> produtos) {
        save(produtos, PRODUTOS_SAVE_FILE_NAME);
    }

    public List<Produto> load(String path) {
        List<Produto> produtos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            produtos = (List<Produto>) ois.readObject(); // Lê a lista de produtos
            System.out.println("Lista carregada com sucesso!");
        } catch (FileNotFoundException e) {
            showErrorDialog("Arquivo não encontrado: " + path);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            showErrorDialog("Erro ao carregar a lista: " + e.getMessage());
            return null;
        }
        return produtos;
    }

    public List<Produto> load() {
        return load(PRODUTOS_SAVE_FILE_NAME);
    }

    public static void showErrorDialog(String message) {
        // Cria um novo alerta do tipo erro
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro"); // Define o título do diálogo
        alert.setHeaderText(null); // Não define um cabeçalho
        alert.setContentText(message); // Define a mensagem de erro

        // Exibe o diálogo e aguarda a resposta do usuário
        alert.showAndWait();
    }
}
package com.example.atividadeavaliativa3010.Models;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoaderBin implements Loader {
    private static final String FILE_NAME = "save.bin"; // Nome do arquivo binário

    public void save(List<Produto> produtos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            showErrorDialog("Erro ao salvar a lista: " + e.getMessage());
        }
    }

    public List<Produto> load() {
        List<Produto> produtos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            produtos = (List<Produto>) ois.readObject(); // Lê a lista de produtos
            System.out.println("Lista carregada com sucesso!");
        } catch (FileNotFoundException e) {
            showErrorDialog("Arquivo não encontrado: " + FILE_NAME);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            showErrorDialog("Erro ao carregar a lista: " + e.getMessage());
            return null;
        }
        return produtos;
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
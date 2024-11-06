package com.example.atividadeavaliativa3010.Models;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.atividadeavaliativa3010.Models.Utils.showErrorDialog;

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
}
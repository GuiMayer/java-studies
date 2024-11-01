package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Produto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 620);
        stage.setTitle("Supermercado Preço Bom");
        stage.getIcons().add(new Image("file:src/main/resources/icon_bom_preco.png"));
        stage.setScene(scene);

        Mercado mercado = new Mercado(Arrays.asList(
                new Produto(1, "Arroz", 50, 3.79), // kg
                new Produto(2, "Feijão Preto", 30, 4.29), // kg
                new Produto(3, "Açúcar", 25, 2.49), // kg
                new Produto(4, "Sal", 15, 1.99), // kg
                new Produto(5, "Óleo de Soja", 20, 7.89), // 900ml
                new Produto(6, "Leite Integral", 40, 3.29), // 1L
                new Produto(7, "Queijo Mussarela", 10, 24.90), // kg
                new Produto(8, "Frango Congelado", 15, 8.49), // kg
                new Produto(9, "Notebook", 5, 2999.99), // unidade
                new Produto(10, "Smartphone", 8, 1499.99) // unidade
        ));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
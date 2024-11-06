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

        Mercado mercado = new Mercado();

        System.out.println(mercado);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
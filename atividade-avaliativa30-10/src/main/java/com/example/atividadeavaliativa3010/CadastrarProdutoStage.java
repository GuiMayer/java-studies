package com.example.atividadeavaliativa3010;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastrarProdutoStage extends Stage {

    public CadastrarProdutoStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cadastrarProduto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 260);
        this.setTitle("Cadastrar Produto");
        this.getIcons().add(new Image("file:src/main/resources/icon_bom_preco.png"));
        this.setScene(scene);
        this.show();
    }

}
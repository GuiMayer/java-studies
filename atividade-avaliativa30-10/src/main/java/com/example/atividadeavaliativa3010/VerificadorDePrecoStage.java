package com.example.atividadeavaliativa3010;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class VerificadorDePrecoStage extends Stage {

    public VerificadorDePrecoStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("verificadorDePreco-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 640);
        this.setTitle("Verificador de Preço");
        this.getIcons().add(new Image("file:src/main/resources/icon_bom_preco.png"));
        this.setScene(scene);
        this.show();
    }

}
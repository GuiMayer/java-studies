package com.example.atividadeavaliativa3010;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class HelloController {
    @FXML
    private Label versionText;

    @FXML
    public void OnSairActionButton(ActionEvent actionEvent) {
        showConfirmationDialog("Deseja realmente sair?", "Aperte Ok para sair.", () -> System.exit(0));
    }

    @FXML
    public void OnSobreActionButton(ActionEvent actionEvent) throws IOException {
        new SobreStage();
    }

    @FXML
    public void OnCaixaActionButton(ActionEvent actionEvent) throws IOException {
        new CaixaStage();
    }

    @FXML
    public void OnVerificadorDePrecoActionButton(ActionEvent actionEvent) throws IOException {
        new VerificadorDePrecoStage();
    }

    private void showConfirmationDialog(String title, String message, Runnable onConfirm) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.setContentText("Selecione uma opção:");

        // Adiciona botões de confirmação e cancelamento
        alert.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);

        // Mostra o diálogo e espera pela resposta do usuário
        Optional<ButtonType> result = alert.showAndWait();

        // Executa a função caso o usuário clique em OK
        if (result.isPresent() && result.get() == ButtonType.OK) {
            onConfirm.run(); // Chama a função passada
        }
    }
}
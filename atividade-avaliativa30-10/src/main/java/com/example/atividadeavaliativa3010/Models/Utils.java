package com.example.atividadeavaliativa3010.Models;

import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;

public class Utils {
    public static TextFormatter<String> getJustNumberFormattingTextField()
    {
        return new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        });
    }
    public static TextFormatter<String> getNumberWithDotFormattingTextField() {
        return new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            newText = newText.replace(',', '.');

            if (newText.matches("\\d*\\.?\\d*")) {
                return change;
            } else {
                return null;
            }
        });
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

package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class ExcluirProdutoController {


    @FXML
    public Label feedbackCodigoProdutoLabel;
    @FXML
    public TextField codigoProdutoTextField;

    @FXML
    public void initialize() {
        codigoProdutoTextField.setTextFormatter(Utils.getJustNumberFormattingTextField());
    }

    @FXML
    public void OnExcluirProdutoActionButton(ActionEvent actionEvent) {
    }
}
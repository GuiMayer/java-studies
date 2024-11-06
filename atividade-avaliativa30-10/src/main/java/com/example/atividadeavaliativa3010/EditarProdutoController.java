package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Produto;
import com.example.atividadeavaliativa3010.Models.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class EditarProdutoController {


    @FXML
    public Label feedbackCodigoProdutoLabel;
    @FXML
    public TextField codigoProdutoTextField;
    @FXML
    public TextField nomeProdutoTextField;
    @FXML
    public TextField precoProdutoTextField;
    @FXML
    public TextField quantidadeProdutoTextField;
    @FXML
    public Button editarProdutoButton;

    @FXML
    public void initialize() {
        codigoProdutoTextField.setTextFormatter(Utils.getJustNumberFormattingTextField());
    }

    @FXML
    public void OnEditarProdutoActionButton(ActionEvent actionEvent) {
        String nome = nomeProdutoTextField.getText();
        int quantidade = Integer.parseInt(quantidadeProdutoTextField.getText());
        double preco = Double.parseDouble(precoProdutoTextField.getText());
        Produto produto = new Produto(nome, quantidade, preco);

        Mercado.Instance.addProduto(produto);

        nomeProdutoTextField.setText("");
        quantidadeProdutoTextField.setText("");
        precoProdutoTextField.setText("");
        Utils.showSuccsessDialog("Produto adicionado com sucesso!");

        editarProdutoButton.setDisable(true);
    }
}
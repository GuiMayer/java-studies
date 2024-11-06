package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Produto;
import com.example.atividadeavaliativa3010.Models.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastrarProdutoController {

    @FXML
    public TextField nomeProdutoTextField;
    @FXML
    public TextField precoProdutoTextField;
    @FXML
    public TextField quantidadeProdutoTextField;

    @FXML
    public void initialize() {

    }

    @FXML
    public void OnCadastrarProdutoActionButton(ActionEvent actionEvent) {
        String nome = nomeProdutoTextField.getText();
        Integer quantidade = Integer.parseInt(quantidadeProdutoTextField.getText());
        Double preco = Double.parseDouble(precoProdutoTextField.getText());
        Produto produto = new Produto(nome, quantidade, preco);

        Mercado.Instance.addProduto(produto);

        nomeProdutoTextField.setText("");
        quantidadeProdutoTextField.setText("");
        precoProdutoTextField.setText("");
        Utils.showSuccsessDialog("Produto adicionado com sucesso!");
    }
}
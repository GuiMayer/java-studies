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
import javafx.scene.input.KeyEvent;

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
        int codigoProduto = Integer.parseInt(codigoProdutoTextField.getText());
        String nome = nomeProdutoTextField.getText();
        int quantidade = Integer.parseInt(quantidadeProdutoTextField.getText());
        double preco = Double.parseDouble(precoProdutoTextField.getText());
        Produto produto = new Produto(nome, quantidade, preco);

        Mercado.Instance.editarProduto(codigoProduto, produto);

        codigoProdutoTextField.setText("");
        LimparVariaveis();
        Utils.showSuccsessDialog("Produto editado com sucesso!");

        editarProdutoButton.setDisable(true);
    }

    @FXML
    public void onCodigoProdutoKeyPressed(KeyEvent event) {
        String keyPressed = event.getText();
        int codigo;

        try {
            codigo = Integer.parseInt(codigoProdutoTextField.getText());
        } catch (Exception e) {
            codigo = 0;
        }

        if (Mercado.Instance.existe(codigo)) {
            nomeProdutoTextField.setText(Mercado.Instance.getProduto(codigo).getNome());
            quantidadeProdutoTextField.setText(""+Mercado.Instance.getProduto(codigo).getQuantidade());
            precoProdutoTextField.setText(""+Mercado.Instance.getProduto(codigo).getPreco());
            editarProdutoButton.setDisable(false);
        } else {
            LimparVariaveis();
            editarProdutoButton.setDisable(true);
        }
    }
    private void LimparVariaveis()
    {
        nomeProdutoTextField.setText("");
        quantidadeProdutoTextField.setText("");
        precoProdutoTextField.setText("");
    }
}

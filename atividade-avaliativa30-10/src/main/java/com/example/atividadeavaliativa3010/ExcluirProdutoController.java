package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Produto;
import com.example.atividadeavaliativa3010.Models.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;

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
        int codigoProduto = Integer.parseInt(codigoProdutoTextField.getText());

        Mercado.Instance.deletarProduto(codigoProduto);

        codigoProdutoTextField.setText("");
        feedbackCodigoProdutoLabel.setText("");
        Utils.showSuccsessDialog("Produto deletado com sucesso!");
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
            feedbackCodigoProdutoLabel.setText(Mercado.Instance.getProduto(codigo).getNome() + " - R$" +
                    Mercado.Instance.getProduto(codigo).getPreco() + "   - Quantidade: " + Mercado.Instance.getProduto(codigo).getQuantidade());
        } else {
            feedbackCodigoProdutoLabel.setText("");
        }
    }
}
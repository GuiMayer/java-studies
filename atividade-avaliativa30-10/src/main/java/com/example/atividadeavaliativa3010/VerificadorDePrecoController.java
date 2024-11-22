package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Pedido;
import com.example.atividadeavaliativa3010.Models.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class VerificadorDePrecoController {

    @FXML
    public TextField codigoProdutoTextField;
    @FXML
    public Label precoProdutoLabel;
    @FXML
    public Label nomeProdutoLabel;

    @FXML
    public void initialize()
    {
        codigoProdutoTextField.setTextFormatter(Utils.getJustNumberFormattingTextField());
    }

    @FXML
    public void onCodigoProdutoKeyPressed(KeyEvent event) {

//        if (event.getCode().toString().equals("ENTER")) {
//            if (Mercado.Instance.getProduto(Integer.parseInt(codigoProdutoTextField.getText())) != null) {
//                nomeProdutoLabel.setText(Mercado.Instance.getProduto(Integer.parseInt(codigoProdutoTextField.getText())).getNome());
//                precoProdutoLabel.setText("R$ "+Mercado.Instance.getProduto(Integer.parseInt(codigoProdutoTextField.getText())).getPreco());
//            } else {
//                nomeProdutoLabel.setText("Código inexistente");
//                precoProdutoLabel.setText("R$ 0.00");
//            }
//        }
        String keyPressed = event.getText();
        int codigo;

        try {
            codigo = Integer.parseInt(codigoProdutoTextField.getText());
        } catch (Exception e) {
            codigo = 0;
        }

        if (Mercado.Instance.existe(codigo)) {
            nomeProdutoLabel.setText(Mercado.Instance.getProduto(Integer.parseInt(codigoProdutoTextField.getText())).getNome());
            precoProdutoLabel.setText("R$ "+Mercado.Instance.getProduto(Integer.parseInt(codigoProdutoTextField.getText())).getPreco());
        } else {
            nomeProdutoLabel.setText("");
            precoProdutoLabel.setText("R$ 0.00");
        }
    }
}
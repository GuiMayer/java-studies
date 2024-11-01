package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Optional;

public class ProdutosCadastradosController {

    @FXML
    public TextArea produtosTextArea;

    @FXML
    public void initialize() {
        AtualizarProdutos();
    }

    @FXML
    public void OnAtualizarActionButton(ActionEvent actionEvent) {
        AtualizarProdutos();
    }

    private void AtualizarProdutos()
    {
        produtosTextArea.clear();
        for (Produto produto : Mercado.Instance.getProdutos()) {
            produtosTextArea.appendText("Código: " + produto.getId() + "   Nome: " + produto.getNome() + "   Preço: " +
                    produto.getPreco() + "   Quantidade: " + produto.getQuantidade() + "\n");
        }
    }
}
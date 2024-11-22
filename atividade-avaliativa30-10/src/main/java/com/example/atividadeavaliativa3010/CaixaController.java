package com.example.atividadeavaliativa3010;

import com.example.atividadeavaliativa3010.Models.Mercado;
import com.example.atividadeavaliativa3010.Models.Pedido;
import com.example.atividadeavaliativa3010.Models.Produto;
import com.example.atividadeavaliativa3010.Models.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.util.Objects;
import java.util.Stack;

public class CaixaController {

    @FXML
    public TextField codigoTextField;
    @FXML
    public TextField quantidadeTextField;
    @FXML
    public TextField valorPagoTextField;
    @FXML
    public TextArea listaDeProdutosTextArea;
    @FXML
    public Label totalLabel;
    @FXML
    public Label trocoLabel;
    @FXML
    public Label produtoLabel;
    private Pedido pedidoAtual;
    private double total = 0.0;
    private double troco = -1;

    @FXML
    public void initialize()
    {
        pedidoAtual = new Pedido();
        codigoTextField.setTextFormatter(Utils.getJustNumberFormattingTextField());
        quantidadeTextField.setTextFormatter(Utils.getJustNumberFormattingTextField());
        valorPagoTextField.setTextFormatter(Utils.getNumberWithDotFormattingTextField());
    }
    @FXML
    public void OnAdicionarAListaActionButton(ActionEvent actionEvent) {
        int codigoProduto;
        int quantidadeProduto;
        try {
            codigoProduto = Integer.parseInt(codigoTextField.getText());
            quantidadeProduto = Integer.parseInt(quantidadeTextField.getText());
            Produto produto = Mercado.Instance.getProduto(codigoProduto);
            produto.setQuantidade(quantidadeProduto);
            //if (Mercado.Instance.getPedidos())
            pedidoAtual.addProduto(produto);
        } catch (Exception e) {
            Utils.showErrorDialog(e.getMessage());
        }

        atualizarListaDeProdutosTextArea();
        atualizarSomaDeProdutosTextArea();
        AtualizarTroco();
    }

    @FXML
    public void OnExcluirActionButton(ActionEvent actionEvent) {
        Stack<Produto> listaCompra = pedidoAtual.getListaDeCompras();
        if (!listaCompra.isEmpty()) pedidoAtual.getListaDeCompras().pop();

        atualizarListaDeProdutosTextArea();
        atualizarSomaDeProdutosTextArea();
        AtualizarTroco();
    }


    @FXML
    public void onCodigoProdutoKeyPressed(KeyEvent event) {
        String keyPressed = event.getText();
        int codigo;

        try {
            codigo = Integer.parseInt(codigoTextField.getText());
        } catch (Exception e) {
            codigo = 0;
        }

        if (Mercado.Instance.existe(codigo)) {
            produtoLabel.setText(Mercado.Instance.getProduto(codigo).getNome() + " - R$" +
                    Mercado.Instance.getProduto(codigo).getPreco());
        } else {
            produtoLabel.setText("");
        }
    }
    private void atualizarListaDeProdutosTextArea()
    {
        listaDeProdutosTextArea.clear();
        Stack<Produto> listaCompra = pedidoAtual.getListaDeCompras();
        if (listaCompra.isEmpty()) return;
        for (Produto produto : listaCompra) {
            listaDeProdutosTextArea.appendText(produto.toString() + "\n");
        }
    }
    private void atualizarSomaDeProdutosTextArea()
    {
        double soma = 0;
        for (Produto produto : pedidoAtual.getListaDeCompras()) {
            soma += produto.getQuantidade() * produto.getPreco();
        }
        total = soma;
        totalLabel.setText("R$"+String.format("%.2f", total));
    }

    @FXML
    public void onValorPagoKeyPressed(KeyEvent keyEvent) {
        AtualizarTroco();

    }

    @FXML
    public void OnEmitirNotaFiscalActionButton(ActionEvent actionEvent) {
        if(listaDeProdutosTextArea.getText().isEmpty()) Utils.showErrorDialog("Nenhum produto cadastrado!");
        else {
            if (troco < 0.0) Utils.showErrorDialog("Compra não autorizada, valor insuficiente!");
            else {
                Utils.showSuccsessDialog("Nota fiscal emitida.");
                LimparCampos();
            }
        }
    }

    private void AtualizarTroco()
    {
        double valorPago = 0.0;
        try {
            if (Objects.equals(valorPagoTextField.getText(), "")) valorPago = 0.0;
            else valorPago = Double.parseDouble(valorPagoTextField.getText().replace(",", "."));
        } catch (Exception e) {
            Utils.showErrorDialog(e.getMessage());
        }
        troco = valorPago-total;
        trocoLabel.setText("R$"+String.format("%.2f", troco));
    }

    private void LimparCampos()
    {
        codigoTextField.clear();
        quantidadeTextField.clear();
        valorPagoTextField.clear();
        listaDeProdutosTextArea.clear();

        produtoLabel.setText("");
        trocoLabel.setText("R$0,00");
        totalLabel.setText("R$0,00");
    }
}

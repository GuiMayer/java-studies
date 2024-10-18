package Models;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Banco {
    private String nome;
    private Double limitePadrao;
    private List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
    private ContaCorrente contaSelecionada = null;
    public Banco(String nome, Double limitePadrao) {
        this.nome = nome;
        this.limitePadrao = limitePadrao;
    }
    public void AdicionarConta(ContaCorrente conta)
    {
        contas.add(conta);
    }
    public List<ContaCorrente> GetContas()
    {
        return contas;
    }
    public ContaCorrente GetConta(String user)
    {
        for (ContaCorrente conta : contas) {
            if (conta.GetUser().equals(user)) {
                return conta;
            }
        }
        return null;
    }
    public String GetNome()
    {
        return nome;
    }
    public void RemoverConta(String user, String password)
    {
        contas.removeIf(conta -> conta.GetUser().equals(user) && conta.GetPassword().equals(password));
    }
    public void SelecionarConta(String user, String password)
    {
        if (user == null || password == null) {
            contaSelecionada = null;
        }
        for (ContaCorrente conta : contas) {
            if (conta.GetUser().equals(user) && conta.GetPassword().equals(password)) {
                contaSelecionada = conta;
            }
        }
    }
    public ContaCorrente GetContaSelecionada()
    {
        return contaSelecionada;
    }
    public void AdicionarConta()
    {
        Scanner scanner = new Scanner(System.in);
        String newUser = "", newPassword;
        var isInvalid = true;
        while (isInvalid) {
            TextAnimation.PrintAnimated("Escreva seu nome de usuário:");
            newUser = scanner.nextLine();
            if (GetConta(newUser) == null) {
                TextAnimation.PrintAnimated("User válido.");
                isInvalid = false;
            } else {
                TextAnimation.PrintAnimated("User inválido, tente novamente.");
            }
        }
        TextAnimation.PrintAnimated("Digite sua senha:");
        newPassword = scanner.nextLine();

        contas.add(new ContaCorrente(newUser, newPassword, limitePadrao));
        TextAnimation.PrintAnimated("Olá " + newUser + ", bem-vindo ao banco " + nome + ".");
        TextAnimation.PrintAnimated("Seu limite inicial é R$" + limitePadrao + ".");
    }
    public void Init()
    {
        Scanner scanner = new Scanner(System.in);
        var isRunning = true;
        while (isRunning) {
            TextAnimation.PrintAnimated("Escolha uma opção:");
            TextAnimation.PrintAnimated("1. Entrar na sua conta.");
            TextAnimation.PrintAnimated("2. Criar uma conta.");
            TextAnimation.PrintAnimated("3. Sair.");
            var opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    EntrarConta();
                    break;
                case 2:
                    AdicionarConta();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    TextAnimation.PrintAnimated("Opção inválida.");
                    break;
            }
        }
    }
    private void EntrarConta() {
        Scanner scanner = new Scanner(System.in);
        TextAnimation.PrintAnimated("Digite o nome de usuário.");
        var user = scanner.nextLine();
        TextAnimation.PrintAnimated("Digite sua senha:");
        var password = scanner.nextLine();
        SelecionarConta(user, password);

        TextAnimation.PrintAnimated("Olá " + user + ", bem-vindo ao banco " + nome + ".");
        var isRunning = true;
        while (isRunning) {
            TextAnimation.PrintAnimated("Saldo atual: R$" + contaSelecionada.GetSaldo());
            TextAnimation.PrintAnimated("Selecione uma opção:");
            TextAnimation.PrintAnimated("1. Depositar dinheiro");
            TextAnimation.PrintAnimated("2. Sacar dinheiro.");
            TextAnimation.PrintAnimated("3. Sair.");
            var opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    TextAnimation.PrintAnimated("Digite o valor a ser depositado:");
                    var valorDeposito  = scanner.nextDouble();
                    contaSelecionada.Depositar(valorDeposito);
                    break;
                case 2:
                    TextAnimation.PrintAnimated("Digite o valor a sacar:");
                    var valorSaque = scanner.nextDouble();
                    contaSelecionada.Sacar(valorSaque);
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    TextAnimation.PrintAnimated("Opção inválida.");
                    break;
            }
        }
        SelecionarConta(null, null);
    }
}

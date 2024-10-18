package Models;

import org.w3c.dom.Text;

public class ContaCorrente {
    private double saldo, limite;
    private String user, password;

    public ContaCorrente(String user, String password, double saldo, double limite) {
        this.user = user;
        this.password = password;
        this.saldo = saldo;
        this.limite = limite;
    }
    public ContaCorrente(String user, String password, double limite) {
        this.user = user;
        this.password = password;
        this.saldo = 0.0;
        this.limite = limite;
    }
    public void Sacar (double valor)
    {
        if (valor <= saldo + limite) {
            saldo -= valor;
            TextAnimation.PrintAnimated("R$" + valor + " sacado da sua conta.");
        }
        else TextAnimation.PrintAnimated("Saldo insuficiente");
    }
    public void Depositar(double valor)
    {
        this.saldo += valor;
        TextAnimation.PrintAnimated("R$" + valor + " depositado na sua conta.");
    }
    public void SetLimite(double limite)
    {
        this.limite = limite;
    }
    public double GetLimite()
    {
        return this.limite;
    }
    public double GetSaldo()
    {
        return this.saldo;
    }
    public String GetUser()
    {
        return this.user;
    }
    public String GetPassword()
    {
        return this.password;
    }
    public void SetUser(String newUser)
    {
        this.user = newUser;
    }
    public void SetPassword(String newPassword)
    {
        this.password = newPassword;
    }
}

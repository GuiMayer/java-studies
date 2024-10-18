import Models.*;
import org.w3c.dom.Text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco[] bancos = {new Banco("Banco Brasileiro", 500.0), new Banco("Banco Itadu", 750.0)
                        , new Banco("Santo Ender", 400.0)};

        while (true) {
            TextAnimation.PrintAnimated("Selecione um banco:");
            ImprimirBancos(bancos);
            var opcao = scanner.nextInt();
            try {
                bancos[opcao].Init();
            } catch (ArrayIndexOutOfBoundsException e) {
                TextAnimation.PrintAnimated("Banco inexistente.");
            }

        }
    }
    private static void ImprimirBancos(Banco[] bancos) {
        var count = 0;
        for (Banco banco : bancos) {
            TextAnimation.PrintAnimated(count++ + ": " + banco.GetNome());
        }
    }
}
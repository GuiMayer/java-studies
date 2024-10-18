import Classes.Balanca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro valor:");
        double pesoPrato1 = scanner.nextDouble();

        System.out.println("Informe o segundo valor:");
        double pesoPrato2 = scanner.nextDouble();

        Balanca balanca = new Balanca();
        balanca.SetPesoPrato1(pesoPrato1);
        balanca.SetPesoPrato2(pesoPrato2);

        System.out.printf("Total: %.2f\n", balanca.ObtemTotal());
        System.out.printf("Percentual do primeiro prato: %.0f%%\n", balanca.PercentualPesoPrato1() * 100);
        System.out.printf("Percentual do segundo prato: %.0f%%\n", balanca.PercentualPesoPrato2() * 100);
        System.out.printf("Diferença do peso dos pratos: %.2f\n", balanca.DiferencaPesos());
    }
}
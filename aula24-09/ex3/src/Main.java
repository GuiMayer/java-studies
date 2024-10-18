import Models.Triangulo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangulo triangulo;
        while (true)
        {
            System.out.println("Insira o valor de a:");
            float a = scanner.nextFloat();
            System.out.println("Insira o valor de b:");
            float b = scanner.nextFloat();
            System.out.println("Insira o valor de c:");
            float c = scanner.nextFloat();

            triangulo = new Triangulo(a, b, c);
            if (triangulo.IsValido()) {
                System.out.println("Perimetro do triãngulo: " + triangulo.CalculaPerimetro());
                System.out.println("Tipo do triãngulo: " + triangulo.GetTipo());

            } else {
                System.out.println("Triângulo inválido.");
            }
        }
    }
}
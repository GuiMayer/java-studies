package exercises;

import java.util.Scanner;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        System.out.println("Informe o primeiro valor:");
        double num1 = scanner.nextDouble();

        System.out.println("Informe o segundo valor:");
        double num2 = scanner.nextDouble();

        System.out.println("Informe o terceiro valor:");
        double num3 = scanner.nextDouble();

        double result = (num1 * 1 + num2 * 2 + num3 * 3) / 6;

        System.out.println("Resultado: " + result);
    }
}

package exercises;

import java.util.Scanner;

public class ex2 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        System.out.println("Informe o peso:");
        double weight = scanner.nextDouble();

        System.out.println("Informe a altura:");
        double height = scanner.nextDouble();


        double result = weight / (Math.pow(height, 2));

        System.out.println("IMC: " + result);
    }
}

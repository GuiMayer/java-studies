package exercises;

import java.util.Scanner;

public class ex5 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        String classification = "";

        System.out.println("Informe o peso:");
        double weight = scanner.nextDouble();
        System.out.println("Informe a altura:");
        double height = scanner.nextDouble();

        double imc = weight / (Math.pow(height, 2));

        if (imc < 0) {
            classification = "IMC inválido";
        } else if (imc < 18.5) {
            classification = "Abaixo do Peso";
        } else if (imc < 25) {
            classification = "Peso normal";
        } else if (imc < 30) {
            classification = "Sobrepeso";
        } else if (imc >= 30) {
            classification = "Obesidade";
        }

        System.out.println("IMC: " + imc);
        System.out.println("Classificação: " + classification);
    }
}

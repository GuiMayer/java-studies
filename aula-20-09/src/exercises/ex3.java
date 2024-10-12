package exercises;

import java.util.Scanner;

public class ex3 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        System.out.println("Informe o valor em Celsius:");
        double celsiusTemp = scanner.nextDouble();

        double resultFahrenheit = (celsiusTemp * (9.0/5.0)) + 32.0;
        double resultKelvin = celsiusTemp + 273.15;

        System.out.printf("Valor %.2f Celsius convertido em:\nFahrenheit: %.2f\nKelvin: %.2f%n", celsiusTemp, resultFahrenheit, resultKelvin);
    }
}

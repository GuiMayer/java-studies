import Classes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor em Celsius:");
        double celsiusTemp = scanner.nextDouble();
        
        TemperaturaCelsius temperaturaCelsius = new TemperaturaCelsius();
        temperaturaCelsius.SetValorCelsius(celsiusTemp);

        System.out.printf("Valor %.2f Celsius convertido em:\nFahrenheit: %.2f\nKelvin: %.2f%n", celsiusTemp, temperaturaCelsius.ObterValorEmFahrenheit(), temperaturaCelsius.ObterValorEmKelvin());
    }
}
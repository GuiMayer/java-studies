package exercises;

import java.util.Scanner;

public class ex7 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        double bonus = 0;

        System.out.println("Informe a quantidade de horas extras:");
        double overtime = scanner.nextDouble();
        System.out.println("Informe a quantidade de horas ausentes:");
        double absentHours = scanner.nextDouble();

        double h = overtime * 60 - (2.0 / 3.0 * (absentHours * 60));

        if (h < 0) {
            bonus = 0;
        } else if (h <= 600) {
            bonus = 400;
        } else if (h <= 1200) {
            bonus = 600;
        } else if (h <= 1800) {
            bonus = 800;
        } else if (h <= 2400) {
            bonus = 1000;
        } else {
            bonus = 1200;
        }

        System.out.println("h: " + h);
        System.out.println("Gratificação: " + bonus);
    }
}

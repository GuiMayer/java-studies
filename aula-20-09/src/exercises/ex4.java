package exercises;

import java.util.Scanner;

public class ex4 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        String ageStage;
        System.out.println("Informe a idade:");
        int age = scanner.nextInt();
        if (age < 0) {
            ageStage = "Idade inválida";
        } else if (age <= 11) {
            ageStage = "Criança";
        } else if (age <= 17) {
            ageStage = "Adolescente";
        } else if (age <= 59) {
            ageStage = "Adulto";
        } else if (age <= 120) {
            ageStage = "Idoso";
        } else {
            ageStage = "Múmia";
        }

        System.out.println(ageStage);
    }
}

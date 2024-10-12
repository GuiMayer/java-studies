package exercises;

import java.util.Scanner;

public class ex6 {
    static Scanner scanner = new Scanner(System.in);
    public static void Run()
    {
        System.out.println("Informe a primeira nota:");
        double grade1 = scanner.nextDouble();

        System.out.println("Informe a segunda nota:");
        double grade2 = scanner.nextDouble();

        System.out.println("Informe a terceira nota:");
        double grade3 = scanner.nextDouble();

        System.out.println("Informe a quarta nota:");
        double grade4 = scanner.nextDouble();

        double result = (grade1 + grade2 + grade3 + grade4) / 4;

        if (result >= 7) System.out.println("Aluno aprovado");
        else {
            System.out.println("Mèdia:" + result);

            System.out.println("Informe o valor do exame:");
            double gradeExam = scanner.nextDouble();

            result = (result + gradeExam) / 2;

            System.out.println("Nova média: " + result);

            if (result >= 7) System.out.println("Aluno aprovado");
            else System.out.println("Aluno reprovado");
        }
    }
}

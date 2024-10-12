import java.util.Scanner;
import exercises.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("Escolha um exercício (1 a 7):");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ex1.Run();
                    break;
                case 2:
                    ex2.Run();
                    break;
                case 3:
                    ex3.Run();
                    break;
                case 4:
                    ex4.Run();
                    break;
                case 5:
                    ex5.Run();
                    break;
                case 6:
                    ex6.Run();
                    break;
                case 7:
                    ex7.Run();
                    break;
                default:
                    System.out.println("Exercício inexistente.");
                    break;
            }
        }
    }
}
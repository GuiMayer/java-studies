import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static <T> T ReadValue(Class<T> type) {
        if (type == String.class) {
            System.out.println("Digite uma frase:");
            return type.cast(scanner.nextLine());
        } else if (type == Integer.class) {
            System.out.println("Digite um número inteiro:");
            return type.cast(scanner.nextInt());
        } else if (type == Double.class) {
            System.out.println("Digite um número double:");
            return type.cast(scanner.nextDouble());
        } else if (type == Boolean.class) {
            System.out.println("Digite um valor booleano:");
            return type.cast(scanner.nextBoolean());
        } else if (type == Float.class) {
            System.out.println("Digite um valor de ponto flutuante:");
            return type.cast(scanner.nextFloat());
        } else if (type == Long.class) {
            System.out.println("Digite um número long:");
            return type.cast(scanner.nextLong());
        } else if (type == Short.class) {
            System.out.println("Digite um número short:");
            return type.cast(scanner.nextShort());
        } else if (type == Byte.class) {
            System.out.println("Digite um número byte:");
            return type.cast(scanner.nextByte());
        }
        return null;
    }
    public static <T> T ReadValue(Class<T> type, String frase) {
        if (type == String.class) {
            System.out.println(frase);
            return type.cast(scanner.nextLine());
        } else if (type == Integer.class) {
            System.out.println(frase);
            return type.cast(scanner.nextInt());
        } else if (type == Double.class) {
            System.out.println(frase);
            return type.cast(scanner.nextDouble());
        } else if (type == Boolean.class) {
            System.out.println(frase);
            return type.cast(scanner.nextBoolean());
        } else if (type == Float.class) {
            System.out.println(frase);
            return type.cast(scanner.nextFloat());
        } else if (type == Long.class) {
            System.out.println(frase);
            return type.cast(scanner.nextLong());
        } else if (type == Short.class) {
            System.out.println(frase);
            return type.cast(scanner.nextShort());
        } else if (type == Byte.class) {
            System.out.println(frase);
            return type.cast(scanner.nextByte());
        }
        return null;
    }

    public static String removeCharAt(String str, int index) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.deleteCharAt(index); // Remove o caractere no índice especificado
        return stringBuilder.toString(); // Converte de volta para String
    }
}

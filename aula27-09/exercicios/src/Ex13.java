public class Ex13 {
    public static void main(String[] args) {
        String frase = Utils.ReadValue(String.class);
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.print(frase.charAt(i));
        }
    }
}

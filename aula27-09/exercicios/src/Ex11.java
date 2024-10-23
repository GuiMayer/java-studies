public class Ex11 {
    public static void main(String[] args) {
        String frase = Utils.ReadValue(String.class);

        System.out.println("Caracteres: " + frase.length() + ", Palavras: " + frase.split("[,.\\s]").length);
    }
}

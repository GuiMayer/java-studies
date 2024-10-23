public class Ex15 {
    public static void main(String[] args) {
        String frase = Utils.ReadValue(String.class);
        String fraseLimpa = frase.replaceAll("[^\\p{L} ]", "");
        System.out.println(fraseLimpa);
    }
}

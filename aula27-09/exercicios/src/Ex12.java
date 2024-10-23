public class Ex12 {
    public static void main(String[] args) {
        String frase = Utils.ReadValue(String.class);

        String fraseLimpa = frase.toLowerCase().replaceAll("[^a-zA-Z]", "");
        if (fraseLimpa.length() % 2 != 0) {
            fraseLimpa = Utils.removeCharAt(fraseLimpa, (int)Math.floor((double)fraseLimpa.length()/2));
        }

        boolean isPalindromo = true;
        for (int i = 0; i < (fraseLimpa.length() / 2); i++) {
            if (fraseLimpa.charAt(i) == fraseLimpa.charAt(fraseLimpa.length() - i - 1) && isPalindromo) {
                isPalindromo = true;
            } else {
                isPalindromo = false;
            }
        }

        if (isPalindromo) {
            System.out.println("É palindromo");
        } else {
            System.out.println("Não é palindromo");
        }
    }
}

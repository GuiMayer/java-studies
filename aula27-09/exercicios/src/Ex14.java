public class Ex14 {
    public static void main(String[] args) {
        int vogais = 0, consoantes = 0;
        String frase = Utils.ReadValue(String.class);
        for (char c : frase.toCharArray()) {
            if (c == 'a' || c == 'á' || c == 'à' || c == 'ã' || c == 'â' ||
                    c == 'e' || c == 'é' || c == 'è' || c == 'ê' ||
                    c == 'i' || c == 'í' || c == 'ì' || c == 'î' ||
                    c == 'o' || c == 'ó' || c == 'ò' || c == 'õ' || c == 'ô' ||
                    c == 'u' || c == 'ú' || c == 'ù' || c == 'û') {
                vogais++;
            } else if (Character.isLetter(c)) {
                consoantes++;
            }
        }
        System.out.println("Vogais: " + vogais);
        System.out.println("Consoantes: " + consoantes);
    }
}

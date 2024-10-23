public class Ex17 {
    public static void main(String[] args) {
        int contador = 0;
        int numeroOcorrencias = 0;
        String frase = Utils.ReadValue(String.class);
        String subFrase = Utils.ReadValue(String.class, "Digite um subfrase:");

        if (frase.contains(subFrase)) {
            for (int i = 0; i < frase.length() - subFrase.length() + 1; i++) {
                for (int j = 0; j < subFrase.length(); j++) {
                    if (frase.charAt(i + j) == subFrase.charAt(j)) {
                        contador++;

                        if (contador == subFrase.length()) {
                            numeroOcorrencias++;
                            contador = 0;
                        }
                    } else {
                        contador = 0;
                    }
                }
            }
        }
        System.out.println("Número de ocorrências: " + numeroOcorrencias);
    }
}

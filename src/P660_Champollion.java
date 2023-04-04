import java.util.ArrayList;

public class P660_Champollion {

    static java.util.Scanner in;

    public static void casoDePrueba() {

        in.nextLine();
        String frase = in.nextLine().toLowerCase();

        String[] palabras = frase.split(" ");


    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }

    public void procesarPalabra(String palabra, ArrayList<String> silabas) {
        char[] caracteres = palabra.toCharArray();
        for (int i = 0; i < caracteres.length; ) {

            if (i == 0 && esVocal(palabra.charAt(0))) {
                silabas.add(Character.toString(palabra.charAt(0)));
                i++;
            }


        }
    }

    public boolean esVocal(char c) {
        String vocales = "aeiou";
        return vocales.contains(Character.toString(c));
    }
}

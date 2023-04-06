import java.util.HashSet;

public class P660_Champollion {

    static java.util.Scanner in;

    public static void casoDePrueba() {

        String[] palabras = in.nextLine().toLowerCase().split(" ");
        HashSet<String> silabas = new HashSet<>();
        for (String str : palabras) {
            procesarPalabra(str, silabas);
        }
        System.out.println(silabas.size());
    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }

    public static void procesarPalabra(String palabra, HashSet<String> silabas) {
        char[] caracteres = palabra.toCharArray();
        int letrasRestantes = caracteres.length;
        int p = 0;
        if (esVocal(caracteres[0])){
            silabas.add(String.valueOf(caracteres[0]));
            p++;
            letrasRestantes--;
        }
        while(letrasRestantes > 0){
            if (letrasRestantes == 3){
                silabas.add(String.valueOf(caracteres[p]) + caracteres[p + 1] + caracteres[p + 2]);
                break;
            }else if (letrasRestantes == 2){
                silabas.add(String.valueOf(caracteres[p]) + caracteres[p + 1]);
                break;
            }else {
                if (!esVocal(caracteres[p+2]) && !esVocal(caracteres[p+3])){
                    silabas.add(String.valueOf(caracteres[p]) + caracteres[p + 1] + caracteres[p + 2]);
                    letrasRestantes -= 3;
                    p +=3;
                }else {
                    silabas.add(String.valueOf(caracteres[p]) + caracteres[p + 1]);
                    letrasRestantes -= 2;
                    p +=2;
                }
            }
        }
    }

    public static boolean esVocal(char c) {
        return c=='a' || c=='e'|| c=='i' || c=='o' || c=='u';
    }
}

package calentamientoNavidad2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P617_SpaceInvaders {
    static BufferedReader in;

    public static void casoDePrueba() throws IOException {
        int puntuaciones = Integer.parseInt(in.readLine());
        char[] frase = new char[puntuaciones*3];
        for (int i = 0; i < puntuaciones; i++) {
            char[] aux = in.readLine().toCharArray();
            frase[i] = aux[0];
            frase[i + puntuaciones] = aux[1];
            frase[i + puntuaciones*2] = aux[2];
        }
        System.out.println(frase);
    }

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}


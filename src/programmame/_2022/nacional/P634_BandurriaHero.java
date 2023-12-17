package programmame._2022.nacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P634_BandurriaHero {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            String pulsaciones = in.readLine();
            int multiplicador = 1;
            int suma = 0;
            for (int j = 0; j < pulsaciones.length(); j++) {
                if (pulsaciones.charAt(j) == 'O'){
                    suma += 10 * multiplicador;
                    multiplicador++;
                }else {
                    multiplicador = 1;
                }
            }
            System.out.println(suma);
        }
    }
}

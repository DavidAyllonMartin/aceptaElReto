package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P710_PlazasDisponiblesEnElMundial {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());

        for (int i = 0; i < numCasos; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int plazas = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < 6; j++) {
                plazas -= Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(plazas);
        }
    }
}

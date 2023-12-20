package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P710_PlazasDisponiblesEnElMundial {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            String[] arr = in.readLine().split(" ");
            int plazas = Integer.parseInt(arr[0]);
            for (int j = 1; j < 7; j++) {
                plazas -= Integer.parseInt(arr[j]);
            }
            System.out.println(plazas);
        }
    }
}

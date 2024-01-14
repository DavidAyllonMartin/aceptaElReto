package las12uvas._2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P716_EnchufandoLasLucesDeNavidad {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numeroRegletas = Integer.parseInt(in.readLine());
        while (numeroRegletas != 0){
            int suma = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < numeroRegletas; i++) {
                suma += Integer.parseInt(st.nextToken());
            }
            suma -= numeroRegletas - 1;
            System.out.println(suma);

            numeroRegletas = Integer.parseInt(in.readLine());
        }
    }
}

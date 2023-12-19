package programmame._2022.nacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P638_FamiliaNumerosa {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());

        for (int i = 0; i < numCasos; i++) {
            String[] numeros = in.readLine().split(" ");
            int comensales = Integer.parseInt(numeros[0]);
            int albondigasRestantes = Integer.parseInt(numeros[1]);
            int albondigasTotales = albondigasRestantes / (comensales - 1) + albondigasRestantes;

            if (albondigasRestantes % (comensales - 1) == 0){

                System.out.println(albondigasTotales -1 + " " + albondigasTotales);
            }else {
                System.out.println(albondigasTotales + " " + albondigasTotales);
            }
        }
    }
}

package las12uvas._2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P717_311223 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            boolean esDivertido = false;
            String[] numeros = in.readLine().split(" ");
            String[] posibilidades = new String[6];
            posibilidades[0] = numeros[0] + numeros[1] + numeros[2];
            posibilidades[1] = numeros[0] + numeros[2] + numeros[1];
            posibilidades[2] = numeros[1] + numeros[0] + numeros[2];
            posibilidades[3] = numeros[1] + numeros[2] + numeros[0];
            posibilidades[4] = numeros[2] + numeros[1] + numeros[0];
            posibilidades[5] = numeros[2] + numeros[0] + numeros[1];

            for (String str : posibilidades){
                if (str.substring(0,3).equals(str.substring(3,6))){
                    esDivertido = true;
                    break;
                }
            }

            if (esDivertido){
                System.out.println("DIVERTIDOS");
            }else{
                System.out.println("INSULSOS");
            }

        }
    }
}

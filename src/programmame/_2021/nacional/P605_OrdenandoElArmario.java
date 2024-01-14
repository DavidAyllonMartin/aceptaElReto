package programmame._2021.nacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P605_OrdenandoElArmario {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        while (!line.equals(".")){
            int verano = 0;
            int invierno = 0;
            char[] chars = line.toCharArray();
            for (char c : chars){
                if (c == 'V'){
                    verano++;
                } else if (c == 'I') {
                    invierno++;
                }
            }

            if (verano > invierno){
                System.out.println("VERANO");
            } else if (invierno > verano) {
                System.out.println("INVIERNO");
            }else {
                System.out.println("EMPATE");
            }

            line = in.readLine();
        }
    }
}

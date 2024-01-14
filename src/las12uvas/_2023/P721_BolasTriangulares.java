package las12uvas._2023;

import java.util.Scanner;

public class P721_BolasTriangulares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++) {
            int bolasDeseadas = in.nextInt();
            int bolasCompradas = 0;
            int tamanioPaquete = 0;
            int paquetes = 0;
            for (int j = 1; j < 2000000; j++) {
                tamanioPaquete += j;
                bolasCompradas += tamanioPaquete;
                if (bolasCompradas <= bolasDeseadas){
                    paquetes++;
                }else {
                    break;
                }
            }
            System.out.println(paquetes);
        }
    }
}

package programmame._2023.regional.madrid;

import java.util.Arrays;
import java.util.Scanner;

public class P681_LaEscaleraDeAlba {
    static Scanner in;

    public static boolean casoDePrueba(){
        if (!in.hasNext()){
            return false;
        }else {
            int numeroColores = in.nextInt();
            int[] piezas = new int[numeroColores];
            for (int i = 0; i < numeroColores; i++) {
                piezas[i] = in.nextInt();
            }
            Arrays.sort(piezas);
            long suma = 0;
            int maxPiezasPosibles = piezas[piezas.length-1];
            for (int i = numeroColores - 1; i >= 0; i--) {
                int piezasNivel = Math.min(piezas[i], maxPiezasPosibles);
                suma += piezasNivel;
                maxPiezasPosibles = piezasNivel - 1;
                if (maxPiezasPosibles < 1){
                    break;
                }
            }
            System.out.println(suma);
            return true;
        }
    }

    public static void main(String[] args){
        in = new Scanner(System.in);

        while (casoDePrueba());
    }
}

package calentamientoNavidad2022;

// Esquema de la entrada: fin de la entrada
import java.util.*;

public class P620 {

    static Scanner in;

    public static boolean casoDePrueba() {

        if (in.hasNext())
            return false;
        else {
            int tamanioCara = in.nextInt();
            int[] tamanios = new int[in.nextInt()];
            int sumaTotal = 0;
            for (int i = 0; i < tamanios.length; i++) {
                tamanios[i] = in.nextInt();
                sumaTotal += tamanios[i];
            }

            Arrays.sort(tamanios);

            if (tamanios[tamanios.length - 1] > tamanioCara ){
                System.out.println("NO");
                return true;
            }else {
                int suma1 = 0;
                for (int i : tamanios){
                    suma1 += i;
                    if (suma1 > tamanioCara){
                        suma1 -= i;
                        break;
                    }
                }
                if (sumaTotal - suma1 > tamanioCara){
                    System.out.println("NO");
                }else {
                    System.out.println("SI");
                }
            }

            return true;
        }

    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        while(casoDePrueba()) ;

    } // main

} // class Solution

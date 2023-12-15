package calentamientoNavidad2022;

import java.util.Scanner;

public class P620_JuegosEnCintas {

    static Scanner in;

    public static void avanzarCombinatoria(boolean[] combinatoria, int pos) throws IndexOutOfBoundsException{
        if (combinatoria[pos]){
            combinatoria[pos] = false;
            avanzarCombinatoria(combinatoria, pos + 1);
        }else{
            combinatoria[pos] = true;
        }
    }

    public static int comprobarTamanio(int[] tamanios, boolean[] combinatoria){
        int suma = 0;
        for (int i = 0; i < tamanios.length; i++) {
            if (combinatoria[i]){
                suma += tamanios[i];
            }
        }
        return suma;
    }

    public static boolean casoDePrueba() {

        if (!in.hasNext())
            return false;
        else {
            int tamanioCara = in.nextInt();
            int numeroJuegos = in.nextInt();
            int[] tamanios = new int[numeroJuegos];
            boolean[] combinatoria = new boolean[numeroJuegos];
            int sumaTotal = 0;
            for (int i = 0; i < tamanios.length; i++) {
                tamanios[i] = in.nextInt();
                sumaTotal += tamanios[i];
            }

            try {
                while (true){
                    int caraA = comprobarTamanio(tamanios, combinatoria);
                    if ( caraA <= tamanioCara && (sumaTotal - caraA) <= tamanioCara){
                        System.out.println("SI");
                        return true;
                    }
                    avanzarCombinatoria(combinatoria, 0);
                }
            }catch (IndexOutOfBoundsException ignored){
            }
            System.out.println("NO");
            return true;
        }
    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        while(casoDePrueba()) ;

    }
}

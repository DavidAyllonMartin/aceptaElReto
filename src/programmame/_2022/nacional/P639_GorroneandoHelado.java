package programmame._2022.nacional;

import java.util.Arrays;
import java.util.Scanner;

public class P639_GorroneandoHelado {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int porciones = in.nextInt();
            int suma = 0;
            int[] frutosRojos = new int[porciones];
            for (int i = 0; i < porciones; i++) {
                frutosRojos[i] = in.nextInt();
                suma += frutosRojos[i];
            }

            int diferencia = getDiferencia(porciones, suma, frutosRojos);

            System.out.println(diferencia);
        }
    }
    private static int getDiferencia(int porciones, int suma, int[] frutosRojos) {
        int cantidadIzquierda = frutosRojos[0];
        int indiceIzq = 1;
        int cantidadDerecha = frutosRojos[porciones - 1];
        int indiceDer = porciones - 2;
        int cantidadCentro = suma - cantidadDerecha - cantidadIzquierda;
        int diferencia = calcularDiferenciaFrutos(cantidadDerecha, cantidadIzquierda, cantidadCentro);

        while (cantidadCentro > 0){
            int cantidadDerechaVirtual = cantidadDerecha + frutosRojos[indiceDer];
            int cantidadIzquierdaVirtual = cantidadIzquierda + frutosRojos[indiceIzq];
            int diferenciaVirtual1 = calcularDiferenciaFrutos(cantidadIzquierdaVirtual, cantidadCentro - frutosRojos[indiceIzq], cantidadDerecha);
            int diferenciaVirtual2 = calcularDiferenciaFrutos(cantidadDerechaVirtual, cantidadCentro - frutosRojos[indiceDer], cantidadIzquierda);
            diferencia = Math.min(diferencia, Math.min(diferenciaVirtual1, diferenciaVirtual2));

            if (cantidadIzquierdaVirtual < cantidadDerechaVirtual){
                cantidadIzquierda = cantidadIzquierdaVirtual;
                cantidadCentro -= frutosRojos[indiceIzq];
                indiceIzq++;
            }else {
                cantidadDerecha = cantidadDerechaVirtual;
                cantidadCentro -= frutosRojos[indiceDer];
                indiceDer--;
            }
        }
        return diferencia;
    }

    private static int calcularDiferenciaFrutos(int cantidadDerecha, int cantidadIzquierda, int cantidadCentro) {
        int[] array = new int[3];
        array[0] = cantidadDerecha;
        array[1] = cantidadCentro;
        array[2] = cantidadIzquierda;

        Arrays.sort(array);
        return array[2] - array[0];
    }
}

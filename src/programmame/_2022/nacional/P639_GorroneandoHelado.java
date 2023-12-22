package programmame._2022.nacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P639_GorroneandoHelado {
    public static int[] dividirEnDos(int[] numeros, int pos, int suma){
        int[] sumas = new int[2];
        sumas[1] = suma;

        while (sumas[1] > sumas[0]){
            sumas[0] += numeros[pos];
            sumas[1] -= numeros[pos];
            pos++;
        }
        if (sumas[0] != sumas[1]){
            int diferencia = sumas[0] - sumas[1];
            int num = numeros[pos - 1];
            int izquierdaAnterior = sumas[0] - num;
            int derechaAnterior = sumas[1] + num;
            if (derechaAnterior - izquierdaAnterior < diferencia){
                sumas[0] = izquierdaAnterior;
                sumas[1] = derechaAnterior;
            }
        }
        return sumas;
    }

    public static int calcularMinimaDiferencia(int num1, int num2, int num3){
        return Math.max(num1, Math.max(num2, num3)) - Math.min(num1, Math.min(num2, num3));
    }


    /*public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        while (line != null){
            int porciones = Integer.parseInt(line);
            int[] frutosRojos = new int[porciones];
            StringTokenizer st = new StringTokenizer(in.readLine());
            int sumaTotal = 0;
            for (int i = 0; i < porciones; i++) {
                frutosRojos[i] = Integer.parseInt(st.nextToken());
                sumaTotal += frutosRojos[i];
            }
            int pos = 0;
            double tercio = sumaTotal / 3.0;
            int suma = 0;
            while (suma < tercio){
                suma += frutosRojos[pos];
                pos++;
            }

            int[] aux = dividirEnDos(frutosRojos, pos, sumaTotal - suma);
            int diferencia1 = calcularMinimaDiferencia(suma, aux[0], aux[1]);
            pos--;
            if (pos == 0){
                System.out.println(diferencia1);
            }else {
                suma -= frutosRojos[pos];
                aux = dividirEnDos(frutosRojos, pos, sumaTotal - suma);
                int diferencia2 = calcularMinimaDiferencia(suma, aux[0], aux[1]);

                System.out.println(Math.min(diferencia1, diferencia2));
            }

            line = in.readLine();
        }
    }*/

    public static void main(String[] args) {

    }

    public static int diferenciaPropia(int[] frutosRojos, int sumaTotal) throws IOException {
            int porciones = frutosRojos.length;

            int pos = 0;
            double tercio = sumaTotal / 3.0;
            int suma = 0;
            while (suma < tercio){
                suma += frutosRojos[pos];
                pos++;
            }

            int[] aux = dividirEnDos(frutosRojos, pos, sumaTotal - suma);
            int diferencia1 = calcularMinimaDiferencia(suma, aux[0], aux[1]);
            pos--;
            if (pos == 0){
                return diferencia1;
            }else {
                suma -= frutosRojos[pos];
                aux = dividirEnDos(frutosRojos, pos, sumaTotal - suma);
                int diferencia2 = calcularMinimaDiferencia(suma, aux[0], aux[1]);

                return Math.min(diferencia1, diferencia2);
            }
        }












    static int getMinDiffOfThreeNums(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    public static int externa(int[] arr, int sum) {


            int n = arr.length;
            int a = arr[0];
            int c = arr[n - 1];
            int b = sum - (a + c);
            int currentMinDiff = getMinDiffOfThreeNums(a, b, c);

            int left = 1, right = n - 2;
            while (left < right) {
                int newA = a + arr[left];
                int newC = c + arr[right];

                if (newA < newC) {
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(newA, b - arr[left], c));
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(a, b - arr[right], newC));
                    a = newA;
                    b -= arr[left++];
                } else {
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(a, b - arr[right], newC));
                    currentMinDiff = Math.min(currentMinDiff, getMinDiffOfThreeNums(newA, b - arr[left], c));
                    c = newC;
                    b -= arr[right--];
                }
            }

            return currentMinDiff;
        }

    }

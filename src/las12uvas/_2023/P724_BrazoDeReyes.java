package las12uvas._2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P724_BrazoDeReyes {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int porciones = Integer.parseInt(in.readLine());
        while (porciones != 0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] alturas = new int[porciones];
            for (int i = 0; i < porciones; i++) {
                alturas[i] = Integer.parseInt(st.nextToken());
            }

            int altura = buscarAltura(alturas);
            System.out.println(altura);

            porciones = Integer.parseInt(in.readLine());
        }
    }

    public static long calcularDiferencia(int[] alturas, int altura){
        long sumaInferior = 0;
        long sumaSuperior = 0;
        for (int i : alturas){
            if (i >= altura){
                sumaInferior += altura;
                sumaSuperior += i - altura;
            }else {
                sumaInferior += i;
            }
        }
        return sumaInferior - sumaSuperior;
    }

    public static int buscarAltura(int[] alturas) {
        int menor = 0;
        int mayor = 1000000000;

        while (menor < mayor) {
            int mitad = menor + (mayor - menor) / 2;
            long diferencia = calcularDiferencia(alturas, mitad);

            if (diferencia < 0) {
                menor = mitad + 1;
            } else {
                mayor = mitad;
            }
        }
        return menor;
    }
}

package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P711_VerificacionDeLasEntradas {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(in.readLine());
        for (int i = 0; i < casos; i++) {
            char[] charArray = in.readLine().toCharArray();
            int[] numero = new int[charArray.length];
            for (int j = 0; j < charArray.length; j++) {
                numero[j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
            int pos = saltarCerosIniciales(numero);
            int maxIzq = numero[pos];
            int minDer = 0;
            try {
                minDer = minNumero(numero, pos + 1);
            }catch (IndexOutOfBoundsException e){

            }
            int codigoValidacion = 0;
            for (int j = pos; j < numero.length; j++) {
                int digito = numero[j];
                if (minDer == digito){
                    try {
                        minDer = minNumero(numero, j + 1);
                    }catch (IndexOutOfBoundsException e){

                    }
                }
                if (j % 2 == 0){
                    codigoValidacion += digito * 3 + minDer;
                }else{
                    codigoValidacion += digito * 2 + maxIzq;
                }
                maxIzq = Math.max(maxIzq, digito);
            }
            System.out.println(codigoValidacion);
        }
    }

    public static int saltarCerosIniciales(int[] numero) {
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] != 0){
                return i;
            }
        }
        return 0;
    }

    public static int minNumero(int[] digitos, int pos){
        int minNumero = 9;
        for (int i = pos; i < digitos.length; i++) {
            int digito = digitos[i];
            if (digito == 0){
                return 0;
            }
            minNumero = Math.min(minNumero, digito);
        }
        return minNumero;
    }
}

package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P712 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numEventos = Integer.parseInt(in.readLine());
        int[] tiempos = new int[numEventos];
        for (int i = 0; i < numEventos; i++) {
            String[] arr = in.readLine().split(" ");
            tiempos[i] = Integer.parseInt(arr[0]);
        }

        int numConsultas = Integer.parseInt(in.readLine());
        for (int i = 0; i < numConsultas; i++) {
            int posI = 0;
            int posF = 0;
            int diferencia = Integer.MAX_VALUE;
            int cantidadEventos = 0;
            int rango = Integer.parseInt(in.readLine());
            rango--;
            for (int j = 0; j < tiempos.length - rango; j++) {
                int diferenciaTemporal = tiempos[j + rango] - tiempos[j];
                if (diferenciaTemporal < diferencia){
                    posI = j;
                    posF = j+rango;
                    diferencia = diferenciaTemporal;
                    cantidadEventos = calcularEventos(tiempos, j, j + rango);
                }else if (diferenciaTemporal == diferencia){
                    int cantidadEventosTemporal = calcularEventos(tiempos, j, j + rango);
                    if (cantidadEventosTemporal > cantidadEventos){
                        posI = j;
                        posF = j+rango;
                        cantidadEventos = cantidadEventosTemporal;
                    }
                }
            }
            System.out.println(tiempos[posI] + " " + tiempos[posF] + " " + cantidadEventos);
        }
    }

    public static int calcularEventos(int[] tiempos, int posI, int posF){
        int tiempoPosI = tiempos[posI];
        int tiempoPosF = tiempos[posF];
        while (true){
            try {
                if (tiempoPosF == tiempos[posF + 1]){
                    posF++;
                }else{
                    break;
                }
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
        while (true){
            try {
                if (tiempoPosI == tiempos[posI - 1]){
                    posI--;
                }else {
                    break;
                }
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return posF-posI + 1;
    }
}

package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P712_EventosDeLosPartidos {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        while (str != null){
            int numEventos = Integer.parseInt(str);
            int[] tiempos = new int[numEventos];
            for (int i = 0; i < numEventos; i++) {
                String[] arr = in.readLine().split(" ");
                tiempos[i] = Integer.parseInt(arr[0]);
            }

            /*int numEventos = 400000;
            int[] tiempos = new int[numEventos];
            Arrays.fill(tiempos, 1000);*/

            int numConsultas = Integer.parseInt(in.readLine());
            for (int i = 0; i < numConsultas; i++) {
                int posI = 0;
                int posF = numEventos - 1;
                int diferencia = tiempos[posF] - tiempos[posI];
                int cantidadEventos = numEventos;
                int rango = Integer.parseInt(in.readLine());
                rango--;
                for (int j = 0; j < numEventos - rango; j++) {
                    int diferenciaTemporal = tiempos[j + rango] - tiempos[j];
                    if (diferenciaTemporal < diferencia){
                        posI = j;
                        posF = j+rango;
                        diferencia = diferenciaTemporal;
                        cantidadEventos = calcularEventos(tiempos, j, j + rango);
                    }else if (diferenciaTemporal == diferencia && j+1<numEventos && tiempos[j] != tiempos[j+1]){
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
            System.out.println("---");
            str = in.readLine();
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
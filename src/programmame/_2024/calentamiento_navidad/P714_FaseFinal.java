package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P714_FaseFinal {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int numEquipos = Integer.parseInt(in.readLine());
            while (numEquipos != 0) {
                ArrayList<String> equipos = obtenerEquipos(in, numEquipos);

                String[] resultados = in.readLine().split(" ");
                String ganador = realizarPartidos(equipos, resultados);

                System.out.println(ganador);

                numEquipos = Integer.parseInt(in.readLine());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> obtenerEquipos(BufferedReader in, int numEquipos) throws IOException {
        ArrayList<String> equipos = new ArrayList<>(numEquipos);
        while (numEquipos > 0) {
            String[] strings = in.readLine().split(" ");
            int tamano = strings.length;
            numEquipos -= tamano;
            equipos.addAll(Arrays.asList(strings));
        }
        return equipos;
    }

    private static String realizarPartidos(ArrayList<String> equipos, String[] resultados) {
        int posResultados = 0;
        int posEquipos = 0;
        int numPartidos = equipos.size() / 2;

        while (equipos.size() > 1) {
            for (int i = 0; i < numPartidos; i++) {
                int golesEquipo1 = Integer.parseInt(resultados[posResultados++]);
                int golesEquipo2 = Integer.parseInt(resultados[posResultados++]);

                if (golesEquipo1 > golesEquipo2) {
                    equipos.remove(posEquipos + 1);
                } else {
                    equipos.remove(posEquipos);
                }
                posEquipos++;
            }
            numPartidos /= 2;
            posEquipos = 0;
        }
        return equipos.get(0);
    }
}

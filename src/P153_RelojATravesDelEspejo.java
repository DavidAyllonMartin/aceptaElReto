import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P153_RelojATravesDelEspejo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            String[] strings = in.readLine().split(":");
            int horas = Integer.parseInt(strings[0]);
            int minutos = Integer.parseInt(strings[1]);
            if (minutos == 0){
                if (horas == 12){
                    System.out.println(horaFormateada(horas, minutos));
                }else{
                    System.out.println(horaFormateada(12 - horas, minutos));
                }
            }else{
                if (horas == 12){
                    System.out.println(horaFormateada(11, 60 - minutos));
                }else if (horas == 11){
                    System.out.println(horaFormateada(12, 60 - minutos));
                }else {
                    System.out.println(horaFormateada(11 - horas, 60 - minutos));
                }
            }
        }
    }

    private static String horaFormateada(int hora, int minutos){
        String horaStr;
        String minutoStr;
        if (hora < 10){
            horaStr = "0" + hora;
        }else{
            horaStr = String.valueOf(hora);
        }

        if (minutos < 10){
            minutoStr = "0" + minutos;
        }else {
            minutoStr = String.valueOf(minutos);
        }

        return horaStr + ":" + minutoStr;
    }
}

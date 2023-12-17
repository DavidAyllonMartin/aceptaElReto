package programmame._2023.regional.madrid;

import java.util.Scanner;

public class P680_LaCarreraDelSalmon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++) {
            int longitud = in.nextInt();
            int avance = in.nextInt();
            int retroceso = in.nextInt();

            if (avance >= longitud){
                System.out.println("1");
            } else if (avance <= retroceso) {
                System.out.println("IMPOSIBLE");
            }else{
                int ciclos = 0;
                while (true){
                    ciclos++;
                    longitud -= avance;
                    if (longitud <= 0){
                        System.out.println(ciclos);
                        break;
                    }
                    longitud += retroceso;
                }
            }
        }
    }
}

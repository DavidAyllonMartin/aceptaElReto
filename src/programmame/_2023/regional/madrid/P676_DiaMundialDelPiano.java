package programmame._2023.regional.madrid;

import java.util.Scanner;

public class P676_DiaMundialDelPiano {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        for (int i = 0; i < casos; i++) {
            int anio1 = in.nextInt();
            int anio2 = in.nextInt();
            int aniosBisiestos = 0;
            for (int j = anio1; j <= anio2; j++) {
                if (esBisiesto(j)) {
                    aniosBisiestos++;
                }
            }
            System.out.println((anio2 - anio1 - aniosBisiestos + 1) + " " + aniosBisiestos);
        }
    }
    public static boolean esBisiesto(int anio) {
        return (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0));
    }
}

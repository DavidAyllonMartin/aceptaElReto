package programmame._2023.regional.madrid;

import java.util.Scanner;

public class P682_MetidosEnUnCajon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++) {
            int patos = in.nextInt();
            System.out.println(patos + " " + patos * 2);
        }
    }
}

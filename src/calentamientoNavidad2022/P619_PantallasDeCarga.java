package calentamientoNavidad2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P619_PantallasDeCarga {
    static BufferedReader in;

    public static boolean casoDePrueba() throws IOException {

        String[] strings = in.readLine().split(" ");
        int ancho = Integer.parseInt(strings[0]);
        int alto = Integer.parseInt(strings[1]);

        if (alto == 0 || ancho == 0)
            return false;
        else {
            char[][] imagen = new char[alto][ancho];
            for (int i = 0; i < alto; i++) {
                imagen[i] = in.readLine().toCharArray();
            }

            HashSet<Character> pixeles = new HashSet<>();
            for (int i = 0; i < alto / 8; i++) {
                for (int j = 0; j < ancho / 8; j++) {
                    for (int k = (i * 8); k < 8 + (i*8); k++) {
                        for (int l = (j * 8); l < 8+(j*8); l++) {
                            pixeles.add(imagen[k][l]);
                        }
                    }
                    if (pixeles.size() > 2){
                        System.out.println("NO");
                        return true;
                    }else{
                        pixeles.clear();
                    }

                }
            }
            System.out.println("SI");
            return true;
        }
    }

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));

        while(casoDePrueba());

    }
}
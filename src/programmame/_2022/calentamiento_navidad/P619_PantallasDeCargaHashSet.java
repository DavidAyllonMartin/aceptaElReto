package programmame._2022.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P619_PantallasDeCargaHashSet {
    static BufferedReader in;

    public static boolean casoDePrueba() throws IOException {

        String[] strings = in.readLine().split(" ");
        int ancho = Integer.parseInt(strings[0]);
        int alto = Integer.parseInt(strings[1]);

        if (alto == 0 || ancho == 0)
        return false;
        else {
            HashSet[] hashSets = new HashSet[ancho / 8];
            for (int i = 0; i < ancho / 8; i++) {
                hashSets[i] = new HashSet<Character>();
            }
            for (int i = 0; i < alto / 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char[] pixeles = in.readLine().toCharArray();
                    int pos = 0;
                    for (int k = 0; k < pixeles.length; k++) {
                        hashSets[pos].add(pixeles[k]);
                        if ((k+1)%8 == 0){
                            pos++;
                        }
                    }
                }
                for (HashSet hashSet : hashSets){
                    if (hashSet.size() > 2){
                        System.out.println("NO");
                        return true;
                    }
                    hashSet.clear();
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

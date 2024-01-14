package las12uvas._2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class P719_1260Dias {
    public static void main(String[] args) throws IOException {

        LinkedList<Integer> diasMes = new LinkedList<>();
        HashSet<Integer> combinaciones = new HashSet<>();

        diasMes.add(31);
        diasMes.add(28);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(28);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(28);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(29);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);
        diasMes.add(30);
        diasMes.add(31);

        for (int i = 0; i < 48; i++) {
            int suma = 0;
            for (int j : diasMes){
                suma += j;
                combinaciones.add(suma);
            }
            diasMes.addLast(diasMes.pollFirst());
        }
        combinaciones.add(0);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int dias = Integer.parseInt(in.readLine());
        while (dias != 0){
            if (combinaciones.contains(dias % 1461)){
                System.out.println("SI");
            }else {
                System.out.println("NO");
            }
            dias = Integer.parseInt(in.readLine());
        }
    }
}
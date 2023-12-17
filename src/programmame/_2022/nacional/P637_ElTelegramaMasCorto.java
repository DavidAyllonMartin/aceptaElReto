package programmame._2022.nacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P637_ElTelegramaMasCorto {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> letras = new HashMap<>();
        letras.put('A', 5);
        letras.put('B', 9);
        letras.put('C', 11);
        letras.put('D', 7);
        letras.put('E', 1);
        letras.put('F', 9);
        letras.put('G', 9);
        letras.put('H', 7);
        letras.put('I', 3);
        letras.put('J', 13);
        letras.put('K', 9);
        letras.put('L', 9);
        letras.put('M', 7);
        letras.put('N', 5);
        letras.put('O', 11);
        letras.put('P', 11);
        letras.put('Q', 13);
        letras.put('R', 7);
        letras.put('S', 5);
        letras.put('T', 3);
        letras.put('U', 7);
        letras.put('V', 9);
        letras.put('W', 9);
        letras.put('X', 11);
        letras.put('Y', 13);
        letras.put('Z', 11);
        letras.put('!', 19);
        letras.put('?', 15);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            int suma = 0;
            String[] palabras = in.readLine().split(" ");
            suma += (palabras.length - 1) * 5;
            for (String palabra : palabras){
                char[] caracteres = palabra.toCharArray();
                suma += (caracteres.length - 1) * 3;
                for (char c : caracteres){
                    suma += letras.get(c);
                }
            }
            System.out.println(suma);
        }

    }
}

package programmame._2023.regional.madrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P678_ElVerdugo {

    static BufferedReader in;

    public static boolean casoDePrueba() throws IOException {

        char[] letrasOcultas = in.readLine().toCharArray();

        if (letrasOcultas[0] == '.')
        return false;
    else {
        int fallos = 0;
        HashSet<Character> usadas = new HashSet<>();
        HashSet<Character> ocultas = new HashSet<>();
        for (char c : letrasOcultas){
            ocultas.add(c);
        }
        char[] letras = in.readLine().toCharArray();
            for (char c : letras) {
                if (usadas.add(c)){
                    if (!ocultas.remove(c)){
                        fallos++;
                        if (fallos >= 7){
                            System.out.println("AHORCADO");
                            return true;
                        }
                    }else {
                        if (ocultas.isEmpty()){
                            System.out.println("SALVADO");
                            return true;
                        }
                    }
                }
            }
            System.out.println("COLGANDO");
            return true;
        }
    }

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));

        while(casoDePrueba())
            ;

    }

}


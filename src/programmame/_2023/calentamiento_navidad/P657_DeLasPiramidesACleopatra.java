package programmame._2023.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P657_DeLasPiramidesACleopatra {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int casos = Integer.parseInt(in.readLine());
        for (int i = 0; i < casos; i++) {
            String[] numeros = in.readLine().split(" ");
            int menor = Integer.parseInt(numeros[0]);
            int medio = Integer.parseInt(numeros[1]);
            int mayor = Integer.parseInt(numeros[2]);
            int distMenor = calcularDistancia(medio, menor);
            int distMayor = calcularDistancia(mayor, medio);
            if (distMenor < distMayor){
                System.out.println(menor);
            }else if (distMayor < distMenor){
                System.out.println(mayor);
            }else System.out.println("EMPATE");
        }
    }

    public static int calcularDistancia(int mayor, int menor){
        if (mayor * menor < 0){
            return mayor - menor - 1;
        }else {
            return mayor - menor;
        }
    }
}

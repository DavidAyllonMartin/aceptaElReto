package programmame._2022.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P618_BuscandoElNivel {
    static BufferedReader in;

    public static boolean casoDePrueba() throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        int numNiveles = Integer.parseInt(st.nextToken());
        if (numNiveles == 0) {
            return false;
        } else {
            int[] duracionNiveles = new int[numNiveles];
            for (int i = 0; i < numNiveles; i++) {
                duracionNiveles[i] = Integer.parseInt(st.nextToken());
            }
            int subconsultas = Integer.parseInt(in.readLine());
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < subconsultas; i++) {
                String[] tokens = in.readLine().split(" ");
                int nivelInicial = Integer.parseInt(tokens[0]);
                int nivelFinal = Integer.parseInt(tokens[1]);
                int suma = 0;
                if (nivelInicial < nivelFinal) {
                    for (int j = nivelInicial; j < nivelFinal - 1; j++) {
                        suma += duracionNiveles[j];
                    }
                } else {
                    for (int j = nivelInicial; j >= nivelFinal; j--) {
                        suma -= duracionNiveles[j - 1];
                    }
                }
                strb.append(suma).append("\n");
            }
            strb.append("---");
            System.out.println(strb);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));

        while (casoDePrueba());

    }
}

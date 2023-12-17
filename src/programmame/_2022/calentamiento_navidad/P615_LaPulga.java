package programmame._2022.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P615_LaPulga {
    static BufferedReader in;

    public static void casoDePrueba() throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        int paso = Integer.parseInt(st.nextToken());
        int factor = Integer.parseInt(st.nextToken());
        int tiempo = Integer.parseInt(st.nextToken());

        System.out.println(tiempo % (paso + 1) * factor);
    }

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}


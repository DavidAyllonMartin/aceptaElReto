package calentamientoNavidad2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P616_PicPocPong {
    static BufferedReader in;

    public static boolean casoDePrueba() throws IOException {
        boolean golDerecha = true;
        int marcadorA = 0;
        int marcadorB = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        int casos = Integer.parseInt(st.nextToken());
        if (casos == 0) {
            return false;
        } else {
            for (int i = 0; i < casos; i++) {
                String str = st.nextToken();
                golDerecha = str.equals("PIC") != golDerecha;
                if (str.equals("PONG!")) {
                    if (golDerecha) {
                        marcadorA++;
                    } else {
                        marcadorB++;
                    }
                }
            }
        }

        System.out.print(marcadorA + " " + marcadorB + "\n");

        return true;
    }

    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));

        while (casoDePrueba());

    }
}

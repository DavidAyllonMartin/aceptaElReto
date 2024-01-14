package las12uvas._2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P715_HaySuficientes {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            String[] strings = in.readLine().split(" ");
            int uvas = Integer.parseInt(strings[0]);
            int comensales = Integer.parseInt(strings[1]);
            if (uvas/comensales >= 12){
                System.out.println("SI");
            }else {
                System.out.println("NO");
            }
        }
    }
}

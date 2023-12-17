package programmame._2022.nacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P635_Cinquecento {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            String anio = in.readLine();
            if (Integer.parseInt(anio) <= 100){
                System.out.println(1);
            }else if (anio.endsWith("00")){
                System.out.println(anio.substring(0, anio.length()-2));
            }else {
                System.out.println(Integer.parseInt(anio.substring(0, anio.length()-2)) + 1);
            }
        }
    }
}

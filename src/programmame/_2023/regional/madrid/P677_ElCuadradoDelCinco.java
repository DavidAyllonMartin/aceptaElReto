package programmame._2023.regional.madrid;

import java.math.BigDecimal;
import java.util.Scanner;

public class P677_ElCuadradoDelCinco {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++) {
            long num = in.nextLong();
            BigDecimal bd = new BigDecimal(num).multiply(BigDecimal.valueOf(num));
            System.out.println(bd);
        }
    }
}

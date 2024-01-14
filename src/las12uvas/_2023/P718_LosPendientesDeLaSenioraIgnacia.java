package las12uvas._2023;

import java.util.HashSet;
import java.util.Scanner;

public class P718_LosPendientesDeLaSenioraIgnacia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numPendientes = in.nextInt();
        while (numPendientes != 0){
            int parejasDePendientes = 0;
            HashSet<Integer> parejas = new HashSet<>();
            for (int i = 0; i < numPendientes; i++) {
                int pendiente = in.nextInt();
                if (!parejas.add(pendiente)){
                    parejas.remove(pendiente);
                    parejasDePendientes++;
                }
            }
            System.out.println(parejasDePendientes);
            numPendientes = in.nextInt();
        }

    }
}

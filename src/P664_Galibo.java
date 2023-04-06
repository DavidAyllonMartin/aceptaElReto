import java.util.ArrayList;
import java.util.Collections;

public class P664_Galibo {

        static java.util.Scanner in;

        public static boolean casoDePrueba() {
            int numPuentes = in.nextInt();
            if (numPuentes == 0)
            return false;
        else {
            int alturaMaxima = 800;
            for (int i = 0; i < numPuentes; i++) {
                int numCarriles = in.nextInt();
                ArrayList<Integer> alturaCarriles = new ArrayList<>();
                for (int j = 0; j < numCarriles; j++) {
                    alturaCarriles.add(in.nextInt());
                }
                Collections.sort(alturaCarriles);
                if (alturaCarriles.get(numCarriles-1) < alturaMaxima)
                    alturaMaxima = alturaCarriles.get(numCarriles-1);
                alturaCarriles.clear();
            }
                System.out.println(alturaMaxima);
                return true;
            }
        }

        public static void main(String args[]) {
            in = new java.util.Scanner(System.in);
            while (casoDePrueba()) {
            }
        }

    }

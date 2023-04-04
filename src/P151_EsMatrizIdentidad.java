public class P151_EsMatrizIdentidad {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int dimensionMatriz;
        boolean matrizUnidad = true;
        dimensionMatriz = in.nextInt();
        if (dimensionMatriz == 0)
            return false;

        int[][] matriz = new int[dimensionMatriz][dimensionMatriz];
        for (int i = 0; i < dimensionMatriz; i++) {
            for (int j = 0; j < dimensionMatriz; j++) {
                matriz[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < dimensionMatriz; i++) {
            for (int j = 0; j < dimensionMatriz; j++) {
                if (i == j) {
                    if (matriz[i][j] != 1) {
                        matrizUnidad = false;
                        break;
                    }
                } else {
                    if (matriz[i][j] != 0) {
                        matrizUnidad = false;
                        break;
                    }
                }
            }
        }

        if (matrizUnidad) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
        return true;
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) ;

    }

}

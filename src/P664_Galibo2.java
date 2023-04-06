public class P664_Galibo2 {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        short numPuentes = in.nextShort();
        if (numPuentes == 0)
            return false;
        else {
            short alturaMaxima = 800;
            for (short i = 0; i < numPuentes; i++) {
                short numCarriles = in.nextShort();
                short alturaMaximaCarril = 0;
                for (short j = 0; j < numCarriles; j++) {
                    short alturaCarril = in.nextShort();
                    if (alturaCarril > alturaMaximaCarril)
                        alturaMaximaCarril = alturaCarril;
                }
                if (alturaMaximaCarril < alturaMaxima)
                    alturaMaxima = alturaMaximaCarril;
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


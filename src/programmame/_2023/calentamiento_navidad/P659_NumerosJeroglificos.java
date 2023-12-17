package programmame._2023.calentamiento_navidad;

public class P659_NumerosJeroglificos {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int numero = in.nextInt();
        if (numero == 0)
            return false;
        else {
            int divisor = 1000000;
            int[] descomposicion = new int[7];
            for (int i = 0; i < 7; i++) {
                descomposicion[i] = numero / divisor;
                numero = numero % divisor;
                divisor /= 10;
            }
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < descomposicion[0]; i++) {
                strb.append("H");
            }

            for (int i = 0; i < descomposicion[1]; i++) {
                strb.append("R");
            }

            for (int i = 0; i < descomposicion[2]; i++) {
                strb.append("D");
            }

            for (int i = 0; i < descomposicion[3]; i++) {
                strb.append("F");
            }

            for (int i = 0; i < descomposicion[4]; i++) {
                strb.append("C");
            }

            for (int i = 0; i < descomposicion[5]; i++) {
                strb.append("G");
            }

            for (int i = 0; i < descomposicion[6]; i++) {
                strb.append("T");
            }

            System.out.println(strb);

            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);

        while (casoDePrueba()) {
        }
    }
}

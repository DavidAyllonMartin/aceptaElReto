public class P168_LaPiezaPerdida {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {

        int numPiezas = in.nextInt();

        if (numPiezas == 0)
            return false;

        int suma = 0;
        for (int i = 0; i < numPiezas - 1; i++) {
            suma += in.nextInt();
        }

        System.out.println((numPiezas * (numPiezas + 1)) / 2 - suma);

        return true;

    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        while (casoDePrueba()) ;

    }
}

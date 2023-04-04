public class P636_DivisionExacta {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int a = in.nextInt();
        int b = in.nextInt();
        if (a == 0 && b == 0)
            return false;
        else {

            double resultado = a / b;
            String resultadoString = String.valueOf(resultado);

            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution
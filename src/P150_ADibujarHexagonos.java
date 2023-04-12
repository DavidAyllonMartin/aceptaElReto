public class P150_ADibujarHexagonos {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int longitud = in.nextInt();
        String str = in.nextLine().trim();
        if (longitud == 0 && str.equals("0"))
        return false;
        else {
            int filas = longitud * 2 - 1;
            int espaciosBlanco = longitud - 1;
            int caracteres = longitud;
            for (int i = 0; i < longitud; i++) {
                for (int j = 0; j < espaciosBlanco; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < caracteres; j++) {
                    System.out.print(str);
                }
                System.out.println();
                espaciosBlanco--;
                caracteres += 2;
            }
            espaciosBlanco += 2;
            caracteres -= 4;
            for (int i = longitud; i < filas ; i++) {
                for (int j = 0; j < espaciosBlanco; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < caracteres; j++) {
                    System.out.print(str);
                }
                System.out.println();
                espaciosBlanco++;
                caracteres -= 2;
            }
            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main
} // class solution

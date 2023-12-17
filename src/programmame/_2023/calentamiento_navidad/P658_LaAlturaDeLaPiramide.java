package programmame._2023.calentamiento_navidad;

public class P658_LaAlturaDeLaPiramide {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int bloques = in.nextInt();
        if (bloques == 0)
            return false;
        else {
            int altura = 1;
            int bloquesNecesarios = 1;
            while (bloques > bloquesNecesarios) {
                bloquesNecesarios += (1 + 2 * altura) * (1 + 2 * altura);
                altura++;
            }
            System.out.println(altura);
            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);

        while (casoDePrueba()) {
        }
    }
}

public class P663_ContandoDesdeElCero {

    static java.util.Scanner in;

    public static void casoDePrueba() {
        short s = in.nextShort();
        if (s > 0)
            System.out.println(s - 1);
        else
            System.out.println(s);
    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextShort();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}

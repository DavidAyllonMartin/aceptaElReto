import java.util.LinkedList;

public class P143_Tortitas {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int diametroTortita = in.nextInt();
        if (diametroTortita == -1)
        return false;
        else {
            LinkedList<Integer> pilaTortitas = new LinkedList<>();
            LinkedList<Integer> pilaAuxiliar = new LinkedList<>();
            do {
                pilaTortitas.addLast(diametroTortita);
                diametroTortita = in.nextInt();
            }while (diametroTortita != -1);
            int movimientos = in.nextInt();
            for (int i = 0; i < movimientos; i++) {
                int volteo = in.nextInt();
                for (int j = 0; j < volteo; j++) {
                    pilaAuxiliar.addLast(pilaTortitas.removeLast());
                }
                pilaTortitas.addAll(pilaAuxiliar);
                pilaAuxiliar.clear();
            }
            System.out.println(pilaTortitas.getLast());
            return true;
        }
    } // casoDePrueba

    public static void main(String args[]) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution

import java.util.LinkedList;

public class P365_EnLaColaDePapaNoel {
    static java.util.Scanner in;

    public static void casoDePrueba() {

        int personas = in.nextInt();
        int posicionAitor = in.nextInt() - 1;
        int[] numRegalos = new int[personas];
        int tiempoEspera = 0;
        LinkedList<Integer> cola = new LinkedList<>();
        for (int i = 0; i < personas; i++) {
            numRegalos[i] = in.nextInt();
            cola.add(i);
        }
        while (numRegalos[posicionAitor] !=0) {
            int persona = cola.getFirst();
            if (numRegalos[persona] > 0){
                numRegalos[persona]--;
                tiempoEspera += 2;
                cola.addLast(cola.removeFirst());
            }else {
                cola.removeFirst();
            }
        }
        System.out.println(tiempoEspera);

    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
} // class solution

import java.util.ArrayList;

public class P610_NoQuieroIrmeSrStark {

    static java.util.Scanner in;

    public static void casoDePrueba() {
        int n,s,p,k;
        n = in.nextInt();
        s = in.nextInt();
        p = in.nextInt();
        k = in.nextInt();

        ArrayList<Integer> poblacion = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            poblacion.add(0);
        }
        poblacion.set(s-1, 1);
        poblacion.set(p-1, 2);

        int mitad = (int) Math.ceil(n/2.0);
        int posicion = 0;
        for (int i = 0; i < mitad; i++) {
            posicion += k;
            while (posicion >= n){
                posicion -= n;
            }
            poblacion.remove(posicion);
            n--;
        }
        boolean stark = poblacion.contains(1);
        boolean peter = poblacion.contains(2);
        if (stark && peter || !stark && !peter){
            System.out.println("No hay abrazo");
        }else if(stark){
            System.out.println("No quiero irme, Sr. Stark!");
        }else{
            System.out.println("No quiero irme, Peter!");
        }
    }

    public static void main(String[] args) {

       in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}


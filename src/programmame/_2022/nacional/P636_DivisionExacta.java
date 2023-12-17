package programmame._2022.nacional;

import java.util.ArrayList;
import java.util.HashMap;

public class P636_DivisionExacta {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {
            int a = in.nextInt();
            int b = in.nextInt();
            HashMap<Integer, Integer> restos = new HashMap<>();
            ArrayList<Integer> decimales = new ArrayList<>();
            int resto = a % b;
            restos.put(resto, 0);
            int pos = 1;
            while (resto != 0){
                resto *= 10;
                decimales.add(resto / b);
                resto = resto % b;
                if (restos.containsKey(resto)){
                    int comienzoPeriodo = restos.get(resto);
                    System.out.print("0.");
                    for (int i = 0; i < pos; i++) {
                        if (i == comienzoPeriodo){
                            System.out.print("|");
                        }
                        System.out.print(decimales.get(i));
                    }
                    System.out.println("|");
                    return true;
                }
                restos.put(resto, pos);
                pos++;
            }
            System.out.print("0.");
            for (int i : decimales){
                System.out.print(i);
            }
            System.out.println();

            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

} // class solution
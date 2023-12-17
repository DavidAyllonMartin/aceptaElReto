package programmame._2022.nacional;

import java.util.HashSet;

public class P633_ArcaDeNoe {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int numCasos = in.nextInt();
        if (numCasos == 0)
            return false;
        else {

            int animalesDuplicados = 0;
            int parejasCompletas = 0;
            HashSet<String> machos = new HashSet<>();
            HashSet<String> hembras = new HashSet<>();
            for (int i = 0; i < numCasos; i++) {
                String animal = in.next();
                String raiz = animal.substring(0, animal.length() - 1);
                if (animal.endsWith("a")){
                    if (!hembras.add(animal)){
                        animalesDuplicados++;
                    }else {
                        if (machos.contains(raiz +"o")){
                            parejasCompletas++;
                        }
                    }
                }else{
                    if (!machos.add(animal)){
                        animalesDuplicados++;
                    }else {
                        if (hembras.contains(raiz +"a")){
                            parejasCompletas++;
                        }
                    }
                }
            }
            int parejasIncompletas = numCasos - animalesDuplicados - parejasCompletas*2;

            System.out.println(parejasCompletas+" "+parejasIncompletas+" "+animalesDuplicados);

            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}
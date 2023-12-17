package programmame._2023.regional.madrid;

import java.util.Scanner;

public class P683_Termoclastismo {
    static Scanner in;

    public static boolean casoDePrueba() {
        int muestras = in.nextInt();
        if (muestras == 0) {
            return false;
        } else {
            int[] ints = new int[muestras];
            int max = -51;
            int min = 301;
            for (int i = 0; i < muestras; i++) {
                int num = in.nextInt();
                ints[i] = num;
                if (num < min){
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }

            int posI;
            int posF;
            int dif = ints.length + 1;

            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == min){
                    posI = i;
                    for (int j = i+1; j < ints.length ; j++) {
                        if (ints[j] == min){
                            posI = j;
                        }else if (ints[j] == max){
                            posF = j;
                            if (posF - posI < dif){
                                dif = posF - posI;
                            }
                            i = j - 1;
                            break;
                        }
                    }
                } else if (ints[i] == max) {
                    posI = i;
                    for (int j = i+1; j < ints.length ; j++) {
                        if (ints[j] == max){
                            posI = j;
                        }else if (ints[j] == min){
                            posF = j;
                            if (posF - posI < dif){
                                dif = posF - posI;
                            }
                            i = j - 1;
                            break;
                        }
                    }
                }
            }

            if (dif == ints.length + 1){
                dif = 0;
            }

            System.out.println(min + " " + max + " " + dif);


        }

        return true;
    }

    public static void main(String[] args) {

        in = new Scanner(System.in);

        while (casoDePrueba());

    }
}

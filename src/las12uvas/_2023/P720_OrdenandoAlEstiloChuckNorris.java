package las12uvas._2023;

import java.util.Scanner;

public class P720_OrdenandoAlEstiloChuckNorris {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int tamanioVector = in.nextInt();
            int tamanio = tamanioVector;
            int indice = 0;
            long numAnterior = in.nextLong();
            for (int i = 1; i < tamanioVector; i++) {
                long num1 = in.nextLong();
                if (num1 < numAnterior){
                    if (tamanio % 2 == 0){
                        indice += tamanio/2;
                        tamanio /= 2;
                        while (indice < i){
                            if (tamanio % 2 == 0){
                                indice += tamanio/2;
                                tamanio /= 2;
                            }else {
                                indice += tamanio/2 + 1;
                                tamanio /= 2;
                            }
                        }
                        while (i < indice){
                            num1 = in.nextLong();
                            i++;
                        }

                    }else {
                        indice += tamanio/2 + 1;
                        tamanio /= 2;
                        while (indice < i){
                            if (tamanio % 2 == 0){
                                indice += tamanio/2;
                                tamanio /= 2;
                            }else {
                                indice += tamanio/2 + 1;
                                tamanio /= 2;
                            }
                        }
                        while (i < indice){
                            num1 = in.nextLong();
                            i++;
                        }

                    }
                }
                numAnterior = num1;
            }

            System.out.println(tamanio);
        }

    }
}

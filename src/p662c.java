import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int weight;
    int f, c;

    Node(int f, int c, int weight) {
        this.f = f;
        this.c = c;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }
}
public class p662c {

    static int[] exploreC = new int[]{1, 0, -1, 0};
    static int[] exploreF = new int[]{0, 1, 0, -1};

    static int[] getMin(int startF, int startC, int minCells, int[][] m) {
        int max = m[startF][startC];
        int many = 0;

        boolean[][] visited = new boolean[m.length][m[0].length];
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(startF, startC, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (many >= minCells && current.weight > max) break;
            if (visited[current.f][current.c]) continue;

            many++;
            max = Math.max(max, current.weight);
            visited[current.f][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int newF = exploreF[i] + current.f;
                int newC = exploreC[i] + current.c;
                if (newF < 0 || newF == m.length ||
                        newC < 0 || newC == m[0].length ||
                        visited[newF][newC]
                ) continue;
                q.add(new Node(newF, newC, m[newF][newC]));
            }
        }

        return new int[]{max, many};
    }

    public static int propagar(int[][] terreno, boolean[][] terrenoVirtual, int fila, int columna, int nivel){
        int conteo = 0;
        if (fila<0 || fila > terreno.length-1 || columna<0 || columna > terreno[0].length-1 || terrenoVirtual[fila][columna] || terreno[fila][columna] > nivel)
            return 0;
        else {
            terrenoVirtual[fila][columna] = true;
            conteo++;
        }
        conteo += propagar(terreno, terrenoVirtual, fila, columna+1, nivel) + propagar(terreno, terrenoVirtual, fila-1, columna, nivel) + propagar(terreno, terrenoVirtual,fila+1, columna, nivel) + propagar(terreno, terrenoVirtual, fila, columna-1, nivel);
        return conteo;
    }


    public static String casoDePrueba(int[][] c) {

            int[][] terreno = c;
            int filas = terreno.length;
            int columnas = terreno[0].length;

            int mitad = columnas*filas/2;
            int cuenta=0;
            for (int i = cuenta;  ; i+=500) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad){
                    cuenta  = i-500;
                    break;
                }
            }
            for (int i = cuenta; ; i+=250) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad) {
                    cuenta = i - 250;
                    break;
                }
            }
            for (int i = cuenta; ; i+=125) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad) {
                    cuenta = i - 125;
                    break;
                }
            }
            for (int i = cuenta; ; i+=25) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad) {
                    cuenta = i - 25;
                    break;
                }
            }

            for (int i = cuenta; ; i+=5) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad) {
                    cuenta = i - 5;
                    break;
                }
            }
            String str;
            for (int i = cuenta; ; i++) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad) {
                    System.out.println(i+" "+anegadas);
                    str = i+" "+anegadas;
                    break;
                }
            }
            return str;
        }// casoDePrueba

    public static void rellenarArrayAleatorio(int[][] numeros, int max){
        //Bucle for para recorrer el array
        for(int i=0; i<numeros.length; i++){
            for (int j = 0; j < numeros[0].length; j++) {
                numeros [i][j] = (int) (Math.random()*max+1); //Math.random devuelve un double así que hay que forzar que lo guarde como entero
            }
        }
    }

    public static void imprimirMatrizInt(int[][] array){
        //Bucle foreach para acceder a los arrays dentro del array
        for (int[] enteros : array) {
            //Otro bucle foreach para acceder a los enteros dentro de cada array e imprimirlos seguidos de un espacio
            for (int i : enteros) {
                System.out.print(i + " ");
            }
            //Salto de línea para organizar por filas los arrays en pantalla
            System.out.println();
        }
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int C, F;
        int[][] m;
        while (true) {



            F = (int) (Math.random()*200+2)/2;
            C = (int) (Math.random()*100+1);
            m = new int[F][C];

            rellenarArrayAleatorio(m, 1000);

            m[m.length/2][0] = 0;

            int startC = 0;
            int startF = F / 2;

            int minCells = (C * F) / 2 + 1;
            int[] res = getMin(startF, startC, minCells, m);

            String str = res[0] + " " + res[1];
            System.out.println(res[0] + " " + res[1]);
            if (!str.equals(casoDePrueba(m))){
                imprimirMatrizInt(m);
                break;
            }


        }

    }

}

// Asume fichero llamado solution.java
public class LasCrecidasDelNilo_662_2 {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {
            int columnas = in.nextInt();
            int filas = in.nextInt();
            int[][] terreno = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    terreno[i][j] = in.nextInt();
                }
            }
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

            for (int i = cuenta; ; i++) {
                boolean[][] terrenoVirtual = new boolean[filas][columnas];
                int anegadas = propagar(terreno, terrenoVirtual, filas/2, 0, i);
                if(anegadas > mitad) {
                    System.out.println(i+" "+anegadas);
                    break;
                }
            }
            return true;
        }
    } // casoDePrueba

    /*public static boolean propagar(int[][] terreno, int fila, int columna, int nivel){
        if (fila<0 || fila > terreno.length-1 || columna<0 || columna > terreno[0].length || terreno[fila][columna] == -1 || terreno[fila][columna] > nivel)
            return false;
        else
            terreno[fila][columna] = -1;

        if (propagar(terreno, fila, columna+1, nivel) | propagar(terreno, fila-1, columna, nivel) | propagar(terreno, fila+1, columna, nivel) | propagar(terreno, fila, columna-1, nivel)){
            return false;
        }
        else return false;

    }*/

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

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }

    } // main

} // class solution
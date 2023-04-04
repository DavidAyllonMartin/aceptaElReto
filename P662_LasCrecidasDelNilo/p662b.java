import java.util.Collections;
import java.util.TreeSet;

// Asume fichero llamado solution.java
public class p662b {

    static java.util.Scanner in;

    public boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            // (incluyendo la lectura del caso de prueba)

            int columnas = in.nextInt();
            int filas = in.nextInt();
            TreeSet<Casilla> borde = new TreeSet<Casilla>();

            Casilla[][] terreno = new Casilla[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    terreno[i][j] = new Casilla(in.nextInt(), i, j);

                }
            }
            terreno[filas/2][0].setAnegado(true);
            int mitad = columnas*filas/2;
            int casillas_anegadas=1;
            int altura = 0;
            terreno[filas/2][0].setBorde(terreno, borde);

            while (casillas_anegadas <= mitad){
                Casilla c = borde.first();
                if (altura < c.getAltura()){
                    altura = c.getAltura();
                }
                c.setAnegado(true);
                casillas_anegadas++;
                c.setBorde(terreno, borde);
                borde.remove(c);
            }

            while (true){
                if (borde.size() == 0){
                    break;
                }
                Casilla c = borde.first();
                if (c.getAltura()>altura){
                    break;
                }
                c.setAnegado(true);
                casillas_anegadas++;
                c.setBorde(terreno, borde);
                borde.remove(c);
            }

            System.out.println(altura+" "+casillas_anegadas);


            return true;
        }
    } // casoDePrueba

    class Casilla implements Comparable<Casilla>{

        private int fila;

        private int columna;
        private int altura;
        private boolean anegado;

        public Casilla (int altura, int fila, int columna){
            this.altura = altura;
            this.fila = fila;
            this.columna = columna;
            this.anegado = false;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public boolean isAnegado() {
            return anegado;
        }

        public void setAnegado(boolean anegado) {
            this.anegado = anegado;
        }

        public int getFila() {
            return fila;
        }

        public void setFila(int fila) {
            this.fila = fila;
        }

        public int getColumna() {
            return columna;
        }

        public void setColumna(int columna) {
            this.columna = columna;
        }

        public void setBorde(Casilla[][] terreno, TreeSet<Casilla> borde){
            if (fila -1 >= 0 && !terreno[fila-1][columna].isAnegado() && !borde.contains(terreno[fila-1][columna])) {
                borde.add(terreno[fila-1][columna]);
            }

            if (fila+1 < terreno.length && !terreno[fila+1][columna].isAnegado() && !borde.contains(terreno[fila+1][columna])) {
                borde.add(terreno[fila+1][columna]);
            }

            if (columna-1 >=0 && !terreno[fila][columna-1].isAnegado() && !borde.contains(terreno[fila][columna-1])) {
                borde.add(terreno[fila][columna-1]);
            }

            if (columna+1 < terreno[0].length && !terreno[fila][columna+1].isAnegado() && !borde.contains(terreno[fila][columna+1])) {
                borde.add(terreno[fila][columna+1]);
            }
        }

        @Override
        public int compareTo(Casilla o) {

            if (o.getAltura()<this.altura){
                return 1;
            }
            if (o.getAltura()>this.altura){
                return -1;
            }
            if (o.getAltura() == this.altura){
                return 0;
            }
            return 0;
        }
    }

    public static void main(String args[]) {
        in = new java.util.Scanner(System.in);
        p662b caso_de_prueba = new p662b();
        while (caso_de_prueba.casoDePrueba()) {
        }
    } // main

} // class solution

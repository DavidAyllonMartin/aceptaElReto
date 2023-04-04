import java.util.ArrayList;
import java.util.Collections;

// Asume fichero llamado solution.java
public class p662 {

    static java.util.Scanner in;

    public boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            // (incluyendo la lectura del caso de prueba)

            int columnas = in.nextInt();
            int filas = in.nextInt();
            ArrayList<Casilla> casillas = new ArrayList<>();
            ArrayList<Casilla> casillasCopia = new ArrayList<>();

            Casilla[][] terreno = new Casilla[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    terreno[i][j] = new Casilla(in.nextInt(), i, j);
                    casillas.add(terreno[i][j]);
                    casillasCopia.add(terreno[i][j]);

                }
            }
            terreno[filas/2][0].setAnegado(true);
            casillas.remove(terreno[filas/2][0]);
            casillasCopia.remove(terreno[filas/2][0]);

            int mitad = columnas*filas/2;
            int casillas_anegadas=1;
            Collections.sort(casillas);
            Collections.sort(casillasCopia);

            for (int altura = 0; altura <= 1000; altura++) {
                boolean cambio;
                do {
                    cambio = false;
                    for (Casilla c : casillas){
                        if (c.getAltura() <= altura){
                            if (c.anegar(terreno)){
                                cambio = true;
                                casillas_anegadas++;
                                casillasCopia.remove(c);
                            }
                        }else break;
                    }
                    casillas = (ArrayList<Casilla>) casillasCopia.clone();
                }while(cambio);

                if (casillas_anegadas > mitad){
                    System.out.println(altura+" "+casillas_anegadas);
                    break;
                }

            }


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

        public boolean anegar(Casilla[][] terreno){
                try {
                    if (terreno[fila-1][columna].isAnegado()) {
                        this.anegado = true;
                        return true;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (terreno[fila+1][columna].isAnegado()) {
                        this.anegado = true;
                        return true;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (terreno[fila][columna-1].isAnegado()) {
                        this.anegado = true;
                        return true;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){
                }
                try {
                    if (terreno[fila][columna+1].isAnegado()) {
                        this.anegado = true;
                        return true;
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){
                }
                return false;
        }

        @Override
        public int compareTo(Casilla o) {
            int estado = 1;
            if (o.getAltura() == this.altura){
                estado = 0;
            }
            if (o.getAltura()>this.altura){
                estado = -1;
            }
            return estado;
        }
    }

    public static void main(String args[]) {
        in = new java.util.Scanner(System.in);
        p662 caso_de_prueba = new p662();
        while (caso_de_prueba.casoDePrueba()) {
        }
    } // main

} // class solution

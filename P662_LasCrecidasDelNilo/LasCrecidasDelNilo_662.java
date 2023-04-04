public class LasCrecidasDelNilo_662 {
    public static void main(String[] args) {

        int nivel = 0;
        int[][] terreno = new int[100][100];

        rellenarArrayAleatorio(terreno, 1000);

        terreno[terreno.length/2][0] = 0;

        imprimirMatrizInt(terreno);

        //Anegamos la primera casilla, por donde entra el Nilo. Utilizamos el -1 porque está fuera del rango de números
        //que nos propone el problema y no interferirá cuando contemos
        terreno[terreno.length/2][0] = -1;
        //Anegamos lo que tenga alrededor esa casilla para empezar siendo un poco más eficientes
        anegar(terreno, terreno.length/2, 0, 0);

        do {
            //Anegamos completamente un nivel y aumentamos el nivel del agua
            anegarNivel(nivel, terreno);
            nivel++;
        //Repetimos el proceso hasta que estén anegadas más de la mitad de las casillas del terreno
        }while (!(aparicionesNumeroMatriz(terreno, -1) > terreno.length*terreno[0].length/2));

        System.out.println(nivel-1 + " " + aparicionesNumeroMatriz(terreno, -1));

    }

    public static void anegarNivel(int nivel, int[][] terreno) {
        //Establecemos una variable booleana para recorrer y anegar la matriz hasta que en una pasada no se modifique ninguna casilla
        boolean repetir;
        do {
            repetir = false;
            //Con dos bucles for anidados recorremos la matriz entera y probamos a anegar desde cada casilla
            for (int fila = 0; fila < terreno.length; fila++) {
                for (int columna = 0; columna < terreno[0].length; columna++) {
                        //Si anegar es true significa que ha habido una modificación y esa modificación puede afectar a
                        //casillas anteriores así que hay que repetir el bucle para asegurarse
                        if (anegar(terreno, fila, columna, nivel)){
                            repetir = true;
                        }
                }
            }
        }while (repetir);
    }

    public static boolean anegar(int[][] terreno, int fila, int columna, int nivel){
        //La función devuelve un boolean que nos indica si ha hecho modificaciones o no
        boolean anegado = false;
        int ultimaFila = terreno.length-1;
        int ultimaColumna = terreno[0].length-1;
        //Si la casilla tiene un -1 significa que está anegada y puede propagar el agua a las casillas ortogonales
        if (terreno[fila][columna] == -1){
            //Si la casilla superior está dentro del array, no está anegada y está por debajo del nivel del agua, la anegamos
            if ((fila-1) >= 0 && terreno[fila-1][columna] != -1 && terreno[fila-1][columna] <= nivel) {
                terreno[fila-1][columna] = -1;
                anegado = true;
            }
            //Si la casilla inferior está dentro del array, no está anegada y está por debajo del nivel del agua, la anegamos
            if ((fila+1) <= ultimaFila && terreno[fila+1][columna] != -1 && terreno[fila+1][columna] <= nivel) {
                terreno[fila+1][columna] = -1;
                anegado = true;
            }
            //Si la casilla izquierda está dentro del array, no está anegada y está por debajo del nivel del agua, la anegamos
            if ((columna-1) >= 0 && terreno[fila][columna-1] != -1 && terreno[fila][columna-1] <= nivel) {
                terreno[fila][columna-1] = -1;
                anegado = true;
            }
            //Si la casilla derecha está dentro del array, no está anegada y está por debajo del nivel del agua, la anegamos
            if ((columna+1) <= ultimaColumna && terreno[fila][columna+1] != -1 && terreno[fila][columna+1] <= nivel) {
                terreno[fila][columna+1] = -1;
                anegado = true;
            }
        }
        //Si ha habido alguna modificación devolvemos true, y si no, false, el estado por defecto
        return anegado;
    }

    public static int aparicionesNumeroMatriz(int[][] matrixNumeros, int numero){
        //Creamos una variable para contar el número de apariciones del número
        int apariciones=0;
        //Un bucle foreach para recorrer todas las filas de la matriz
        for (int[] i : matrixNumeros) {
            //Utilizamos la función para buscar apariciones de un número en un array que ya habíamos creado y añadimos
            //el número de apariciones en la variable que habíamos creado
            apariciones += aparicionesNumero(i, numero);
        }
        return apariciones;
    }

    public static int aparicionesNumero(int[] numeros, int numero){
        int apariciones = 0;
        //Bucle foreach para recorrer el array entero
        for (int i:numeros){
            //Cuando el número coincida con el que buscamos, aumentamos la variable apariciones en 1 para llevar la cuenta
            if (i==numero)
                apariciones++;
        }
        return apariciones;
    }

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


}

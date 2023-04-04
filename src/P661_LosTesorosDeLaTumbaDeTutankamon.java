import java.util.Arrays;

public class P661_LosTesorosDeLaTumbaDeTutankamon {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int numCasos = in.nextInt();
        if (numCasos == 0)
            return false;
        else {
            Objeto[] objetos = new Objeto[numCasos];

            for (int i = 0; i < numCasos; i++) {
                String nombre = in.next();
                int valor = in.nextInt();
                int peso = in.nextInt();
                objetos[i] = new Objeto(nombre, valor, peso);
            }

            Arrays.sort(objetos);

            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < numCasos; i++) {
                strb.append(objetos[i].getNombre()).append(" ");
            }

            System.out.println(strb.toString().trim());
            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

}

class Objeto implements Comparable<Objeto> {
    private String nombre;
    private int valor;
    private int peso;

    public Objeto(String nombre, int valor, int peso) {
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(Objeto o) {
        if (this.valor > o.getValor()) {
            return -1;
        } else if (this.valor < o.getValor()) {
            return 1;
        } else {
            if (this.peso < o.peso) {
                return -1;
            } else if (this.peso > o.peso) {
                return 1;
            } else {
                return 0;
            }
        }

    }
}
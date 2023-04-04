import java.util.Arrays;

public class P633_ArcaDeNoe {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        int numCasos = in.nextInt();
        if (numCasos == 0)
            return false;
        else {

            int animalesDuplicados = 0;
            int parejasCompletas = 0;

            in.nextLine();
            String[] animales = in.nextLine().split(" ");

            Arrays.sort(animales);

            try {
                for (int i = 0; i < animales.length; i++) {
                    if (animales[i].equals(animales[i + 1])) {
                        animalesDuplicados++;
                    } else {
                        if (comprobarPareja(animales[i], animales[i + 1])) {
                            parejasCompletas++;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }


            int parejasIncompletas = animales.length - animalesDuplicados - parejasCompletas * 2;

            System.out.println(parejasCompletas + " " + parejasIncompletas + " " + animalesDuplicados);


            return true;
        }
    }

    public static boolean comprobarPareja(String str1, String str2) {
        str1 = str1.substring(0, str1.length() - 1);
        str2 = str2.substring(0, str2.length() - 1);
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}

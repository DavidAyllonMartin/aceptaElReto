import java.util.Arrays;
import java.util.Scanner;

public class P507_Tandem {

    static java.util.Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        while (CasoDePrueba());
    }

    private static boolean CasoDePrueba() {
        int integrantes = in.nextInt();
        int pesoMax = in.nextInt();
        if (integrantes == 0 && pesoMax == 0)
            return false;
        else{
            int parejas = 0;
            int[] familia = new int[integrantes];
            for (int i = 0; i < integrantes; i++) {
                familia[i] = in.nextInt();
            }
            Arrays.sort(familia);
            for (int i = 0; i < integrantes; i++) {
                for (int j = i+1; j < integrantes; j++) {
                    if (familia[i] + familia[j] <= pesoMax){
                        parejas++;
                    }else
                        break;

                }
            }
            System.out.println(parejas);
            return true;
        }
    }
}

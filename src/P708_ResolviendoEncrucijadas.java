import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class P708_ResolviendoEncrucijadas {

    public static void main(String[] args) {

        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/a"))){

            for (int i = 3; i < 10000010; i+=3) {
                int sd = sumaDigitos(i);

                bw.write(i+" : "+sd);
                bw.newLine();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static int sumaDigitos(int numero) {
        int suma = 0;

        while (numero != 0) {
            suma += numero % 10;
            numero /= 10;
        }

        return suma;
    }

}

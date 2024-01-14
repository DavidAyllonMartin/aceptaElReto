import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class P157_CuantosDiasFaltan {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Date nochevieja = Date.valueOf("2023-12-31");
        int numCasos = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCasos; i++) {
            String[] datos = in.readLine().split(" ");

            String str = "2023-"+datos[1]+"-"+datos[0];

            Date fecha = Date.valueOf(str);
            long dias = TimeUnit.MILLISECONDS.toDays(nochevieja.getTime() - fecha.getTime());

            System.out.println(dias);
        }
    }
}

package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P709_EligiendoLaSedeDelMundial {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(in.readLine());

        while (numCasos != 0){
            HashMap<String, Integer> votos = new HashMap<>();
            while (numCasos !=0){
                String[] arr = in.readLine().split(" ");
                numCasos -= arr.length;
                for (String voto : arr){
                    if(!votos.containsKey(voto)){
                        votos.put(voto, 1);
                    }else{
                        int cantidad = votos.get(voto);
                        cantidad++;
                        votos.put(voto, cantidad);
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            String maxStr = null;

            for (Map.Entry<String, Integer> entry : votos.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxStr = entry.getKey();
                }else if (entry.getValue() == max){
                    maxStr = "EMPATE";
                }
            }
            System.out.println(maxStr);
            numCasos = Integer.parseInt(in.readLine());
        }
    }
}

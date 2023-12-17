package programmame._2023.regional.madrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P679_FacundoYElUndo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCasos; i++) {
            String[] palabras = br.readLine().split(" ");
            Stack<String> escritas = new Stack<>();
            Stack<String> borradas = new Stack<>();
            for (String str : palabras) {
                if (str.equals(".")){
                    StringBuilder strb = new StringBuilder();
                    for (String s : escritas){
                        strb.append(s);
                        strb.append(" ");
                    }
                    System.out.println(strb.toString().trim());
                }
                if (str.equals("<")){
                    if (!escritas.isEmpty()){
                        borradas.push(escritas.pop());
                    }
                }else if (str.equals(">")){
                    if (borradas.isEmpty()){
                        if (!escritas.isEmpty()){
                            String s = escritas.peek();
                            escritas.push(s);
                        }
                    }else {
                        escritas.push(borradas.pop());
                    }
                }else {
                    escritas.push(str);
                    borradas.clear();
                }
            }
        }
    }
}

import java.util.LinkedList;

public class P141_ParentesisBalanceados {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {
            LinkedList<Character> pila = new LinkedList<>();
            String str = in.nextLine();
            char[] caracteres = str.toCharArray();
            for (char c : caracteres) {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        pila.addFirst(c);
                        break;
                    case ')':
                        if (pila.size() == 0) {
                            System.out.println("NO");
                            return true;
                        }
                        if (pila.getFirst() == '(') {
                            pila.removeFirst();
                        } else {
                            System.out.println("NO");
                            return true;
                        }
                        break;
                    case '}':
                        if (pila.size() == 0) {
                            System.out.println("NO");
                            return true;
                        }
                        if (pila.getFirst() == '{') {
                            pila.removeFirst();
                        } else {
                            System.out.println("NO");
                            return true;
                        }
                        break;
                    case ']':
                        if (pila.size() == 0) {
                            System.out.println("NO");
                            return true;
                        }
                        if (pila.getFirst() == '[') {
                            pila.removeFirst();
                        } else {
                            System.out.println("NO");
                            return true;
                        }
                        break;
                }
            }

            if (pila.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            return true;
        }
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}

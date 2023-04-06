public class P665_SemVer {

    static java.util.Scanner in;

    public static void casoDePrueba() {

        String str1a = in.next();
        String str2a = in.next();
        String[] str1 = str1a.split("\\.");
        String[] str2 = str2a.split("\\.");

        int[] ints1 = new int[3];
        int[] ints2 = new int[3];
        for (int i = 0; i < 3; i++) {
            ints1[i] = Integer.parseInt(str1[i]);
            ints2[i] = Integer.parseInt(str2[i]);
        }
        if (ints1[0] == ints2[0]){
            if (ints1[1] == ints2[1]){
                if (ints1[2]+1 == ints2[2]){
                    System.out.println("SI");
                }else
                    System.out.println("NO");
            } else if (ints1[1]+1 == ints2[1] && ints2[2] == 0) {
                System.out.println("SI");
            } else
                System.out.println("NO");
        } else if (ints1[0]+1 == ints2[0] && ints2[1] == 0 && ints2[2] == 0 ) {
            System.out.println("SI");
        }else
            System.out.println("NO");

    }

    public static void main(String args[]) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}

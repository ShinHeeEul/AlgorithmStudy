import java.util.*;


public class Main {

    static int check(String s) {
        switch (s) {
            case "black":
                return 0;
            case "brown":
                return 1;
            case "red":
                return 2;
            case "orange":
                return 3;
            case "yellow":
                return 4;
            case "green":
                return 5;
            case "blue":
                return 6;
            case "violet":
                return 7;
            case "grey":
                return 8;
            case "white":
                return 9;
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = check(sc.next());
        int b = check(sc.next());
        int c = check(sc.next());

        String S = "" + a + b;

        System.out.println((long) (Integer.parseInt(S) * Math.pow(10,c)));

    }

}
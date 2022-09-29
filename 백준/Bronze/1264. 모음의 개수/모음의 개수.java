import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();

            if (str.equals("#")) {
                break;
            }

            char[] index = {'A','E','I','O','U','a','e','i','o','u'};
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                for (int j = 0; j < index.length; j++) {
                    if(c == index[j]) {
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
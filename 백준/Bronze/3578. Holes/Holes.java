import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int h = scanner.nextInt();

            if (h == 0) {
                System.out.println("1");
            }
            else if (h == 1) {
                System.out.println("0");
            }
            else {
                StringBuilder sb = new StringBuilder();

                if (h % 2 != 0) {
                    sb.append("4");
                    h -= 1;
                }

                while (h > 0) {
                    sb.append("8");
                    h -= 2;
                }

                System.out.println(sb);
            }
        }

        scanner.close();
    }
}
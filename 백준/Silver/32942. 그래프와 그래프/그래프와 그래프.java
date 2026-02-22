import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input == null) return;

        StringTokenizer st = new StringTokenizer(input);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int x = 1; x <= 10; x++) {
            StringBuilder sb = new StringBuilder();
            boolean found = false;

            for (int y = 1; y <= 10; y++) {
                if ((long)A * x + (long)B * y == (long)C) {
                    if (found) {
                        sb.append(" ");
                    }
                    sb.append(y);
                    found = true;
                }
            }

            if (!found) {
                System.out.println(0);
            } else {
                System.out.println(sb.toString());
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        if (input == null) return;
        
        int N = Integer.parseInt(input);
        
        if (N == 1) {
            System.out.println(4);
            return;
        }

        long[] f = new long[N + 2];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= N + 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        long perimeter = 2 * (f[N] + f[N + 1]);
        System.out.println(perimeter);
    }
}
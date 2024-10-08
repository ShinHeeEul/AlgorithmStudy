import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();
        int[] arr = new int[N];
        int[] dp = new int[100_001];
        dp[0] = 1;
        for(int i = 0; i < N; i++) {
            int a = read();
            arr[i] = a;
            for(int j = a; j <= K; j++)
                dp[j] += dp[j - a];
        }

        System.out.println(dp[K]);


    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}

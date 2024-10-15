import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int K = read();
        if(K == 0) {
            System.out.println(0);
            return;
        } else if(K == 1) {
            System.out.println(1);
            return;
        } else if(K == 2) {
            System.out.println(N + 1);
            return;
        }

        int[][] dp = new int[N][K - 1];

        for(int i = 0; i < N ; i++) dp[i][0] = (i + 2);

        for(int i = 0; i < N; i++) {
            for(int j = 1; j < K-1; j++) {
                dp[i][j] = (((i-1) < 0 ? 1 : dp[i-1][j]) + dp[i][j-1]) % (1_000_000_000);
            }
        }

        System.out.println(dp[N - 1][K - 2]);
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}
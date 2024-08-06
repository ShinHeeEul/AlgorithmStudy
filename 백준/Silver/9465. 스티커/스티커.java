import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        int T = read();

        for(int i = 0; i < T; i++) {
            int N = read();

            int[][] arr = new int[2][N + 1];
            int[][] dp = new int[2][ N + 1];

            for(int j = 1; j <= N; j++) {
                arr[0][j] = read();
                dp[0][j] = arr[0][j];
            }

            for(int j = 1; j <= N; j++) {
                arr[1][j] = read();
                dp[1][j] = arr[1][j];
            }

            for(int j = 2; j <= N; j++) {
                int a = arr[0][j];
                int b = arr[1][j];
                dp[0][j] = Math.max(dp[0][j], Math.max(dp[0][j-2] + a, Math.max(dp[1][j-2] + a, dp[1][j-1] + a)));
                dp[1][j] = Math.max(dp[1][j], Math.max(dp[0][j-2] + b, Math.max(dp[1][j-2] + b, dp[0][j-1] + b)));
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
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
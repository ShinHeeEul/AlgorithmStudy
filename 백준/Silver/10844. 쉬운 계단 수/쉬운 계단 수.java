import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        int N = read();

        int[][] dp = new int[N + 1][10];

        Arrays.fill(dp[1], 1);

        for(int i = 2; i < N + 1; i++) {

            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][1];
                    continue;
                } else if(j == 9) {
                    dp[i][j] = dp[i-1][8];
                    continue;
                }
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])  % 1_000_000_000;
            }
        }
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            sum = sum + dp[N][i];
            sum %= 1_000_000_000;
        }

        System.out.println(sum);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;

    }
}
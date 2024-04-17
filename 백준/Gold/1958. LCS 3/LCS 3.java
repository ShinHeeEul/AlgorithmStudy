import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        char[] s3 = br.readLine().toCharArray();

        int N = s1.length;
        int M = s2.length;
        int K = s3.length;

        int[][][] dp = new int[N+1][M+1][K+1];

        for(int i = 1; i <= N; i++) {
            char A = s1[i-1];
            for(int j = 1; j <= M; j++) {
                char B = s2[j-1];
                for(int k = 1; k <= K; k++) {
                    char C = s3[k-1];

                    if(A==B && B==C) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                        continue;
                    }
                    dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));

                }
            }
        }
        System.out.println(dp[N][M][K]);
    }
}

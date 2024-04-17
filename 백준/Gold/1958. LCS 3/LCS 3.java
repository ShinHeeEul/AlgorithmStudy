import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        int N = s1.length();
        int M = s2.length();
        int K = s3.length();

        int[][][] dp = new int[N+1][M+1][K+1];

        for(int i = 1; i <= N; i++) {

            for(int j = 1; j <= M; j++) {

                for(int k = 1; k <= K; k++) {

                    if((s1.charAt(i-1) == s2.charAt(j-1))
                            && (s1.charAt(i-1) == s3.charAt(k-1))) {
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

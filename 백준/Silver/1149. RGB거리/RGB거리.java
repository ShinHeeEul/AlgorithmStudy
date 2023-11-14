import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[1] = new int[] {
                Integer.parseInt(st.nextToken())
                ,Integer.parseInt(st.nextToken())
                ,Integer.parseInt(st.nextToken())};

        for(int i = 2; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[i] = new int[3];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + g);
                dp[i][2] = Math.min(dp[i][2], dp[i-1][0] + b);

                dp[i][0] = Math.min(dp[i][0], dp[i-1][1] + r);
                dp[i][2] = Math.min(dp[i][2], dp[i-1][1] + b);

                dp[i][0] = Math.min(dp[i][0], dp[i-1][2] + r);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][2] + g);
        }

        Arrays.sort(dp[N]);
        System.out.println(dp[N][0]);

    }
}

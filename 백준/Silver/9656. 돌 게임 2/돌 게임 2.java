import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1001];

        dp[1] = false; 
        if (N >= 2) dp[2] = true;
        if (N >= 3) dp[3] = false;

        for (int i = 4; i <= N; i++) {
            if (!dp[i - 1] || !dp[i - 3]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
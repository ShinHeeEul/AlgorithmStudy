import java.io.*;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        if(N == 1) {
            System.out.println(1);
            return;
        }
        if(N == 2) {
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < N+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;

        }

        System.out.println(dp[N]);
    }


}
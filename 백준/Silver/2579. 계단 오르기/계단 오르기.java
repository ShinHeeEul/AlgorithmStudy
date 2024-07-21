import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[2][400];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.println(arr[0]);
            return;
        }

        if(N == 2) {
            System.out.println(arr[1] + arr[0]);
            return;
        }

        dp[0][0] = arr[0];
        dp[0][1] = arr[1];
        dp[1][1] = arr[0] + arr[1];

        for(int i = 2; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i], dp[0][i-2] + arr[i]);
            dp[0][i] = Math.max(dp[0][i], dp[1][i-2] + arr[i]);
            dp[1][i] = Math.max(dp[0][i], dp[0][i-1] + arr[i]);
        }

        System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));


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

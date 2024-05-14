import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        int[] arr = new int[n+1];
        int MAX = 100_000_000;
        int[] dp = new int[k+100000];
        Arrays.fill(dp, MAX);
        for(int i = 1; i <= n; i++) {
            arr[i] = read();
            dp[arr[i]] = 1;
        }

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i + arr[j]] = Math.min(dp[i + arr[j]], dp[i] + 1);
            }
        }
        System.out.println(dp[k] == MAX?-1:dp[k]);
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

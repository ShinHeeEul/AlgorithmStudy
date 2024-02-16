public class Main {

    static int[] arr;
    static int[][] dp;
    static int[] sum;
    public static void main(String[] args) throws Exception {
        int T = read();

        while(T --> 0) {
            int K = read();

            arr = new int[K+1];
            sum = new int[K+1];
            for(int i = 1; i <= K; i++) {
                arr[i] = read();
                sum[i] = sum[i-1] + arr[i];
            }
            dp = new int[K+1][K+1];

            for(int i = 1; i <= K; i++) {
                for(int j = 1; i + j <= K; j++) {
                    int a = i + j;
                    dp[j][a] = Integer.MAX_VALUE;
                    for(int k = j; k < a; k++) {
                        dp[j][a] = Math.min(dp[j][a], dp[j][k] + dp[k + 1][a] + sum[a] - sum[j-1]);
                    }
                }
            }

            System.out.println(dp[1][K]);

        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

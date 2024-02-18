import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] arr = new int[N + 1];
        for(int i = 0; i < N; i++) {
            arr[i] = read();
            arr[i+1] = read();
        }

        long[][] dp = new long[N][N];


        int INF = Integer.MAX_VALUE;

        for(int i=2; i<N+1; i++) {
            for(int j=0; j<N-i+1; j++) {
                dp[j][j+i-1] = INF;
                for(int k=j; k<j+i-1; k++) dp[j][j+i-1] = Math.min(dp[j][j+i-1], dp[j][k]  + dp[k+1][j+i-1] + ((long) arr[j] * arr[k+1] * arr[j+i]));
            }
        }

        System.out.println(dp[0][N-1]);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

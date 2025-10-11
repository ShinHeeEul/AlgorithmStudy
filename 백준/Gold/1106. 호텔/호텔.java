import java.util.Arrays;

public class Main {

    static int N;
    static int C;

    public static void main(String[] args) throws Exception {
        C = read();
        N = read();

        int[][] arr = new int[N][2];

        int MAX = Integer.MAX_VALUE >> 1;
        int[] dp = new int[1200];
        Arrays.fill(dp, MAX);
        for(int i = 0 ; i < N; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
            dp[arr[i][1]] = Math.min(dp[arr[i][1]], arr[i][0]);
        }

        for(int i = 0; i < C; i++) {
            if(dp[i] == MAX) continue;

            for(int j = 0 ; j < N ; j++) {
                dp[i + arr[j][1]] = Math.min(dp[i] + arr[j][0], dp[i + arr[j][1]]);
            }
        }
        int max = MAX;
        for(int i = C; i < 1200; i++) max = Math.min(dp[i], max);

        System.out.println(max);
    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();

        if (d == '-') {
            negative = true;
            d = System.in.read();
        }
        o = d & 15;

        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }

}

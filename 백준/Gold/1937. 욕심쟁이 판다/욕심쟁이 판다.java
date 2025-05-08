import java.util.Arrays;

public class Main {

    static int[][] arr;
    static int[][] dp;
    static int max = 0;
    static int N;

    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        N = read();

        arr = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = read();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j  < N; j++) {
                max = Math.max(max, backTracking(i, j));
            }
        }
        System.out.println(max);
    }

    public static int backTracking(int i, int j) {

        if(dp[i][j] != 0) return dp[i][j];

        boolean b = true;
        for(int t = 0; t < 4; t++) {
            int ii = i + di[t];
            int jj = j + dj[t];

            if(check(ii, jj, arr[i][j])) {
                b = false;
                dp[i][j] = Math.max(dp[i][j], backTracking(i + di[t], j + dj[t]) + 1);
            }
        }

        if(b) dp[i][j] = 1;
        return dp[i][j];
    }

    public static boolean check(int i, int j, int cur) {
        return i >= 0 && i < N && j >= 0 && j < N && cur < arr[i][j];
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

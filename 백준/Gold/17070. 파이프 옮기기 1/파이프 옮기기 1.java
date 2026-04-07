import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dp;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws Exception {
        N = read();

        visited = new boolean[N][N];

        // 0 - 가로 1 - 세로 2 - 대각선
        dp = new int[N + 1][N + 1][3];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = read() == 1;
            }
        }

        dp[0][1][0] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 가로 일 때
                    // 가로
                checkAndAdd(i, j + 1, 0, dp[i][j][0]);
                    // 대각선
                checkAndAdd(i + 1, j + 1, 2, dp[i][j][0]);


                // 세로 일 때
                    // 세로
                checkAndAdd(i + 1, j, 1, dp[i][j][1]);
                    // 대각선
                checkAndAdd(i + 1, j + 1, 2, dp[i][j][1]);

                // 대각선 일 때
                    // 가로
                checkAndAdd(i, j + 1, 0, dp[i][j][2]);
                    // 세로
                checkAndAdd(i + 1, j, 1, dp[i][j][2]);
                    // 대각선
                checkAndAdd(i + 1, j + 1, 2, dp[i][j][2]);
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);

    }

    public static void checkAndAdd(int i, int j, int dir, int val) {
        if(i >= 0 && i < N && j >= 0 && j < N) {
            if((dir == 0 || dir == 1) && !visited[i][j]) {
                dp[i][j][dir] += val;
            } else if(dir == 2 && !visited[i][j] && !visited[i-1][j] && !visited[i][j-1]) {
                dp[i][j][dir] += val;
            }
        }
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
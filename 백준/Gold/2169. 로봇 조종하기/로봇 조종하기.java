import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][][] dp;

    static int N;
    static int M;

    static int DEFAULT = -20000;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        N = read();
        M = read();

        arr = new int[N][M];
        dp = new int[N][M][3];

        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], DEFAULT);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = read();
            }
        }


        dp[0][0][0] = arr[0][0];
        dp[0][0][1] = arr[0][0];
        dp[0][0][2] = arr[0][0];



        for(int i = 0; i < N; i++) {
            // 우측으로 쭉 보내고
            for(int j = 0; j < M-1; j++) {
                    // 위에서 왔다면
                if(i != 0) {
                    if (dp[i][j][0] != DEFAULT) {
                        dp[i][j + 1][2] = Math.max(dp[i][j + 1][2], dp[i][j][0] + arr[i][j + 1]);
                    }
                }
                if(dp[i][j][2] != DEFAULT) {
                    dp[i][j + 1][2] = Math.max(dp[i][j + 1][2], dp[i][j][2] + arr[i][j + 1]);
                }

            }
            // 왔다 갔다?
            if(i != 0 || i != N - 1) {
                for (int j = M - 1; j > 0; j--) {
                    if (dp[i][j][0] != DEFAULT) {
                        dp[i][j - 1][1] = Math.max(dp[i][j - 1][1], dp[i][j][0] + arr[i][j - 1]);
                    }
                    if (dp[i][j][1] != DEFAULT) {
                        dp[i][j - 1][1] = Math.max(dp[i][j - 1][1], dp[i][j][1] + arr[i][j - 1]);
                    }
                }
            }

            if(i != N - 1) {
                for (int j = 0; j < M; j++) {
                    int max = Math.max(dp[i][j][2], Math.max(dp[i][j][0], dp[i][j][1]));
                    dp[i + 1][j][0] = Math.max(dp[i + 1][j][0], max + arr[i + 1][j]);
                }
            }
        }

        
        System.out.println(Math.max(Math.max(dp[N - 1][M - 1][0], dp[N - 1][M - 1][1]), dp[N - 1][M - 1][2]));

    }


    private static int read() throws IOException {
        int d, o = 0;
        boolean negative = false;

        while ((d = System.in.read()) <= 32);

        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        do {
            o = (o << 3) + (o << 1) + (d & 15); // o = o * 10 + (d - '0')
        } while ((d = System.in.read()) >= '0' && d <= '9');

        return negative ? -o : o;
    }
}
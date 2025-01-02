import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int M;
    static int[][] arr;
    static int[] di = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dj = {0, -1, 0, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            int max = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    max = Math.max(max, arr[i][j] + spread(i, j));
                }
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static int spread(int i, int j) {
        int cross = 0;
        int x = 0;
        for(int m = 1; m < M; m++) {
            for(int n = 0; n < 4; n++) {
                int ni = i + m * di[n];
                int nj = j + m * dj[n];
                if(check(ni, nj)) cross += arr[ni][nj];
            }
            for(int n = 4; n < 8; n++) {
                int ni = i + m * di[n];
                int nj = j + m * dj[n];
                if(check(ni, nj)) x += arr[ni][nj];
            }
        }
        return Math.max(cross, x);
    }

    public static boolean check(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

}

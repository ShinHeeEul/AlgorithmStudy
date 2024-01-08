import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] D = new int[N][N];
        int INF = 999999999;

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(D[a-1][b-1] != 0) {
                D[a - 1][b - 1] = Math.min(D[a - 1][b - 1], c);
            } else {
                D[a-1][b-1] = c;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(D[i][j] == 0) D[i][j] = INF;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                for(int k = 0; k < N; k++) {
                    if(i == k || j == k) continue;
                    D[j][k] = Math.min(D[j][i] + D[i][k], D[j][k]);
                }
            }
        }

        for(int i = 0; i < N;i++) {
            for(int j = 0; j < N; j++) {
                if (D[i][j] == INF) {
                    bw.write(0 + " ");
                } else {
                    bw.write(D[i][j] + " ");
                }
            }
            bw.write("\n");

            bw.flush();
        }
    }
}

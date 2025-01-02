import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append("\n");

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];
            int[][] arr90 = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    arr[i][j] = a;
                    arr90[j][N - 1 - i] = a;
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) sb.append(arr90[i][j]);
                sb.append(" ");
                for(int j = 0; j < N; j++) sb.append(arr[N-1-i][N-1-j]);
                sb.append(" ");
                for(int j = 0; j < N; j++) sb.append(arr90[N-1-i][N-1-j]);
                sb.append("\n");
            }

        }

        System.out.println(sb);


    }

}

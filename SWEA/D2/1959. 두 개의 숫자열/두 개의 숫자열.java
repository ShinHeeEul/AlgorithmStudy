import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
            int max = 0;
            
            if(N < M) {
                for(int i = 0; i <= (M - N); i++) {
                    int ans = 0;
                    for(int j = 0; j < N; j++) {
                        int a = A[j];
                        int b = B[i + j];
                        ans += (a * b);
                    }
                    max = Math.max(max, ans);
                }
            } else {
                for(int i = 0; i <= (N - M); i++) {
                    int ans = 0;
                    for(int j = 0; j < M; j++) {
                        int a = A[i + j];
                        int b = B[j];
                        ans += (a * b);
                    }
                    max = Math.max(max, ans);
                } 
            }
            
            sb.append("#").append(t).append(" ").append(max).append("\n");

        }

        System.out.println(sb);
    }

}

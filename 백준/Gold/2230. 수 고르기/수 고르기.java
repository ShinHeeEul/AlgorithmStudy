import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] A = new int[N+1];
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(br.readLine());
        Arrays.sort(A);

        //O(nlogn)
        long min = Integer.MAX_VALUE;
        for(int start = 1, end = 2; start <= N; start++) {
            int dif = A[end] - A[start];
            while(dif < M && end < N) {
                end++;
                dif = A[end] - A[start];
            }
            if(dif >= M) min = Math.min(min ,dif);
        }
        System.out.println(min);

    }
}

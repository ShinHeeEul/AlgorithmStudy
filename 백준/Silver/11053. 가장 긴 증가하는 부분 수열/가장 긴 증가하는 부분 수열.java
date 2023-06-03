import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        //arr 맨 처음 값이 담길 array
        int[] arr = new int[N + 1];
        //dp 횟수 값이 담길 array
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        //모든 dp 값을 1로 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // i는 현재 index, j는 i전까지의 index
        // 만약 arr[i]보다 arr[j]가 작다면(arr[j] 다음 부분 원소가 arr[i]가 될 수 있음)
        //dp[j] + 1과 dp[i] 중 큰 값으로 dp[i] 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = -1;
        for(int i = 0 ; i < N; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
    
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][M+1];
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] + tmp- dp[i][j];
                if(answer < dp[i+1][j+1]) {
                    answer = dp[i+1][j+1];
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                for(int k = N; k >= i; k--) {
                    for(int l = M; l >= j; l--) {
                        int tmp;
                        if(i == 1) {
                            tmp = dp[k][l] - dp[k][j-1] - dp[i-1][l] + dp[i][j-1];
                        } else {
                            tmp = dp[k][l] - dp[k][j - 1] - dp[i - 1][l] + dp[i - 1][j - 1];
                        }

                        if(tmp > answer){
                            answer = tmp;
                        }
                    }
                }
            }
        }

        System.out.println(answer);


    }

}

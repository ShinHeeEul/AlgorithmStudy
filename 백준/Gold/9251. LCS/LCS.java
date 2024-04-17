import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = s1.length();
        int M = s2.length();
        int[][] arr = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            char c1 = s1.charAt(i-1);

            for(int j = 1; j <= M; j++) {
                char c2 = s2.charAt(j-1);

                if(c1 == c2) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                    continue;
                }
                arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);

            }
        }
        System.out.println(arr[N][M]);
    }
}

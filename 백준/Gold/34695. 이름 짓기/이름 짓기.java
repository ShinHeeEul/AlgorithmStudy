import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int[][] arr;
    static int MAX = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // i번째 조합이 j이고 k이다.
        // 1차가 가는거 // 2차는 현재 영문자로 끝나는 문자열이 몇개인가
        dp = new int[N + 1][26];
        arr = new int[K][2];

        for(int i = 0; i < K; i++) {
            char[] line = br.readLine().toCharArray();
            arr[i][0] = line[0] - 'a';
            arr[i][1] = line[1] - 'a';
            dp[1][arr[i][1]]++;
        }

        for(int i = 1; i < N; i++) {
            // 지금 단어의 몇번째 접미인게 몇개냐?
                for(int k = 0; k < K; k++) {
                    dp[i + 1][arr[k][1]]++;
                    dp[i + 1][arr[k][1]] = (dp[i + 1][arr[k][1]] + dp[i][arr[k][0]]) % MAX;
                }
        }

        long sum = 0;
        for (int i = 0; i < 26; i++) {
            sum = (sum + dp[N-1][i]) % MAX;
        }
        System.out.println(sum);
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
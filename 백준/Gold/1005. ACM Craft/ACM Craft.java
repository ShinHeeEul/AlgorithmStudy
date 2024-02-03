import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[] time;
    static int[] dp;
    static ArrayList<Integer>[] list;
    static int[] start;
    public static void main(String[] args) throws Exception {
        int T = read();

        for(int t = 0; t < T; t++) {
            int N = read();
            int K = read();
            list = new ArrayList[N+1];
            time = new int[N+1];
            dp = new int[N+1];
            start = new int[N+1];

            for(int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
                time[i] = read();
                dp[i] = time[i];
            }

            for(int i = 0 ; i < K; i++) {
                int a = read();
                int b = read();
                list[a].add(b);
                start[b]++;
            }

            for(int i = 1; i <= N; i++) {
                if(start[i] == 0) {
                    recursive(i);
                }
            }

            System.out.println(dp[read()]);

        }



    }

    static void recursive(int i) {
        for(int l : list[i]) {
            dp[l] = Math.max(dp[l], dp[i] + time[l]);
            if(--start[l] == 0) {
                recursive(l);
            }
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

}

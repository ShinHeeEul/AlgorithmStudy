import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Long, Long> map = new HashMap();
        long[] dp = new long[N + 1];
        Long count = 0L;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());

            if(dp[i] == K) count++;
        }


        for(int i = 1; i <= N; i++) {
            Long l = dp[i];
            Long a = map.get(l - K);
            if(a != null) count += a;

            if(map.get(l) == null) {
                map.put(l, 1L);
            } else {
                map.put(l, map.get(l) + 1);
            }
        }

        System.out.println(count);

    }

}

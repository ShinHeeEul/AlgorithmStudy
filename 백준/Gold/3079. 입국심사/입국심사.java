import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long start = 0;
        long end = Integer.MAX_VALUE;
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(end > arr[i]) end = arr[i];
        }
        end *= M;

        while(start < end) {
            long mid = (end + start) / 2;
            long ans = 0;

            for(int i : arr) ans += mid/i;

            if(ans >= M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);

    }
}

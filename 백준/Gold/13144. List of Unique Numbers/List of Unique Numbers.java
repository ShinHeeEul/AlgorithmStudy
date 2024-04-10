import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        long cnt = 0;
        BitSet check = new BitSet(100001);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int start=1, end=0; start <= N; start++) {
            while(end+1<=N && !check.get(arr[end+1])) {
                end++;
                check.set(arr[end]);
            }
            cnt += end-start+1;
            check.set(arr[start], false);
        }

        System.out.println(cnt);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] set = new int[M];
        arr = new int[N+2];

        for(int i = 0; i <= N+1; i++) arr[i] = i;
        for(int i = 0; i < M; i++) set[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(set);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int start = 0;
            int end = M-1;
            int ans = Integer.parseInt(st.nextToken());
            while(start < end) {
                int mid = (start + end) / 2;
                int t = set[mid];
                if(t < ans) {
                    start = mid + 1;
                } else if(t > ans) {
                    end = mid;
                } else {
                    end = mid + 1;
                    break;
                }
            }
            int d = find(set[end]);
            sb.append(arr[d]).append("\n");
            union(d, d+1);
        }
        System.out.print(sb);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }
        arr[x] = y;
        return false;
    }

    public static int find(int x) {
         if(x == arr[x]) {
             return x;
         }
        return arr[x] = find(arr[x]);
    }
}

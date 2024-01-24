import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] c = new int[N+1];
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            arr[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Node> map = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            int arri = find(i);
            Node n = map.get(arri);
            if(n == null) {
                map.put(arri, new Node(c[i], 1));
                continue;
            }
            map.put(arri, new Node(n.val + c[i], n.count+1));
        }

        int[] dp = new int[K];
        for (int key : map.keySet()) {
            Node n = map.get(key);
            int val = n.val;
            int count = n.count;
            for (int i = K-1; i >= count; i--) {
                dp[i] = Math.max(dp[i], dp[i-count]+val);
            }
        }

        System.out.println(dp[K-1]);

    }

    public static class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return false;
        }
        if(x < y) {
            arr[y] = x;
        } else {
            arr[x] = y;
        }
        return true;
    }

    public static int find(int x) {
        if(x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static ArrayList<Node>[] nodes;
    static int v2;
    static int v1;
    static int[] shorts;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        shorts = new int[N+1];
        Arrays.fill(shorts, Integer.MAX_VALUE);
        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            nodes[u].add(new Node(v, val));
            nodes[v].add(new Node(u, val));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        visited[1] = true;
        shorts[1] = 0;
        //1 - v1,v2
        dij(1);
        if(shorts[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        int sum1 = 0;
        if((shorts[v1] > 0) && (shorts[v1] != Integer.MAX_VALUE)) {
            sum1 += shorts[v1];
        }
        int sum2 = 0;
        if((shorts[v2] > 0) && (shorts[v2] != Integer.MAX_VALUE)) {
            sum2 += shorts[v2];
        }
        visited = new boolean[N+1];
        shorts = new int[N+1];
        Arrays.fill(shorts, Integer.MAX_VALUE);
        shorts[v1] = 0;

        //v1,v2 - v2,v1
        dij(v1);
        if((shorts[v2] > 0) && (shorts[v2] != Integer.MAX_VALUE)) {
            sum1 += shorts[v2];
        }
        visited = new boolean[N+1];
        shorts = new int[N+1];
        Arrays.fill(shorts, Integer.MAX_VALUE);
        shorts[v2] = 0;
        dij(v2);
        if((shorts[v1] > 0) && (shorts[v1] != Integer.MAX_VALUE)) {
            sum2 += shorts[v1];
        }

        //v2,v1 - N
        visited = new boolean[N+1];
        shorts = new int[N+1];
        Arrays.fill(shorts, Integer.MAX_VALUE);
        shorts[N] = 0;
        dij(N);
        if((shorts[v2] > 0) && (shorts[v2] != Integer.MAX_VALUE)) {
            sum1 += shorts[v2];
        }
        if((shorts[v1] > 0) && (shorts[v1] != Integer.MAX_VALUE)) {
            sum2 += shorts[v1];
        }
        if(sum1 <= 0 && sum2 <= 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(sum1, sum2));

    }

    static void dij(int start) {
        visited[start] = true;
        for(Node node : nodes[start]) {
            shorts[node.to] = node.val;
        }

        for(int i = 0; i < N; i++) {

            Node min = new Node(-1, Integer.MAX_VALUE);
            for(int j = 1; j <= N; j++) {
                if(shorts[j] < min.val && !visited[j]) {
                    min = new Node(j, shorts[j]);
                }
            }
            if(min.to == -1) {
                break;
            }
            visited[min.to] = true;
            for (Node node : nodes[min.to]) {
                shorts[node.to] = Math.min(shorts[node.to], shorts[min.to] + node.val);
            }
        }
    }

    static class Node {
        int to;
        int val;

        public Node( int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
}

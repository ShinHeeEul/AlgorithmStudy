import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static ArrayList<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        bellmanFord(N, M, 1);


        }

    static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }


    public static void bellmanFord(int n, int m, int start) {
        long[] dist = new long[n+1];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Edge edge = list.get(j);
                if(dist[edge.v] != Long.MAX_VALUE) {
                    dist[edge.w] = Math.min(dist[edge.w], dist[edge.v] + edge.cost);
                }
            }
        }

        for(int j = 0; j < m; j++) {
            Edge edge = list.get(j);
            if(dist[edge.v] != Long.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
                System.out.println(-1);
                return;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            if(dist[i] == Long.MAX_VALUE) {
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);


    }
}


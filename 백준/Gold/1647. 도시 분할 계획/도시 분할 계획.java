import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        boolean[] visit = new boolean[N + 1];

        for(int i = 0 ; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(1, 0));

        long answer = 0;
        int bigger = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visit[e.node]) continue;
            visit[e.node] = true;


            answer += e.cost;
            bigger = Math.max(bigger, e.cost);

            for(Edge ee : graph[e.node]) {
                if(!visit[ee.node]) {
                    pq.offer(ee);
                }
            }

        }

        System.out.println(answer - bigger);
    }

    static class Edge implements Comparable<Edge> {

        int cost;
        int node;

        public Edge(int node, int cost) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

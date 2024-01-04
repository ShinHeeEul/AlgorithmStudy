import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Node>[] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        Node start = null;
        while(true){
            cnt++;
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            map = new ArrayList[N*N];
            for(int i = 0; i < map.length; i++) {
                map[i] = new ArrayList<>();
            }
            int count = 0;
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    
                    Node n = new Node(count, Integer.parseInt(st.nextToken()));
                    if(count == 0) {
                        start = n;
                    }
                    if(count % N != 0) {
                        map[count - 1].add(n);
                    }
                    if(count % N != N-1) {
                        map[count + 1].add(n);
                    }
                    if(count / N != 0) {
                        map[count - N].add(n);
                    }
                    if(count / N != N-1) {
                        map[count + N].add(n);
                    }
                    count++;
                }
            }

            dij(N, start, cnt);
        }
    }

    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }


    public static void dij(int N, Node start, int count) {

        boolean[] visit = new boolean[N * N];
        int[] dist = new int[N * N];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start.index] = start.cost;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start.index, start.cost));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if(visit[n.index]) continue;
            visit[n.index] = true;

            for(Node nn : map[n.index]) {
                if(dist[nn.index] > dist[n.index] + nn.cost) {
                    dist[nn.index] = dist[n.index] + nn.cost;
                    pq.offer(new Node(nn.index, dist[nn.index]));
                }
            }
        }
        System.out.println("Problem " + count + ": " + dist[N*N-1]);
    }
}


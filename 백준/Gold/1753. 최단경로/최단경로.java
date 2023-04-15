import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V =Integer.parseInt(st.nextToken());
        int E =Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        //정점 2만개 -> ArrayList
        ArrayList<Node>[] arr = new ArrayList[V+1];
        int[] distance = new int[V+1];
        for(int i = 0; i < V+1; i++) {
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        //간선 연결
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            //map에 데이터 넣고
            arr[u].add(new Node(v,w));
        }
        //우선순위 큐에 K 넣고
        PriorityQueue<Node> queue = new PriorityQueue<>();
        //distance[K] 0으로 바꿔주고
        queue.add(new Node(K,0));
        distance[K] = 0;
        boolean[] visit = new boolean[V+1];
        //visit[K]  = true;
        //우선순위 큐가 비지 않는 동안 반복
        while(!queue.isEmpty()) {

            // Node n우선 순위 큐에서 꺼내서
            Node n = queue.poll();
            // 방문 했는지 체크 -> 했다면 continue;
            if(visit[n.v]) continue;
            // 안했다면 방문 체크해주고
            visit[n.v] = true;
            // K와 연결된 녀석들의 distance 값 업데이트
            for(int i = 0; i < arr[n.v].size(); i++) {
                //도착할 노드
                Node n2 = arr[n.v].get(i);
                if(distance[n.v] + n2.w < distance[n2.v]) {
                    distance[n2.v] = distance[n.v] + n2.w;
                    // Queue에 그 값추가
                    queue.add(new Node(n2.v, distance[n2.v]));
                }
            }
        }
        //출력
        for(int i = 1; i <= V; i++) {
            if(visit[i]) {
                System.out.println(distance[i]);
            }
            else {
                System.out.println("INF");
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            if(this.w > n.w) return 1;
            return -1;
        }
    }
}
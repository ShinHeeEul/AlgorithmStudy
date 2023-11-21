import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[V+1];
        boolean[] visit = new boolean[V + 1];

        for(int i = 0; i < V+1; i++) {
            list[i] = new ArrayList();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, val));
            list[y].add(new Node(x, val));
        }

        int answer = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(1,0));

        while(!priorityQueue.isEmpty()) {
            Node n = priorityQueue.poll();

            if(visit[n.to]) {
                continue;
            }

            visit[n.to] = true;
            answer += n.val;

            for(Node node : list[n.to]) {
                if(!visit[node.to]) {
                    priorityQueue.add(node);
                }
            }
        }


        System.out.println(answer);
    }

    static class Node implements Comparable<Node>{
        int to;
        int val;

        public Node(int to, int val) {
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}

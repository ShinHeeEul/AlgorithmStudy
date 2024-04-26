import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int[][] dij;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int X = read();

        dij = new int[N+1][N+1];

        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++)
            list[read()].add(new Node(read(), read()));

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dij(i);
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dij[i][X] + dij[X][i]);
        }

        System.out.println(max);
    }

    public static void dij(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Arrays.fill(dij[start], 200000);
        dij[start][start] = 0;
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            int to = n.to;
            if(visited[to]) {
                continue;
            }
            visited[to] = true;
            for(Node m : list[to]) {
                if(dij[start][m.to] > dij[start][to] + m.value) {
                    dij[start][m.to] = Math.min(dij[start][m.to], dij[start][to] + m.value);
                    queue.add(new Node(m.to, dij[start][m.to]));
                }
            }

        }
    }

    static class Node  implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to =to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
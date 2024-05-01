import java.util.ArrayList;
import java.util.Stack;

public class Main {


    static Node[] nodes;
    static int N;
    static ArrayList<Integer>[] lists;
    static Stack<Integer> stack;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        N = read();
        nodes = new Node[N+1];
        lists = new ArrayList[N+1];
        stack = new Stack<>();
        visited = new boolean[N+1];
        for(int i = 1; i <= N ;i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            int a = read();
            int b = read();
            lists[a].add(b);
            lists[b].add(a);
        }

        visited[1] = true;

        dfs(1, 1, 1);

        int M = read();

        for(int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            System.out.println(find(nodes[a], nodes[b]));
        }
    }

    private static void dfs(int start, int depth, int parent) {
        nodes[start] = new Node(depth, start, parent);
        for(int i : lists[start]) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, depth + 1, start);
            visited[i] = false;

        }
    }

    private static void union(Node x, Node y) {
        if(x.depth < y.depth) {
            y.depth = x.depth + 1;
            nodes[x.value] = y;
            return;
        }
        x.depth = y.depth + 1;
        nodes[y.value] = x;
    }
    private static int find(Node x, Node y) {
        if(x.value == y.value) {
            return x.value;
        }
        if(x.depth == y.depth) {
            return find(nodes[x.parent], nodes[y.parent]);
        } else if(x.depth < y.depth) {
            return find(x, nodes[y.parent]);
        }
        return find(nodes[x.parent], y);
    }

    public static class Node {
        int depth;
        int value;
        int parent;

        public Node(int depth, int value, int parent) {
            this.depth = depth;
            this.value = value;
            this.parent = parent;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

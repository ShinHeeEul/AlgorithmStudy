import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BFS(N, K);

        bw.flush();
        bw.close();
    }

    private static void BFS(int N, int K) {
        visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(visited[n.val]) continue;
            visited[n.val] = true;
            if(n.val == K) {
                System.out.println(n.depth);
                return;
            }
            //queue에 들어간 값이면 out
            if(n.val+1 <= 100000) queue.add(new Node(n.val + 1, n.depth+1));
            if(n.val-1 >= 0) queue.add(new Node(n.val -1, n.depth + 1));
            if(n.val*2 <= 100000) queue.add(new Node(n.val * 2, n.depth + 1));

        }
    }

    public static class Node {
        int val;
        int depth;

        public Node(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }


}
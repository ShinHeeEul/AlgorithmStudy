import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] maps;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};
    static boolean[][][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        maps = new boolean[N+2][M+2];
        visited = new boolean[N+2][M+2][2];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                maps[i][j] = (System.in.read()=='1');
            }
            System.in.read();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1,0, false));

        boolean b = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int ni = node.i;
            int nj = node.j;

            if(ni == N && nj == M) {
                System.out.println(node.count + 1);
                b = false;
                break;
            }


            for(int i = 0; i < 4; i++) {
                Node tmp = new Node(ni + di[i], nj + dj[i],node.count + 1, node.crash);
                if(check(tmp)) {
                    int crash = tmp.crash?1:0;
                    visited[tmp.i][tmp.j][crash] = true;
                    queue.add(tmp);
                }
            }
        }

        if(b) System.out.println(-1);
    }


    private static boolean check(Node node) {
        int i = node.i;
        int j = node.j;
        int crash = node.crash?1:0;
        if(i > N || i <= 0 || j > M || j <= 0) return false;

        if(maps[i][j]) {
            if(node.crash) return false;
            node.crash = true;
        }

        if(visited[i][j][crash]) return false;

        return true;
    }



    private static class Node {
        int i, j;
        int count;
        boolean crash;

        public Node(int i, int j, int count, boolean crash) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.crash = crash;
        }

    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}

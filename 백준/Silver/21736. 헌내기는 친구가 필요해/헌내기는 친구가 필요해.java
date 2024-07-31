import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int count = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        //0 : 갈 수 X, 1 : 사람, 2 : 갈 수 O
        arr = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];
        int startI = 0, startJ = 0;
        Arrays.fill(visited[0], true);
        for(int i = 1; i < N+1; i++) {
            visited[i][0] = true;
            visited[i][M+1] = true;
            for(int j = 1; j < M+1; j++) {
                char c = (char) System.in.read();
                if(c == 'I') {
                    startI = i;
                    startJ = j;
                    arr[i][j] = 2;
                }
                if(c == 'P') {
                    arr[i][j] = 1;
                }
                if(c == 'O') {
                    arr[i][j] = 2;
                }
            }
            System.in.read();
        }
        Arrays.fill(visited[N+1], true);

        bfs(new Node(startI, startJ));

        System.out.println(count == 0? "TT": count);

    }

    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.i][start.j] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int i = node.i;
            int j = node.j;

            if(arr[i][j] == 1) count++;

            for(int a = 0; a < 4; a++) {
                int ti = i+di[a];
                int tj = j+dj[a];
                if(visited[ti][tj] || arr[ti][tj] == 0) continue;
                visited[ti][tj] = true;
                queue.add(new Node(ti, tj));
            }
        }
    }

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}
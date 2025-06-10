import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        int[][] map = new int[N][M];
        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        int si = read()-1;
        int sj = read()-1;
        int ei = read()-1;
        int ej = read()-1;

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(si, sj,0, true));


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = read();
            }
        }

        boolean[][][] visited = new boolean[N][M][2];

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.i == ei && node.j == ej) {
                System.out.println(node.count);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int ii = node.i + di[i];
                int jj = node.j + dj[i];
                if( ii >= 0 && ii < N && jj >= 0 && jj < M && !visited[ii][jj][node.canBreak?0:1]) {
                    if(map[ii][jj] == 0) {
                        visited[ii][jj][node.canBreak?0:1] = true;
                        queue.add(new Node(ii,jj,node.count + 1,node.canBreak));
                    } else if(map[ii][jj] == 1 && node.canBreak) {
                        visited[ii][jj][1] = true;
                        queue.add(new Node(ii, jj, node.count + 1, false));
                    }
                }
            }
        }
        System.out.println(-1);
    }


    static class Node {
        int i;
        int j;
        int count;
        boolean canBreak;

        public Node(int i, int j, int count, boolean canBreak) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.canBreak = canBreak;
        }
    }


    private static int read() throws Exception {
        int d, o;
        d = System.in.read();

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return o;
    }

}

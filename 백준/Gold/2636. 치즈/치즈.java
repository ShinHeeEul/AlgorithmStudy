import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int ans;
    static int before;
    static int NOT = Integer.MIN_VALUE;
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
       int N = read();
       int M = read();

       arr = new int[N+2][M+2];

       Arrays.fill(arr[0], NOT);

        for(int i = 1; i < N + 1 ; i++) {
            arr[i][0] = NOT;
            arr[i][M+1] = NOT;
            for(int j = 1; j < M + 1 ; j++) {
                arr[i][j] = read();
            }
        }
        before = 0;
        Arrays.fill(arr[N+1], NOT);
        int cnt = 0;
        while(count != (N * M)) {
            cnt++;
            count = 0;
            ans = 0;
            visited = new boolean[N+2][M+2];
            bfs();
            if(ans == 0) continue;
            before = ans;
        }
        System.out.println(cnt - 1);
        System.out.println(before);
    }

    private static void bfs() {
        Queue<Node> pq = new LinkedList<>();

        pq.add(new Node(1,1));
        visited[1][1] = true;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;
            count++;

            for(int a = 0; a < 4; a++) {
                int ii = i + di[a];
                int jj = j + dj[a];
                if(!visited[ii][jj] && (arr[ii][jj] != NOT)) {
                    visited[ii][jj] = true;
                    if(arr[ii][jj] != 1) {
                        pq.add(new Node(ii, jj));
                    } else {
                        ans++;
                    }
                    arr[ii][jj]--;
                }
            }
        }

    }

    private static class Node {
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
import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int N;
    static boolean[][] visited;
    static Node start;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int eat = 0;

        map = new int[N][N];

        StringTokenizer st;
        start = null;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    start = new Node(i,j,2, 0);
                    map[i][j] = 0;
                }
            }
        }

        boolean b = false;
        while(!b) {
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(start);
            visited = new boolean[N][N];
            visited[start.i][start.j] = true;
            b = true;
            while(!queue.isEmpty()) {
                Node n = queue.poll();
                if(n.val != 0 && start.val > n.val) {
                    b = false;
                    map[n.i][n.j] = 0;
                    start.i = n.i;
                    start.j = n.j;
                    start.count = n.count;
                    eat++;
                    if(start.val == eat) {
                        start.val++;
                        eat = 0;
                    }
                    break;
                }

                int x = n.i - 1;
                int y = n.j;
                if(check(x,y)) {
                    queue.add(new Node(x,y,map[x][y], n.count+1));
                    visited[x][y] = true;
                }

                x = n.i;
                y = n.j - 1;
                if(check(x,y)) {
                    queue.add(new Node(x,y,map[x][y], n.count+1));
                    visited[x][y] = true;
                }

                x = n.i;
                y = n.j + 1;
                if(check(x,y)) {
                    queue.add(new Node(x,y,map[x][y], n.count + 1));
                    visited[x][y] = true;
                }

                x = n.i + 1;
                y = n.j;
                if(check(x,y)) {
                    queue.add(new Node(x,y,map[x][y], n.count + 1));
                    visited[x][y] = true;
                }
            }
        }
        System.out.println(start.count);
    }

    public static boolean check(int x, int y) {

        if((x < 0) ||
                (y < 0) ||
                (x > N-1) ||
                (y > N-1)) {
            return false;
        } else if(visited[x][y]) {
            return false;
        } else if(map[x][y] > start.val) {
            return false;
        }
        return true;
    }

    static class Node implements Comparable<Node> {
        int i;
        int j;
        int val;
        int count;
        public Node(int i, int j, int val, int count) {
            this.i = i;
            this.j = j;
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            int thisNum =  this.count  * 100 + this.i * 10 + this.j;
            int oNum = o.count * 100 + o.i * 10 + o.j;
            if(thisNum > oNum) {
                return 1;
            }
            return -1;
        }
    }

}

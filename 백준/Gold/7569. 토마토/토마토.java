import java.io.*;
import java.util.*;

public class Main {

    static Node[][][] map;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int Z;
    static Queue<Node> queue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        map = new Node[Z][N][M];
        queue = new LinkedList<>();
        visited = new boolean[Z][N][M];

        for (int k = 0; k < Z; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[k][i][j] = new Node(i, j, k, num, 0);
                    if (num == 1) {
                        queue.add(map[k][i][j]);
                        visited[k][i][j] = true;
                    }
                }
            }
        }
        int ans = BFS();
        for(int k = 0; k < Z; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j].val == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(ans);
        bw.flush();
        bw.close();
    }

    private static int BFS() {
        Node n = new Node(0,0,0,0, 0);
        while(!queue.isEmpty()) {
            n = queue.poll();
            Node tmp = null;
            int i = n.i+1;
            int j = n.j;
            int k = n.k;
            if(check(i,j,k)) {
                tmp = new Node(i,j,k, 1, n.count + 1);
                queue.add(tmp);
                map[k][i][j] = tmp;
                visited[k][i][j] = true;
            }
            i = n.i-1;
            j = n.j;
            k = n.k;
            if(check(i,j,k)) {
                tmp = new Node(i,j,k, 1, n.count + 1);
                queue.add(tmp);
                map[k][i][j] = tmp;
                visited[k][i][j] = true;
            }
            i = n.i;
            j = n.j+1;
            k = n.k;
            if(check(i,j,k)) {
                tmp = new Node(i,j,k, 1, n.count + 1);
                queue.add(tmp);
                map[k][i][j] = tmp;
                visited[k][i][j] = true;
            }
            i = n.i;
            j = n.j-1;
            k = n.k;
            if(check(i,j,k)) {
                tmp = new Node(i,j,k, 1, n.count + 1);
                queue.add(tmp);
                map[k][i][j] = tmp;
                visited[k][i][j] = true;
            }
            i = n.i;
            j = n.j;
            k = n.k+1;
            if(check(i,j,k)) {
                tmp = new Node(i,j,k, 1, n.count + 1);
                queue.add(tmp);
                map[k][i][j] = tmp;
                visited[k][i][j] = true;
            }
            i = n.i;
            j = n.j;
            k = n.k-1;
            if(check(i,j,k)) {
                tmp = new Node(i,j,k, 1, n.count + 1);
                queue.add(tmp);
                map[k][i][j] = tmp;
                visited[k][i][j] = true;
            }
        }
        return n.count;
    }

    private static boolean check(int i , int j, int k) {
        if((i < 0) || (i > N-1) || (j < 0) || (j > M-1) || (k < 0) || (k > Z-1)) {
            return false;
        }
        if(visited[k][i][j]) {
            return false;
        }
        if(map[k][i][j].val == -1) {
            return false;
        }
        return true;
    }

    private static class Node {
        int k;
        int i;
        int j;
        int val;
        int count;

        public Node(int i,int j,int k, int val, int count) {
            this.k = k;
            this.i = i;
            this.j = j;
            this.val = val;
            this.count = count;
        }
    }


}
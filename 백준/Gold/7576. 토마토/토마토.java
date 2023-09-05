import java.io.*;
import java.util.*;

public class Main {

    static Node[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static Queue<Node> queue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new Node[N][M];
        queue = new LinkedList<>();
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = new Node(i,j,num,0);
                if(num == 1) {
                    queue.add(map[i][j]);
                    visited[i][j] = true;
                }
            }
        }
        int ans = BFS();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j].val == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
        bw.flush();
        bw.close();
    }

    private static int BFS() {
        Node n = new Node(0,0,0,0);
        while(!queue.isEmpty()) {
            n = queue.poll();
            Node tmp = null;
            if(check(n.i+1,n.j)) {
                tmp = new Node(n.i+1, n.j, 1, n.count + 1);
                queue.add(tmp);
                map[n.i+1][n.j] = tmp;
                visited[n.i+1][n.j] = true;
            }
            if(check(n.i-1,n.j)) {
                tmp = new Node(n.i-1, n.j, 1, n.count + 1);
                queue.add(tmp);
                map[n.i-1][n.j] = tmp;
                visited[n.i-1][n.j] = true;
            }
            if(check(n.i,n.j+1)) {
                tmp = new Node(n.i, n.j+1, 1, n.count + 1);
                queue.add(tmp);
                map[n.i][n.j+1] = tmp;
                visited[n.i][n.j+1] = true;
            }
            if(check(n.i,n.j-1)) {
                tmp = new Node(n.i, n.j-1, 1, n.count + 1);
                queue.add(tmp);
                map[n.i][n.j-1] = tmp;
                visited[n.i][n.j-1] = true;
            }
        }
        return n.count;
    }

    private static boolean check(int i , int j) {
        if((i < 0) || (i > N-1) || (j < 0) || (j > M-1)) {
            return false;
        }
        if(visited[i][j]) {
            return false;
        }
        if(map[i][j].val == -1) {
            return false;
        }
        return true;
    }

    private static class Node {
        int i;
        int j;
        int val;
        int count;

        public Node(int i,int j,int val, int count) {
            this.i = i;
            this.j = j;
            this.val = val;
            this.count = count;
        }
    }


}
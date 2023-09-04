import java.io.*;
import java.util.*;

public class Main {

    static Node[][] map;
    static int[][] ans;
    static boolean[][] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Node[N][M];
        ans = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(ans[i], -1);
        }
        int sI = 0;
        int sJ = 0;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 2) {
                    sI = i;
                    sJ = j;
                }
                if(num == 0) {
                    ans[i][j] = 0;
                }
                map[i][j] = new Node(i,j,num);
            }
        }

        BFS(sI, sJ);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(ans[i][j] + "");
                if(j != M-1) {
                    bw.write(" ");
                }
            }
            if(i != N-1) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void BFS(int sI, int sJ) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(map[sI][sJ]);

        ans[sI][sJ] = 0;
        visited[sI][sJ] = true;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(check(n.i+1,n.j)) {
                ans[n.i+1][n.j] = ans[n.i][n.j] + 1;
                queue.add(new Node(n.i+1, n.j, 1));
                visited[n.i+1][n.j] = true;
            }
            if(check(n.i-1,n.j)) {
                ans[n.i-1][n.j] = ans[n.i][n.j] + 1;
                queue.add(new Node(n.i-1, n.j, 1));
                visited[n.i-1][n.j] = true;
            }
            if(check(n.i,n.j+1)) {
                ans[n.i][n.j+1] = ans[n.i][n.j] + 1;
                queue.add(new Node(n.i, n.j+1, 1));
                visited[n.i][n.j+1] = true;
            }
            if(check(n.i,n.j-1)) {
                ans[n.i][n.j-1] = ans[n.i][n.j] + 1;
                queue.add(new Node(n.i, n.j-1, 1));
                visited[n.i][n.j-1] = true;
            }
        }
    }

    private static boolean check(int i , int j) {
        if((i < 0) || (i > N-1) || (j < 0) || (j > M-1)) {
            return false;
        }
        if(visited[i][j]) {
            return false;
        }
        if(map[i][j].val == 0) {
            return false;
        }
        return true;
    }

    private static class Node {
        int i;
        int j;
        int val;

        public Node(int i,int j,int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }


}
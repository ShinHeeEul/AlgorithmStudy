import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int[][] board;
    static int N;
    static int M;
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0, 0);

        System.out.println(max);
    }

    public static void backTracking(int count, int startI, int startJ) {

        if(count == 3) {
            int[][] boards = new int[N][M];
            for(int i = 0; i < N; i++) {
                boards[i] = board[i].clone();
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(board[i][j] == 2) {
                        //BFS
                        BFS(i,j, boards);
                    }
                }
            }
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(boards[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
            }
            return;
        }

        int i = startI;
        int j = startJ;

        for(; i < N; i++) {
            for(; j < M; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    backTracking(count + 1, i, j+1);
                    board[i][j] = 0;
                }
            }
            j = 0;
        }


    }
    public static boolean check(int x, int y, int[][] boards) {
        if(x < 0 || x >= M || y < 0 || y >= N) {
            return false;
        }
        return boards[y][x] != 2 && boards[y][x] != 1;
    }

    public static void BFS(int i , int j, int[][] boards) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i,j,2));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            int x = n.j+1;
            int y = n.i;
            if(check(x,y, boards)) {
                boards[y][x] = 2;
                queue.add(new Node(y,x,2));
            }

            x = n.j-1;
            y = n.i;
            if(check(x,y, boards)) {
                boards[y][x] = 2;
                queue.add(new Node(y,x,2));
            }

            x = n.j;
            y = n.i+1;
            if(check(x,y, boards)) {
                boards[y][x] = 2;
                queue.add(new Node(y,x,2));
            }

            x = n.j;
            y = n.i-1;
            if(check(x,y, boards)) {
                boards[y][x] = 2;
                queue.add(new Node(y,x,2));
            }
        }

    }

    static class Node {
        int i;
        int j;
        int val;
        public Node(int i , int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}

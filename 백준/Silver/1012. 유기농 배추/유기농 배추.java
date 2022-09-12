import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int node[][]; // 그래프 배열
    static int check[]; // 방문 배열

    static int N;
    static int M;

    static void bfs(int start) { // BFS 메소드
        Queue<Integer> queue = new LinkedList<>();

        System.out.print(start + " ");
        check[start] = 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 1; i < node.length; i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
                if (node[x][i] == 1 && check[i] != 1) {
                    System.out.print(i + " ");
                    check[i] = 1;
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(int j, int k) {

        if(k < M-1) {
            if (node[j][k + 1] == 1) {
                node[j][k+1] = 0;
                dfs(j, k + 1);
            }
        }
        if(j < N-1) {
            if (node[j + 1][k] == 1) {
                node[j+1][k] = 0;
                dfs(j + 1, k);
            }
        }
        if(k > 0) {
            if(node[j][k-1] == 1) {
                node[j][k-1] = 0;
                dfs(j,k-1);
            }
        }
        if(j > 0) {
            if(node[j-1][k] == 1) {
                node[j-1][k] = 0;
                dfs(j-1,k);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =  Integer.parseInt(br.readLine());

        for(int i =0 ; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");


            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int sum = 0;

            node = new int[N][M];

            for(int j = 0; j < K; j++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    node[a][b] = 1;
            }
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(node[j][k] == 1) {
                        sum++;
                        dfs(j,k);
                    }
                }
            }
            System.out.println(sum);
        }


    }

}
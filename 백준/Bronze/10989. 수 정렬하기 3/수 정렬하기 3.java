import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


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

    public static int gcd(int a, int b) {
        if(b== 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
    static Integer[][] dp = new Integer[41][2];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];

        for(int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())] ++;
        }

        for(int i = 0; i < 10001;  i++) {
            while(cnt[i] > 0) {
                bw.write(i + "\n");
                cnt[i]--;
            }
        }
        bw.flush();
    }

}
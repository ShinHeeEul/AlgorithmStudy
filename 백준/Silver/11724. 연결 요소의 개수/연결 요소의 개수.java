import java.io.*;
import java.util.*;

public class Main {

    static int[][] A;
    static int count;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u][v] = 1;
            A[v][u] = 1;
        }
        count = 0;
        check = new int[N+1];
        // count를 1 증가시키고
        // dfs로 탐색하고(check 값도 check하고)
        // 다음 check값 체크 안되있는 부분 찾아서 다시 dfs
        // 이 과정은 check 0부터 N까지

        for(int i = 1; i < N+1; i++) {
            if(check[i] != 0) continue;
            count++;
            dfs(i);
        }

        System.out.println(count);

        bw.flush();
        bw.close();
    }

    private static void dfs(int i) {

        //stack에 초기값을 넣고
        //해당 초기값과 연결되어있는 값들을 내림차순으로 넣고
        //pop해서 반복하고 -> stack이 빌때까지
        Stack<Integer> stack = new Stack<>();
        stack.push(i);

        while(!stack.isEmpty()) {
            int k = stack.pop();
            //이미 방문한 녀석이라면 방문안하귀
            if(check[k] != 0) continue;
            //방문 안한 녀석 상대로 체크
            check[k] = 1;
            for (int j = check.length-1; j > 0; j--) if(A[k][j] == 1) stack.push(j);

        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] node = new int[N+1][N+1];
        int[] check = new int[N+1];

        for(int i = 0 ; i< M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
        }

        //시작 위치 : a, 도착 위치 : b
        //dfs

        int current = V;
        Stack<Integer> stack = new Stack<>();
        stack.add(current);
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            if(check[tmp] == 0) {
                System.out.print(tmp + " ");
                check[tmp] = 1;
            }
            current = tmp;
            for(int j = N; j > 0; j--) {
                if((check[j] == 0) && (node[current][j] == 1)) stack.add(j);
            }
        }

        System.out.println();

       //bfs
       current = V;
       check = new int[N+1];
       Queue<Integer> queue = new LinkedList<>();
       queue.add(current);
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            if(check[tmp] == 0) {
                System.out.print(tmp + " ");
                check[tmp] = 1;
            }
            current = tmp;
            for(int j = 1; j < N+1; j++) {
                if((check[j] == 0) && (node[current][j] == 1)) queue.add(j);
            }

        }


        bw.flush();
        bw.close();
    }

}
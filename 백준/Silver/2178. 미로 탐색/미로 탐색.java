import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+2][M+2];

        //그래프 생성
        for(int i = 0; i < N;i++) {
            String S = br.readLine();
            for(int j = 0; j < M; j++)
                arr[i+1][j+1] = Integer.parseInt(String.valueOf(S.charAt(j)));
        }

        //큐 생성 후 초깃값 설정

        Queue<Node> queue = new LinkedList<>();
        int ans = 10000000;

        queue.add(new Node(1,1,1));

        //queue가 빌때까지 while
        while(!queue.isEmpty()) {

            Node n = queue.poll();
            //끝났을 때 검사
            if((n.x == M) && (n.y == N)) {
                if(n.count < ans) ans = n.count;
                break;
            }

            //BFS 진행
            //동서남북 순
            if(arr[n.y + 1][n.x] == 1){
                queue.add(new Node(n.x, n.y+1, n.count+1));
                arr[n.y+1][n.x] = 0;
            }
            if(arr[n.y - 1][n.x] == 1)
            {
                queue.add(new Node(n.x, n.y-1, n.count+1));
                arr[n.y-1][n.x] = 0;
            }
            if(arr[n.y][n.x+1] == 1) {
                queue.add(new Node(n.x + 1, n.y, n.count + 1));
                arr[n.y][n.x] = 0;
            }
            if(arr[n.y][n.x-1] == 1) {
                queue.add(new Node(n.x - 1, n.y, n.count + 1));
                arr[n.y][n.x] = 0;
            }

        }

        System.out.println(ans);

        bw.flush();
        bw.close();
    }

    private static class Node {

        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int node[][]; // 그래프 배열
    static int check[]; // 방문 배열
    static void bfs(int start) { // BFS 메소드
        Queue<Integer> queue = new LinkedList<>();

        check[start] =1;
        queue.offer(start);
        int cnt = 0; // 감염 된 컴퓨터의 수
        while(!queue.isEmpty()) {
            int x = queue.poll();

            for(int i=1;i<node.length;i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
                if(node[x][i]==1 && check[i]!=1) {
                    queue.offer(i);
                    check[i] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt); //모든 탐색을 마치고 cnt 출력
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        BigInteger n = new BigInteger(br.readLine());
        BigInteger m = new BigInteger(br.readLine());

        System.out.println(n.add(m));
        System.out.println(n.subtract(m));
        System.out.println(n.multiply(m));


    }

}
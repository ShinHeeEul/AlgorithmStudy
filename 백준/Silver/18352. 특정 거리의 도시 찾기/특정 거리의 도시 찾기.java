import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static int K;

    static boolean[] check;
    static boolean c = true;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        check = new boolean[N+1];
        //초기화
        for(int i = 1; i < N+1; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }

        check[X] = true;
        int[] list = new int[N+1];
        //BFS로 탐색
        queue.add(new Node(X, 0));
        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(n.count == K) {
                list[n.i] = n.i;
                c = false;
            }

            BFS(n.i, n.count);
        }
        if(c) System.out.println(-1);
        else {
            Arrays.sort(list);
            for(int i : list) {
                if(i != 0) System.out.println(i);
            }
        }
        bw.flush();
        bw.close();

    }

    private static void BFS(int X, int count) {
        //X와 연결된 값이면 count 값 1 증가 시키고 연결된 값 넣음.
        // count 값이 K면 출력하고 반환


            for (int i : arr[X]) {
                if (check[i]) continue;
                queue.add(new Node(i, count + 1));
                check[i] = true;
            }



    }

    static class Node {
        int i;
        int count;

        public Node(int i, int count) {
            this.i = i;
            this.count = count;
        }
    }
}
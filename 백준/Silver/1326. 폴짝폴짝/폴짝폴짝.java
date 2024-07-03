import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    public static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            int index = n.index;
            if(index >= arr.length || index <= 0) continue;
            if(visited[index]) continue;
            visited[index] = true;
            int nCount = n.count;
            int val = arr[index];
            if(index == b) {
                System.out.println(nCount);
                return;
            }

            int cnt = 0;
            while((index + val * cnt) < arr.length || (index - val * cnt) > 0) {
                cnt++;
                queue.add(new Node(index + val * cnt, nCount + 1));
                queue.add(new Node(index - val * cnt, nCount + 1));
            }
        }

        System.out.println(-1);
    }

    public static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

}

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int N;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = read();
        int M = read();
        int V = read();

        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++) {
            int from = read();
            int to = read();
            list[from].add(to);
            list[to].add(from);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        bw.write("\n");
        bfs(V);
        bw.flush();
    }

    public static void dfs(int a) throws IOException {
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stack = new Stack<>();

        stack.push(a);

        while(!stack.isEmpty()) {
            int pop = stack.pop();

            if(visited[pop]) continue;
            visited[pop] = true;
            bw.write(pop + " ");
            int size = list[pop].size();
            for(int i = size-1; i >= 0; i--) {
                stack.push(list[pop].get(i));
            }
        }
    }

    public static void bfs(int a) throws IOException {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(a);
        visited[a] = true;

        while(!queue.isEmpty()) {
            int pop = queue.poll();
            bw.write(pop + " ");
            for(int i : list[pop]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int N;
    public static void main(String[] args) throws Exception {
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

        dfs(V);
        System.out.println();
        bfs(V);
    }

    public static void dfs(int a) {
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stack = new Stack<>();

        stack.push(a);

        while(!stack.isEmpty()) {
            int pop = stack.pop();

            if(visited[pop]) continue;
            visited[pop] = true;
            System.out.print(pop + " ");
            Collections.sort(list[pop], Collections.reverseOrder());
            for(int i : list[pop]) {
                    stack.push(i);
            }
        }
    }

    public static void bfs(int a) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(a);
        visited[a] = true;

        while(!queue.isEmpty()) {
            int pop = queue.poll();
            System.out.print(pop + " ");

            Collections.sort(list[pop]);
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
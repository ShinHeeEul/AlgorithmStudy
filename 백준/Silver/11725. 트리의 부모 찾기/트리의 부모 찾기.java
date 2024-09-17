import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws Exception {
       int N = read();

       lists = new ArrayList[N + 1];
       visited = new boolean[N + 1];
       parents = new int[N + 1];

       for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();

       for(int i = 1; i < N; i++) {
           int a = read();
           int b = read();

           lists[a].add(b);
           lists[b].add(a);
       }

       Queue<Integer> queue = new LinkedList<>();
       queue.add(1);
       visited[1] = true;

       while(!queue.isEmpty()) {
           int parent = queue.poll();

           for(int node : lists[parent]) {
               if(!visited[node]) {
                   visited[node] = true;
                   parents[node] = parent;
                   queue.add(node);
               }
           }
       }

       for(int i = 2; i <= N; i++) {
           System.out.println(parents[i]);
       }
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}

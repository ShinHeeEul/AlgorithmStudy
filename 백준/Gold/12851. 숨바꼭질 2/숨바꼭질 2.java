import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int time = 0;
    static boolean b = false;
    static boolean[] visited;
    static Queue<Node> queue;
    static int max = 100_000;
    static int cnt = 0;
    static int K;
    public static void main(String[] args) throws Exception {
        int N = read();
        K = read();

        queue = new LinkedList<>();
        visited = new boolean[max + 1];
        queue.add(new Node(N, 0));


        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int count = node.count;
            int x = node.x;

            visited[x] = true;
            if(b && time != count) break;

            if(x == K) {
                cnt++;
                time = count;
                b = true;
            }

            calculate(x + 1, count + 1);
            calculate(x - 1, count + 1);
            calculate(2 * x, count + 1);
        }

        System.out.println(time);
        System.out.println(cnt);

    }

    public static void calculate(int next, int count) {
        if(next < 0 || next > max) return;
        if(visited[next]) return;
        queue.add(new Node(next, count));
    }

    public static class Node {
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }



    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}
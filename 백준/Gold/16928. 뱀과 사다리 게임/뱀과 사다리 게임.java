import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        visited = new boolean[101];

        for(int i = 0; i < N ; i++) {
            map.put(read(), read());
        }

        for(int i = 0; i < M; i++) {
            map.put(read(), read());
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(1, 0));
        visited[1] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int val = node.val;
            int count = node.count;
            if(val == 100) {
                return count;
            }

            for(int i = 1; i <= 6; i++) {
                int tmp = val + i;

                if(tmp > 100) {
                    break;
                }
                if(visited[tmp]) {
                    continue;
                }
                visited[tmp] = true;
                queue.add(new Node(map.getOrDefault(tmp, tmp), count + 1));
            }
        }
        return 0;
    }

    public static class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
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
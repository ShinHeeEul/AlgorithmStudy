import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,1,-1};
    static Map<Node, Boolean> visited = new HashMap<>();
    public static void main(String[] args) throws Exception {

        int N = read();
        map = new int[N][N];


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = read();
            }
        }

        System.out.println(bfs() ? "HaruHaru" : "Hing");
    }

    public static boolean bfs() {
        int si = 0;
        int sj = 0;

        Queue<Node> queue = new LinkedList<>();

        visited.put(new Node(si, sj), true);
        queue.add(new Node(si, sj));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            int i = n.x;
            int j = n.y;
            int val = map[i][j];
            if(val == -1) return true;
            for(int a = 0; a < 4; a++) {
                int ni = i + di[a] * val;
                int nj = j + dj[a] * val;
                if(check(ni, nj)) {
                    Node next = new Node(ni, nj);
                    if(!visited.getOrDefault(next, false)) {
                        visited.put(next, true);
                        queue.add(next);
                    }
                }
            }
        }

        return false;
    }

    public static boolean check(int i, int j) {
        return i >= 0 && i < map.length && j >= 0 && j < map[i].length;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Node n = (Node) o;
            return this.x == n.x && this.y == n.y;
        }



        @Override
        public int hashCode() {
            return 1;
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
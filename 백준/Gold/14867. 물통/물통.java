import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int A;
    static int B;
    static int C;
    static int D;
    static HashMap<Node, Boolean> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        A = read();
        B = read();
        C = read();
        D = read();

        bfs();
    }

    public static class Node {
        int A;
        int B;
        int count;
        Node(int A, int B, int count) {
            this.A = A;
            this.B = B;
            this.count = count;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            return (A == n.A) && (B == n.B);
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        Node start = new Node(0,0, 0);
        queue.add(start);
        map.put(start, true);

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if((n.A == C) && (n.B == D)) {
                System.out.println(n.count);
                return;
            }

            // F(X) : 물통 X를 가득 채움
            Node node = new Node(A , n.B, n.count + 1);
            if(!map.getOrDefault(node, false)) {
                map.put(node, true);
                queue.add(node);
            }
            node = new Node(n.A, B, n.count + 1);
            if(!map.getOrDefault(node, false)) {
                map.put(node, true);
                queue.add(node);
            }
            // E(X) : 물통 X를 비움
            node = new Node(0, n.B, n.count + 1);
            if(!map.getOrDefault(node, false)) {
                map.put(node, true);
                queue.add(node);
            }
            node = new Node(n.A, 0, n.count + 1);
            if(!map.getOrDefault(node, false)) {
                map.put(node, true);
                queue.add(node);
            }
            //M(x,y) : 물통 X to 물통 Y
            node = move(n, true);
            if(!map.getOrDefault(node, false)) {
                map.put(node, true);
                queue.add(node);
            }
            node = move(n, false);
            if(!map.getOrDefault(node, false)) {
                map.put(node, true);
                queue.add(node);
            }
        }

        System.out.println(-1);
    }

    private static Node move(Node node, boolean check) {
        int x = check?node.A:node.B;
        int y = check?node.B:node.A;
        //x를 y에 부우려면?
        //x에 있는 사이즈와 y에 남은 사이즈 중 더 작은 값을 체크하고
        //x에서 그 값 빼주고
        //y에서 그 값 더해주고
        int min = Math.min(x, (check?B:A) - y);

        return new Node(check?(x - min):(y + min), check?(y + min):(x - min), node.count + 1);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;

    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int A;
    static int B;
    static int C;
    static int D;
    static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        A = read();
        B = read();
        C = read();
        D = read();

        if ((A == C && B == D) || (A == D && B == C)) {
            System.out.println(2);
            return;
        }
        int gcd = gcd(Math.min(A, B), Math.max(A, B));
        if ((C % gcd == 0) || (C == 0) || (D % gcd == 0) || (D == 0)) {
            bfs();
            return;
        }


        System.out.println(-1);
    }

    public static int gcd(int a, int b) {
        int gcd = 1;
        for(int i = a; i >= 1; i--) {
            if ((b % i == 0) && (a % i == 0)) {
                gcd *= i;
                b /= i;
                a /= i;
            }
        }
        return gcd;
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
        HashSet<Integer> tmp = map.getOrDefault(start.A, new HashSet<>());
        tmp.add(0);
        map.put(start.A, tmp);

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if((n.A == C) && (n.B == D)) {
                System.out.println(n.count);
                return;
            }

            // F(X) : 물통 X를 가득 채움
            Node node = new Node(A , n.B, n.count + 1);
            tmp = map.getOrDefault(node.A, new HashSet<>());
            if(!tmp.contains(node.B)) {
                tmp.add(node.B);
                queue.add(node);
                map.put(node.A, tmp);
            }
            node = new Node(n.A, B, n.count + 1);
            tmp = map.getOrDefault(node.A, new HashSet<>());
            if(!tmp.contains(node.B)) {
                tmp.add(node.B);
                queue.add(node);
                map.put(node.A, tmp);
            }
            // E(X) : 물통 X를 비움
            node = new Node(0, n.B, n.count + 1);
            tmp = map.getOrDefault(node.A, new HashSet<>());
            if(!tmp.contains(node.B)) {
                tmp.add(node.B);
                queue.add(node);
                map.put(node.A, tmp);
            }
            node = new Node(n.A, 0, n.count + 1);
            tmp = map.getOrDefault(node.A, new HashSet<>());
            if(!tmp.contains(node.B)) {
                tmp.add(node.B);
                queue.add(node);
                map.put(node.A, tmp);
            }
            //M(x,y) : 물통 X to 물통 Y
            node = move(n, true);
            tmp = map.getOrDefault(node.A, new HashSet<>());
            if(!tmp.contains(node.B)) {
                tmp.add(node.B);
                queue.add(node);
                map.put(node.A, tmp);
            }
            node = move(n, false);
            tmp = map.getOrDefault(node.A, new HashSet<>());
            if(!tmp.contains(node.B)) {
                tmp.add(node.B);
                queue.add(node);
                map.put(node.A, tmp);
            }
        }

        System.out.println(-1);
    }

    private static Node move(Node node, boolean check) {
        int x = check?node.A:node.B;
        int y = check?node.B:node.A;
        int min = Math.min(x, (check?B:A) - y);
        int minusX = x - min;
        int plusY = y + min;
        return new Node(check?minusX:plusY, check?plusY:minusX, node.count + 1);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();


        Node[] nodes = new Node[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int s = read();
            int t = read();

            nodes[i] = new Node(s, t);
        }

        Arrays.sort(nodes, (o1, o2) -> o2.t - o1.t);
        pq.add(nodes[0]);

        for(int i = 1; i < N; i++) {
            Node inputNode = nodes[i];
            Node node = pq.peek();

            if(node.s >= inputNode.t) {
                pq.poll();
            }
            pq.add(inputNode);
        }

        System.out.println(pq.size());


    }

    public static class Node implements Comparable<Node>{
        int s;
        int t;

        public Node(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return o.s - this.s;
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
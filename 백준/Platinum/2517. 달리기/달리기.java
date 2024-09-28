import org.w3c.dom.Node;

import java.util.PriorityQueue;

public class Main {


    static int[] segments;
    static int size;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read();

        size = 1;
        while(size < N) {
            size <<= 1;
        }

        arr = new int[N];
        segments = new int[(size << 1) + 1];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            queue.add(new Node(i, read()));
        }

        int count = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            arr[node.index] = ++count;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int ans = query(arr[i], N, 2, 1, size);
            sb.append(ans + 1).append("\n");
            update(size + arr[i]);
        }
        System.out.println(sb);
    }

    private static class Node implements Comparable<Node>{

        int index;
        int val;
        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    private static int query(int left, int right, int node, int start, int end) {
        if(end < left || start > right) return 0;

        if(left <= start && end <= right) {
            return segments[node];
        }

        int mid = (start + end) >> 1;
        return query(left, right, (node << 1) - 1, start, mid) + query(left, right, node << 1, mid + 1, end);
    }

    private static void update(int node) {
        while(node > 1) {
            segments[node]++;
            node = (node + 1) >> 1;
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

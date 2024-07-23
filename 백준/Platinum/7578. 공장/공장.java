import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    static int[] segment;
    static int N;
    static int size;
    static LinkedHashMap<Integer, Node> map = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception {
        N = read();

        for(int i = 1; i <= N; i++) {
            int a = read();
            map.put(a, new Node(i, -1, a));
        }

        for(int i = 1; i <= N; i++) {
            int val = read();
            Node node = map.get(val);
            node.b = i;
            map.put(val, node);
        }

        size = 1;

        while(N > size) {
            size <<= 1;
        }

        segment = new int[(size << 1) + 1];

        long sum = 0;
        for(Node node : map.values()) {
            int b = node.b;
            sum += query(b,N,2,1, size);
            update(b);
        }

        System.out.println(sum);
    }

    private static long query(int left, int right, int node, int start, int end) {

        if(left > end || right < start) {
            return 0;
        }

        if(left <= start && end <= right) {
           return segment[node];
        }

        int mid = (start + end) / 2;
        return query(left, right, (node << 1) - 1, start, mid) + query(left, right, node << 1, mid + 1, end);
    }

    private static void update(int i) {
        int segmentSize = size + i;

        while(segmentSize > 1) {
            segment[segmentSize] += 1;
            segmentSize = (segmentSize + 1) >> 1;
        }

    }

    private static class Node {
        int a;
        int b;
        int val;

        public Node(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
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

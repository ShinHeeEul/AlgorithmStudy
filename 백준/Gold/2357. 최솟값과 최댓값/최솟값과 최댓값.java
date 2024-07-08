import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static Node[] segment;

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 1;
        while(size < N) {
            size <<= 1;
        }
        segment = new Node[size * 2 + 1];
        int segmentSize = segment.length;
        for(int i = 0; i < segmentSize; i++) {
            segment[i] = new Node(0, Integer.MAX_VALUE);
        }

        for(int i = size + 1; i < size + N + 1; i++) {
            int a = read();
            segment[i] = new Node(a,a);
        }

        int tmp = segmentSize-1;
        while(tmp > 1) {
            int max = Math.max(segment[tmp].max, segment[tmp - 1].max);
            int min = Math.min(segment[tmp].min, segment[tmp - 1].min);

            int index = (tmp + 1) >> 1;
            int segmentMax = segment[index].max;
            int segmentMin = segment[index].min;
            segment[index] = new Node(Math.max(segmentMax, max), Math.min(segmentMin, min));
            tmp -= 2;
        }


        for(int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            Node node = query(a,b,2, 1, size);
            bw.write(node.min + " " + node.max + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static Node query(int left, int right, int n, int start, int end) {
        if(left > end || right < start) return new Node(0, Integer.MAX_VALUE);
        if(left <= start && end <= right) return segment[n];

        int mid = (start + end) / 2;
        Node n1 = query(left, right, (n << 1) - 1, start, mid);
        Node n2 = query(left, right, n << 1, mid + 1, end);
        return new Node(Math.max(n1.max, n2.max) , Math.min(n1.min, n2.min));
    }

    public static class Node {
        int max;
        int min;

        public Node(int max, int min) {
            this.max = max;
            this.min = min;
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

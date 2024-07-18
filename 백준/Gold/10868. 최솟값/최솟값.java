import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int size;
    static int[] segments;
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        size = 1;
        while(size < N) size <<= 1;

        segments = new int[size * 2 + 1];

        Arrays.fill(segments, Integer.MAX_VALUE);

        for(int i = size + 1; i < size + N + 1; i++) {
            segments[i] = read();
        }

        int segmentSize = segments.length - 1;
        while(segmentSize > 1) {
            segments[(segmentSize + 1) >> 1] = Math.min(segments[segmentSize - 1], segments[segmentSize]);
            segmentSize -= 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            int min = Math.min(a, b);
            int max = Math.max(a, b);

            sb.append(query(min, max, 2, 1, size)).append("\n");
        }
        System.out.println(sb);
    }

    public static int query(int left, int right, int node, int start, int end) {
        if(end < left || start > right) {
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right) {
            return segments[node];
        }
        int mid = (start + end) / 2;
        return Math.min(query(left, right, (node << 1) - 1, start, mid), query(left, right, (node << 1), mid + 1, end));
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

}

import java.io.BufferedWriter;

public class Main {
    static int[] segments;
    static int size;
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        size = 1;

        while(size < N) size <<= 1;

        segments = new int[(size << 1) + 1];

        for(int i = size + 1; i < size + N + 1; i++) {
            segments[i] = read();
        }

        int segmentsSize = segments.length - 1;
        for(int i = segmentsSize; i > 2; i-= 2) {
            segments[i >> 1] = Math.max(segments[i - 1], segments[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N - M + 1; i++) {
            sb.append(query(i - (M - 1), i + (M - 1),2, 1, size)).append(" ");
        }

        System.out.println(sb);
    }

    private static int query(int left, int right, int node, int start, int end) {
        if(end < left || start > right)
            return 0;


        if(left <= start && right >= end)
            return segments[node];


        int mid = (start + end) >> 1;
        return Math.max(query(left, right, (node << 1) - 1, start, mid), query(left, right, (node << 1), mid + 1, end));
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

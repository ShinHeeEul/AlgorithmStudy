import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {


    static int[] segments;
    static int N;
    static int size;
    public static void main(String[] args) throws Exception {
        N = read();
        size = 1;
        while(size < N) {
            size <<= 1;
        }

        segments = new int[(size << 1) + 1];

        for(int i = size + 1; i < size + N + 1; i++) {
            segments[i] = read() % 2;
        }

        int segmentSize = segments.length - 1;
        for(int i = segmentSize; i > 1; i -= 2) {
            segments[i >> 1] = segments[i] + segments[i - 1];
        }

        int M = read();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int a = read();
            int l = read();
            int r = read();

            if(a == 1) {
                update(l,r);
            } else if(a == 2) {
                sb.append((r - l + 1) - query(l,r,2,1, size)).append("\n");
            } else if(a == 3) {
                sb.append(query(l,r,2,1,size)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int query(int left, int right, int node, int start, int end) {
        if(end < left || right < start) {
            return 0;
        }

        if(left <= start && end <= right) {
            return segments[node];
        }

        int mid = (start + end) >> 1;
        return query(left, right, (node << 1) - 1, start, mid) + query(left, right, node << 1, mid + 1, end);
    }

    public static void update(int a, int v) {
        a = size + a;

        segments[a] = v % 2;

        while(a > 1) {
            a = (a + 1) >> 1;
            segments[a] = segments[a << 1] + segments[(a << 1) - 1];
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

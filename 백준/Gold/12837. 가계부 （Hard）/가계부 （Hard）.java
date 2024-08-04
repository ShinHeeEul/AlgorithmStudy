import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    static long[] segments;
    static int size = 1;
    public static void main(String[] args) throws Exception {

        int N = read();
        int Q = read();

        while(size < N) {
            size <<= 1;
        }
        segments = new long[(size << 1) + 1];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            int a = read();
            int b = read();
            int c = read();

            if(a == 1) {
                update(b, c);
            } else {
                sb.append(query(b, c, 2, 1, size)).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static long query(int left, int right, int node, int start, int end) {

        if(start > right || end < left) return 0;

        if(left <= start && end <= right) {
            return segments[node];
        }

        int mid = (start + end) / 2;
        return query(left, right, (node << 1) - 1, start, mid) + query(left, right, node << 1, mid + 1, end);
    }

    private static void update(int b, int c) {
        int segmentSize = b + size;
        segments[segmentSize] += c;

        while(segmentSize > 1) {
            segmentSize = (segmentSize + 1) >> 1;
            segments[segmentSize]  = segments[segmentSize << 1] + segments[(segmentSize << 1) - 1];
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
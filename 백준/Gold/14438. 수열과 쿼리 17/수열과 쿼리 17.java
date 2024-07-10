import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static long[] segment;
    private static int size;
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();

        size = 1;

        while(size < N) {
            size <<= 1;
        }

        segment = new long[(size << 1) + 1];

        Arrays.fill(segment, Long.MAX_VALUE);

        for(int i = size + 1; i < size + N + 1; i++) {
            segment[i] = read();
        }

        int segmentSize = segment.length - 1;

        while(segmentSize > 1) {
            segment[(segmentSize + 1) >> 1] = Math.min(segment[segmentSize], segment[segmentSize - 1]);
            segmentSize -= 2;
        }

        int M = read();
        for(int idx = 0; idx < M ; idx++) {
            int a = read();
            if(a == 1) {
                int i = read();
                int v = read();
                update(i, v);
                continue;
            }

            int i = read();
            int j = read();
            long ans = query(i, j, 2, 1, size);
            bw.write(ans + "\n");

        }

        bw.flush();
    }

    private static void update(int i, int v) {
        int segmentSize = i + size;
        segment[segmentSize] = v;
        while(segmentSize > 1) {
            segmentSize = (segmentSize + 1) >> 1;
            segment[segmentSize] = Math.min(segment[segmentSize << 1], segment[(segmentSize << 1)-1]);

        }
    }

    private static long query(int left, int right, int node, int start, int end) {

        if(left > end || right < start) {
            return Long.MAX_VALUE;
        }

        if(left <= start && end <= right) {
            return segment[node];
        }

        int mid = (start + end) / 2;
        return Math.min(query(left, right, node * 2 - 1, start, mid), query(left, right, node * 2, mid + 1, end));

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

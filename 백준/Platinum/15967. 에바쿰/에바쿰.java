import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[] segment;
    static long[] lazy;
    static int size;
    public static void main(String[] args) throws Exception {
        int N =(int) read();
        int M = (int) read();
        int K = (int) read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = 1;
        while(size < N) {
            size <<= 1;
        }
        segment = new long[(size << 1) + 1];
        lazy = new long[(size << 1) + 1];

        for(int i = size + 1; i <= size + N; i++) {
            segment[i] = read();
        }

        int segmentSize = segment.length - 1;

        while(segmentSize > 1) {
            segment[ceilDiv(segmentSize)] = segment[segmentSize] + segment[segmentSize-1];
            segmentSize -= 2;
        }

        for(int m = 0; m < (M + K); m++) {
            int a = (int) read();

            if(a == 1) {
                int b = (int) read();
                int c = (int) read(); 
                long sum = query(b, c, 2,1, size);
                bw.write(sum + "\n");
                continue;
            }

            int b = (int) read();
            int c = (int) read();
            long d = read();

            updateDiff(b,c,2,1,size,d);
        }
        bw.flush();

    }

    private static void updateDiff(int left, int right, int node, int start, int end, long diff) {

        if (left > end || right < start) {
            return;
        }
        if (left <= start && end <= right) {
            lazy[node] += diff;
            long change = diff * (end - start + 1);

            int segmentSize = ceilDiv(node);
            while (segmentSize > 1) {
                segment[segmentSize] += change;
                segmentSize = ceilDiv(segmentSize);
            }
            return;
        }
        int mid = (start + end) / 2;

        updateDiff(left, right, node * 2 - 1, start ,mid, diff);
        updateDiff(left, right, node * 2, mid + 1, end, diff);
    }

    private static void updateLazy(int node) {
        long val = lazy[node];
        lazy[node] = 0;
        if(node > size) return;
        lazy[node * 2] += val;
        lazy[node * 2 - 1] += val;
    }

    private static long query(int left, int right, int node, int start, int end) {
        if(lazy[node] != 0) {
            segment[node] += lazy[node] * (end - start + 1);
            updateLazy(node);
        }

        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segment[node];
        }

        int mid = (start + end) / 2;
        return query(left, right, node * 2 - 1, start, mid) + query(left, right, node * 2, mid + 1, end);
    }

    private static int ceilDiv(int a) {
        return (a + 1) >> 1;
    }

    private static long read() throws Exception {
        long d, o;
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

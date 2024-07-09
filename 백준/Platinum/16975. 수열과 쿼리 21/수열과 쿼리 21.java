import java.io.*;

public class Main {
    static long[] segment;
    static long[] lazy;
    static int size;
    public static void main(String[] args) throws Exception {
        int N = read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = 1;
        while(size < N) {
            size <<= 1;
        }

        segment = new long[(size << 1) + 1];
        lazy = new long[(size << 1) + 1];

        for(int i = size + 1; i < size + N + 1; i++) {
            segment[i] = read();
        }

        int segmentSize = segment.length - 1;

        while(segmentSize > 1) {
            segment[(segmentSize + 1) >> 1] = segment[segmentSize] + segment[segmentSize - 1];
            segmentSize-=2;
        }

        int M = read();

        for(int i = 0; i < M ;i++) {
            int a = read();
            if(a == 2) {
                int node = read();
                query(node, node, 2, 1, size);
                bw.write(segment[size + node] + "\n");
                continue;
            }
            updateRange(read(), read(), 2, 1, size, read());
        }

        bw.flush();

    }

    private static void updateRange(int left, int right, int node, int start, int end, int diff) {
        if(right < start || left > end) {
            return;
        }

        if(left <= start && end <= right) {
            lazy[node] += diff;
            int segmentSize = (node + 1) >> 1;
            while(segmentSize > 1) {
                segment[segmentSize] += (long) diff * (end - start + 1);
                segmentSize = (segmentSize + 1) >> 1;
            }
            return;
        }
        int mid = (start + end) / 2;
        updateRange(left, right, node * 2 - 1, start, mid, diff);
        updateRange(left, right, node * 2, mid+1, end, diff);
    }

    private static void query(int left, int right, int node, int start, int end) {
        if(lazy[node] != 0) {
            segment[node] += lazy[node] * (end - start + 1);
            updateLazy(node);
        }
        if(right < start || left > end) {
            return;
        }

        if(left <= start && end <= right) {
            return;
        }
        int mid = (start + end) / 2;
        query(left, right, node * 2 - 1, start, mid);
        query(left, right, node * 2, mid+1, end);
    }

    private static void updateLazy(int i) {
        long tmp = lazy[i];
        lazy[i] = 0;
        if(size < i) return;
        lazy[i * 2] += tmp;
        lazy[i * 2 - 1] += tmp;
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static long[] segments;
    static int N;
    static int size;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        N = read();
        int Q = read();
        size = 1;
        while(size < N) {
            size <<= 1;
        }
        segments = new long[(size << 1) + 1];

        for(int i = size + 1; i < size + N + 1; i++) {
            segments[i] = read();
        }

        int segmentSize = segments.length- 1;
        while(segmentSize > 1) {
            segments[(segmentSize + 1) >> 1] = segments[segmentSize] + segments[segmentSize - 1];
            segmentSize -= 2;
        }

        for(int i = 0; i < Q; i++) {
            int x = read();
            int y = read();
            int a = read();
            int b = read();
            int min = Math.min(x,y);
            int max = Math.max(x,y);

            sb.append(query(min,max,2,1,size));
            if(i != Q-1) sb.append("\n");
            update(a,b);
        }

        System.out.print(sb);


    }

    public static void update(int a, int b) {
        int segmentSize = a + size;
        long val = segments[segmentSize];

        while(segmentSize > 1) {
            segments[segmentSize] += ((long) b - val);
            segmentSize = (segmentSize + 1) >> 1;
        }
    }

    public static long query(int left, int right, int node, int start, int end) {
        if(left > end || right < start) {
            return 0L;
        }

        if(left <= start && end <= right) {
            return segments[node];
        }

        int mid = (start + end) / 2;
        return query(left, right, (node << 1)  - 1, start, mid) + query(left, right, node << 1, mid + 1, end);
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

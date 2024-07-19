import java.util.Arrays;

public class Main {

    static long[] segment;
    static int size;
    static int N;
    static int D;
    public static void main(String[] args) throws Exception {
        N = read();
        D = read();
        size = 1;
        while(size < N) {
            size <<= 1;
        }
        segment = new long[size * 2 + 1];
        Arrays.fill(segment, Integer.MIN_VALUE);
        for(int i = size + 1; i < size + N + 1; i++) {
            segment[i] = read();
        }

        int segmentSize = segment.length - 1;
        while(segmentSize > 1) {
            segment[(segmentSize + 1) >> 1] = Math.max(segment[segmentSize - 1],segment[segmentSize]);
            segmentSize -= 2;
        }

        //값 하나하나 보기

        for(int i = 1; i <= size; i++) {
            int start = Math.max(1, i - D);
            int end = i-1;
            long max = query(start, end, 2, 1, size);
            update(i, max);
        }

        System.out.println(segment[2]);
    }

    public static long query(int left,  int right, int node, int start, int end) {
        if(left > end || right < start) return Integer.MIN_VALUE;

        if(left <= start && end <= right) {
            return segment[node];
        }

        int mid = (start + end) >> 1;
        return Math.max(query(left, right, (node << 1) - 1 , start, mid ), query(left, right, node << 1, mid + 1, end));
    }

    public static void update(int i, long v) {
        int index = i + size;
        if(v <= 0) return;
        segment[index] = Math.max(segment[index], segment[index] + v);
        while(index > 1) {
            index = (index + 1) >> 1;
           segment[index] = Math.max(segment[index << 1], segment[(index << 1) - 1]);
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

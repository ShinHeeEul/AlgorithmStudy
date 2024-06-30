import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static long[] segment;
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        StringBuilder sb = new StringBuilder();

        int size = 1 << 20;
        while(size < N) {
            size <<= 1;
        }
        segment = new long[(size << 1) + 2];

        for(int m = 0; m < M; m++) {
            int a = read();
            int i = read();
            int j = read();

            if(a == 0) {
                int min = Math.min(i,j);
                int max = Math.max(i,j);
                long sum = query(min, max, 2,1, size);
                sb.append(sum).append("\n");
                continue;
            }
            int index = i + size;
            long before = segment[index];
            while(index > 1) {
                segment[index] -= before;
                segment[index] += j;
                index = ceilDiv(index);
            }
        }
        System.out.println(sb);

    }

    private static long query(int left, int right, int node, int start, int end) {
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

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return o;
    }
}

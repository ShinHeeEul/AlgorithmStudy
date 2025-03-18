import java.util.*;
import java.io.*;

public class Main {

    static int[] segments;
    static int[] lazy;
    static int size;
    static int N;

    public static void main(String[] args) throws Exception {
        N = read();
        size = 1;
        while(size < N) size <<= 1;

        segments = new int[(size << 1) + 1];
        lazy = new int[(size << 1) + 1];

        int segmentSize = size << 1;
        for(int i = size + 1; i < size + N + 1; i++) {
            segments[i] = read();
        }

        StringBuilder sb = new StringBuilder();

        int M = read();
        while(segmentSize > 1) {
            segments[segmentSize >> 1] = segments[segmentSize] ^ segments[segmentSize-1];
            segmentSize-=2;
        }
        while(M --> 0) {
            int a = read();
            if(a == 1) {
                int i = read() + 1;
                int j = read() + 1;
                int k = read();
                updateLazy(i , j, 2, 1, size, k);

            } else {
                int i = read() + 1;
                sb.append(query(i,i,2,1,size)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void update(int node) {
        // 현재 값 노드에 더하고?

        // 밑으로 전파 시키고
        if(node > size) {
            segments[node] ^= lazy[node];
            lazy[node] = 0;
            return;
        }

        int index = node << 1;
        lazy[index] ^= lazy[node];
        lazy[index-1] ^= lazy[node];

        lazy[node] = 0;
    }

    public static boolean updateLazy(int left, int right, int node, int start, int end, int v) {
        if(end < left || right < start) return false;

        if(left <= start && end <= right) {
            lazy[node] ^= v;
            update(node);
            return (end - start + 1) % 2 != 0;
        }

        int mid = (start + end) >> 1;
        boolean b = updateLazy(left, right, (node << 1) - 1, start, mid, v) ^ updateLazy(left, right, (node << 1), mid + 1, end, v);
        if(b) segments[node] ^= v;

        return b;
    }

    public static long query(int left, int right, int node, int start, int end) {

        if(lazy[node] != 0) {
            update(node);
        }

        if(end < left || start > right) return 0L;

        if(left <= start && end <= right) {
            return segments[node];
        }

        int mid = (start + end) >> 1;
        return query(left, right, (node << 1) - 1, start, mid) ^ query(left, right, (node << 1), mid + 1, end);
    }

    private static int read() throws IOException {
        int d, o = 0;
        boolean negative = false;

        while ((d = System.in.read()) <= 32);

        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        do {
            o = (o << 3) + (o << 1) + (d & 15); // o = o * 10 + (d - '0')
        } while ((d = System.in.read()) >= '0' && d <= '9');

        return negative ? -o : o;
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] segment;
    static long[] lazy;
    static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = 1;
        while(size < N) {
            size <<= 1;
        }
        segment = new long[(size << 1) + 1];
        lazy = new long[(size << 1) + 1];

        Arrays.fill(segment, 1);
        for(int i = N + 1; i <= size; i++) updateDiff(i, i, 2, 1, size, 0);
        for(int m = 0; m < K; m++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            char a = st.nextToken().charAt(0);
            if(a == 'Q') {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long sum = query(Math.min(b,c), Math.max(b,c), 2,1, size);
                int cnt = 0;
                for(int i = 0; i < M; i++) {
                    if(((1 << i) | sum) == sum) cnt++;
                }
                bw.write(cnt + "\n");
                continue;
            }

            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            updateDiff(Math.min(b,c),Math.max(b,c),2,1,size,1 << (d - 1));
        }
        bw.flush();

    }

    private static long updateDiff(int left, int right, int node, int start, int end, int diff) {
        if(lazy[node] != 0) {
            updateLazy(node);
        }
        if (left > end || right < start) {
            return segment[node];
        }
        if (left <= start && end <= right) {
            lazy[node] = diff;
            updateLazy(node);
            return segment[node];
        }
        int mid = (start + end) / 2;
        long a = updateDiff(left, right, node * 2 - 1, start ,mid, diff);
        long b = updateDiff(left, right, node * 2, mid + 1, end, diff);
        segment[node] = (a | b);

        return segment[node];
    }

    private static void updateLazy(int node) {
        long val = lazy[node];
        segment[node] = lazy[node];
        lazy[node] = 0;
        if(node > size) return;
        lazy[node * 2] = val;
        lazy[node * 2 - 1] = val;
    }

    private static long query(int left, int right, int node, int start, int end) {
        if(lazy[node] != 0) {
            updateLazy(node);
        }

        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segment[node];
        }

        int mid = (start + end) / 2;
        return query(left, right, node * 2 - 1, start, mid) | query(left, right, node * 2, mid + 1, end);
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

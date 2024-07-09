import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static long[] segment;
    static int size;
    public static void main(String[] args) throws Exception {
        int N = read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = 1;
        while(size < N) {
            size <<= 1;
        }

        segment = new long[(size << 1) + 1];

        for(int i = size + 1; i < size + N + 1; i++) {
            segment[i] = read();
        }

        int segmentSize = segment.length - 1;

        while(segmentSize > 1) {
            segment[(segmentSize + 1) >> 1] = segment[segmentSize] + segment[segmentSize - 1];
            segmentSize -= 2;
        }

        int M = read();

        List<QueryOne> queryOnes = new ArrayList<>();
        PriorityQueue<QueryTwo> pq = new PriorityQueue<>();

        int index = 0;
        for(int i = 0; i < M; i++) {
            int a = read();
            if(a == 1) {
                queryOnes.add(new QueryOne(read(), read()));
                continue;
            }
            pq.add(new QueryTwo(index++, read(), read(), read()));
        }

        long[] answers = new long[index];

        for(int i = 0; i <= queryOnes.size(); i++) {
            if(pq.isEmpty()) {
               break;
            }
            QueryTwo queryTwo = pq.peek();
            while(queryTwo.k == i) {
                answers[queryTwo.index] = query(queryTwo.i, queryTwo.j, 2, 1, size);
                pq.poll();
                if(pq.isEmpty()) break;
                queryTwo = pq.peek();
            }
            if(i == queryOnes.size()) break;
            QueryOne queryOne = queryOnes.get(i);
            update(queryOne);
        }

        for(long answer : answers) {
            bw.write(answer + "\n");
        }
        bw.flush();

    }

    public static void update(QueryOne queryOne) {
        int index = queryOne.i;
        int value = queryOne.v;

        int segmentSize = size + index;
        long tmp = segment[segmentSize];

        while(segmentSize > 1) {
            segment[segmentSize] += (value - tmp);
            segmentSize = (segmentSize + 1) >> 1;
        }
    }

    public static long query(int left, int right, int node, int start, int end) {
        if(left > end || right < start) {
            return 0L;
        }

        if(left <= start && end <= right) {
            return segment[node];
        }

        int mid = (start + end) >> 1;
        return query(left, right, node * 2 - 1, start, mid) + query(left, right, node * 2, mid + 1, end);
    }

    private static class QueryTwo implements Comparable<QueryTwo> {
        int index;
        int k;
        int i;
        int j;

        public QueryTwo(int index, int k, int i, int j) {
            this.index = index;
            this.k = k;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(QueryTwo o) {
            return this.k - o.k;
        }
    }

    private static class QueryOne {
        int i;
        int v;

        public QueryOne(int i, int v) {
            this.i = i;
            this.v = v;
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

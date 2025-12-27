import java.util.Arrays;

public class Main {


    // 전체 세그트리
    static SegTree[] segments;
    static int N;
    static int segmentSize;
    static int size;
    static int M;
    static int[][] defaultSquare;

    static SegTree DEFAULT;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        size = 1;
        while(N > size) size <<= 1;

        segmentSize = (size << 1) + 1;
        segments = new SegTree[segmentSize];
        DEFAULT = new SegTree();
        Arrays.fill(segments, DEFAULT);

        defaultSquare = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                defaultSquare[i][j] = read();
            }
        }

        for(int i = 1; i <= N; i++) {
            segments[size + i] = new SegTree(i);
        }



        int segSize = segmentSize - 1;

        while(segSize >= 2) {
            segments[segSize >> 1] = concatSegTree(segments[segSize], segments[segSize - 1]);
            segSize -= 2;
        }

        StringBuilder sb = new StringBuilder();

        while(M --> 0) {

            int w = read();
            if(w == 1) {
                int x1 = read();
                int y1 = read();
                int x2 = read();
                int y2 = read();

                sb.append(query(y1, y2, 2, 1, size, x1, x2)).append("\n");
            } else {
                int x = read();
                int y = read();

                int val = read();

                update(y, x, val);
            }
        }

        System.out.println(sb);
    }

    public static long query(int left, int right, int node, int start, int end, int y1, int y2) {

        if(left > end || right < start) {
            return 0;
        }

        if(left <= start && end <= right) {
            return segments[node].query(y1, y2, 2, 1, size);
        }

        int mid = (start + end) >> 1;
        int midNode = node << 1;
        return query(left, right, midNode - 1, start, mid, y1, y2) +
                query(left, right, midNode, mid + 1, end, y1, y2);

    }

    public static SegTree concatSegTree(SegTree st1, SegTree st2) {
        SegTree result = new SegTree();

        for(int i = 0; i < segmentSize; i++) {
            result.segments[i] = st1.segments[i] + st2.segments[i];
        }

        return result;
    }

    public static void update(int x, int y, int val) {
        x += size;
        segments[x].update(y, val);

        while(x >= 2) {
            x = (x + 1) >> 1;
            long leftY = segments[(x << 1) - 1].segments[size + y];
            long rightY = segments[x << 1].segments[size + y];
            segments[x].update(y, leftY + rightY);
        }
    }

    // 열을 세그트리 형태로 저장
    private static class SegTree {
        private long[] segments;


        public SegTree() {
            segments = new long[segmentSize];
        }

        public SegTree(int col) {
            segments = new long[segmentSize];

            for(int i = size + 1;  i < segmentSize; i++) {
                segments[i] = defaultSquare[i - size][col];
            }

            int segSize = segmentSize - 1;

            while(segSize >= 2) {
                segments[segSize >> 1] = segments[segSize - 1] + segments[segSize];
                segSize -= 2;
            }
        }

        // 열의 합을 구하는 쿼리
        public long query(int left, int right, int node, int start, int end) {
            if(left > end || right < start) {
                return 0;
            }

            if(left <= start && end <= right) {
                return this.segments[node];
            }

            int mid = (start + end) >> 1;
            int midNode = node << 1;
            return this.query(left, right, midNode - 1, start, mid) +
                    this.query(left, right, midNode, mid + 1, end);
        }

        public void update(int index, long val) {

            index += size;

            segments[index] = val;

            while(index >= 2) {
                index = (index + 1) >> 1;
                segments[index] = segments[index << 1] + segments[(index << 1) - 1];
            }
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
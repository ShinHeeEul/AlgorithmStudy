public class Main {

    static int[] segments;
    static int N;
    static int segmentSize = 1;


    public static void main(String[] args) throws Exception {
        N = read();

        while(N > segmentSize) {
            segmentSize <<= 1;
        }

        segments = new int[(segmentSize << 1) + 1];

        for(int i = segmentSize + 1; i < segmentSize + N + 1; i++) {
            segments[i] = read();
        }

        int size = segments.length - 1;

        while(size > 2) {
            segments[(size >> 1)] = segments[size - 1] + segments[size];
            size -= 2;
        }

        int M = read();
        StringBuilder sb = new StringBuilder();
        while(M --> 0) {
            int q = read();

            if(q == 1) {
                int i = read();
                int a = read();
                update(i, a);
            } else {
                int v = read();
                sb.append(query(v,2, 1, segmentSize)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void update(int i, int v) {
        i += segmentSize;
        while(i >= 2) {
            segments[i] += v;
            i = (i + 1) >> 1;
        }
    }

    private static int query(int v, int node, int start, int end) {

        if(node > segmentSize) {
            return node - segmentSize;
        }

        int right = node << 1;
        int left = right - 1;
        int mid = (start + end) >> 1;
        if(segments[left] < v) {
            return query(v - segments[left], right, mid + 1, end);
        } else {
            return query(v, left, start, mid);
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

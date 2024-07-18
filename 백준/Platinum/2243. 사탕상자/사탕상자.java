public class Main {

    static int size;
    static int[] segments;
    public static void main(String[] args) throws Exception {
        int N = read();
        size = 1 << 20;
        segments = new int[(size << 1) + 1];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int A = read();
            int B = read();
            if(A == 1) {
                int node = query(B, 2);
                update(node, -1);
                sb.append(node).append("\n");
                continue;
            }
            int C = read();
            update(B, C);
        }
        System.out.println(sb);
    }

    private static int query(int val, int node) {
        if(node > size) {
            return node - size;
        }
        int next = segments[(node << 1) - 1];
        if(val > next) {
            return query(val - next, node << 1);
        } else {
            return query(val, (node << 1) - 1);
        }
    }

    private static void update(int index, int value) {
        int segmentSize = size + index;
        while(segmentSize > 1) {
            segments[segmentSize] += value;
            segmentSize = (segmentSize + 1) >> 1;
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

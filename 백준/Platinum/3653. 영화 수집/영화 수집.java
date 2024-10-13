import org.w3c.dom.Node;

import java.util.Arrays;

class Main {

        static Node[] segments;
        static int N;
        static int size;

        public static void main(String[] args) throws Exception {

            int T = read();

            StringBuilder sb = new StringBuilder();

            while(T --> 0) {

                N = read();
                int M = read();

                size = 1;
                while(size < N) {
                    size <<= 1;
                }

                segments = new Node[(size << 1) + 1];
                Arrays.fill(segments, new Node(Integer.MAX_VALUE, Integer.MIN_VALUE));

                int cnt = N;
                for(int i = size + 1; i < size + N + 1; i++) {
                    segments[i] = new Node(cnt, cnt);
                    cnt--;
                }

                int segmentSize = segments.length - 1;
                while(segmentSize > 1) {
                    Node node1 = segments[segmentSize];
                    Node node2 = segments[segmentSize - 1];

                    segments[segmentSize >> 1] = new Node(
                            Math.min(node1.min, node2.min),
                            Math.max(node1.max, node2.max)
                    );
                    segmentSize -= 2;
                }

                for(int i = N + 1; i < N + M + 1; i++) {
                    int a = read();
                    sb.append(query(segments[a + size].min, 2, 1, size)).append(" ");
                    update(a, i);
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }

        public static int query(int cur, int nIndex, int start, int end) {
            Node node = segments[nIndex];
            int min = node.min;
            int max = node.max;

            if(max <= cur) return 0;

            if(cur < min) return Math.min(end, N) - start + 1;

            if(min == cur) return Math.min(end, N) - start;

            int mid = (start + end) >> 1;
            return query(cur, (nIndex << 1) - 1, start, mid) + query(cur, (nIndex << 1), mid + 1, end);

        }

        public static void update(int index, int value) {
            index += size;
            segments[index].min = value;
            segments[index].max = value;

            while(index > 2) {
                index = (index + 1) >> 1;
                segments[index].min = Math.min(segments[index << 1].min, segments[(index << 1) - 1].min);
                segments[index].max = Math.max(segments[index << 1].max, segments[(index << 1) - 1].max);
            }
        }

        public static class Node {
            int min;
            int max;

            public Node(int min, int max) {
                this.min = min;
                this.max = max;
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
import org.w3c.dom.Node;

import java.util.PriorityQueue;

class Main {

        static long[] segments;
        static int size;

        public static void main(String[] args) throws Exception {
            int N = read();
            int M = read();

            size = 1;
            while(size < N) {
                size <<= 1;
            }

            segments = new long[(size << 1) + 1];

            long count = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();

            for(int i = 0; i < M; i++)
                pq.add(new Node(read(), read()));

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int end = node.end;
                count += query(end + 1, size, 2, 1, size);
                update(end);
            }

            System.out.println(count);

        }

        public static class Node implements Comparable<Node>{
            int start;
            int end;

            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Node o) {
                if(this.start == o.start) {
                    return this.end - o.end;
                }
                return this.start - o.start;
            }
        }

        public static long query(int left, int right, int node, int start, int end) {
            if(right < start || left > end) return 0;

            if(left <= start && end <= right) return segments[node];

            int mid = (start + end) >> 1;
            return query(left, right, (node << 1) - 1, start,  mid)
                    + query(left, right, (node << 1),  mid + 1, end);
        }

        public static void update(int index) {
            index += size;
            while(index > 1) {
                segments[index]++;
                index = (index + 1) >> 1;
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
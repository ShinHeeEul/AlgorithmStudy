import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    static long[] segment;
    public static void main(String[] args) throws Exception {
        long N = read();
        long M = read();
        long K = read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 1;
        while(size < N) {
            size *= 2;
        }

        long[] arr = new long[size + 1];
        segment = new long[size * 2+1];


        for(int i = 1; i <= N; i++) {
            arr[i] = read();
            segment[size + i] = arr[i];
        }


        for(int i = size*2-1; i >= 0; i-=2) {
            segment[i/2 + 1] = segment[i] + segment[i+1];
        }

        for(int i = 0 ; i < M + K; i++) {
            long a = read();
            int b = (int) read();
            long c = read();

            if(a == 1) {
                int index = size + b;
                long val = c - segment[index];
                while(index >= 2) {
                    segment[index] += val;
                    index = ceilDiv(index, 2);
                }
                continue;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, size, 2));
            long sum = 0;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if(node.start >= b && node.end <= c) {
                    sum += segment[node.index];
                    continue;
                }
                int mid = (node.start + node.end) >> 1;
                if(b <= mid) {
                    queue.add(new Node(node.start, mid, node.index * 2 - 1));
                }
                if(c > mid) {
                    queue.add(new Node(mid + 1, node.end, node.index * 2));
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
    }

    public static class Node {
        int start;
        int end;
        int index;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static int ceilDiv(int x, int y) {
        return (x + y - 1) / y;
    }

    private static long read() throws Exception {
        long d, o = 0;
        boolean isNegative = false;

        d = System.in.read();
        if (d == 45) {
            isNegative = true;
            d = System.in.read();
        }

        d &= 15;
        o = d;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return isNegative ? -o : o;
    }
}

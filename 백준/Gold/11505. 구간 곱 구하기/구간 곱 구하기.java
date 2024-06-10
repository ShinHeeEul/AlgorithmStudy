import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
    int N = read();
    int M = read();
    int K = read();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int size = 1;
    int MAX = 1_000_000_007;
    while(size < N) {
        size *= 2;
    }
    int segmentSize = size * 2 + 1;
    long[] segments = new long[segmentSize];
    Arrays.fill(segments, 1);

    for(int i = segmentSize - size ; i < segmentSize - size + N; i++) {
        segments[i] = read();
    }

    for(int i = segmentSize - 2; i >= 0; i-=2) {
        segments[i/2 + 1] = (segments[i] * segments[i+1]) % MAX;
    }

        for(int i = 0 ; i < M + K; i++) {
            int a = read();
            int b = read();
            int c = read();
            if(a == 1) {
                // tree 교체 알고리즘
                int index = (size + b);
                segments[index] = c;
                index = ceilDiv(index, 2);
                while(index > 1) {
                    segments[index] = (segments[index * 2] * segments[index * 2 - 1]) % MAX;
                    index = ceilDiv(index, 2);
                }
                continue;
            }
            // tree 계산 알고리즘
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1,size,2));
            long answer = 1;
            while(!queue.isEmpty()) {
                Node n = queue.poll();
                int start = n.start;
                int end = n.end;
                int index = n.index;

                // b가 n.start 보다 작으면서 c가 n.end보다 크면?
                if(start >= b && end <= c) {
                    answer *= segments[index];
                    answer %= MAX;
                    continue;
                }
                int mid = (start + end) / 2;
                //
                if(c > mid) {
                    queue.add(new Node(mid + 1, end, n.index * 2));
                }
                if(b <= mid) {
                    queue.add(new Node(start, mid, n.index * 2 - 1));
                }
            }
            bw.write(answer + "\n");

        }
        bw.flush();

    }

    private static class Node {
        int start;
        int end;
        int index;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static int ceilDiv(int a, int b) {
        return (a + 1) / b;
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return o;
    }
}

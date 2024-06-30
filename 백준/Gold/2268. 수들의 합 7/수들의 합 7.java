import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 1;
        while(size < N) {
            size <<= 1;
        }
        long[] segment = new long[(size<< 1)+2];

        for(int m = 0; m < M ;m++) {
            int a = read();
            int i = read();
            int j = read();

            if(a == 0) {
                int min = Math.min(i,j);
                int max = Math.max(i,j);
                Queue<Node> queue = new LinkedList<>();

                queue.add(new Node(1, size, 2));

                long sum = 0;
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    int start = node.start;
                    int end = node.end;
                    int value = node.value;

                    if(start >= min && end <= max) {
                        sum += segment[value];
                        continue;
                    }

                    int mid = (start + end) >> 1;
                    if(max > mid) {
                        queue.add(new Node(mid + 1, end, node.value << 1));
                    }
                    if(min <= mid) {
                        queue.add(new Node(start, mid, (node.value << 1)-1));
                    }
                }
                bw.write(sum + "\n");
                continue;
            }
            int index = i + size;
            long before = segment[index];
            while(index > 1) {
                segment[index] -= before;
                segment[index] += j;
                index = ceilDiv(index);
            }
        }
        bw.flush();
        
    }

    private static class Node {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    private static int ceilDiv(int a) {
        return (a + 1) >> 1;
    }
    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return o;
    }
}

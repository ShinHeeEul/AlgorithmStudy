import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static Node[] arr;
    static PriorityQueue<Node> queue;
    public static void main(String[] args) throws Exception {

        int N = read();

        arr = new Node[N];
        queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int start = read();
            int end = read();
            arr[i] = new Node(start, end);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> -o.end));

        for(int i = 0; i < N; i++) {
            Node nn = arr[i];
            if(queue.isEmpty()) {
                queue.add(nn);
                continue;
            }
            Node n = queue.peek();
            if(n.start >= nn.end) queue.poll();
            queue.add(nn);
        }
        System.out.println(queue.size());
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

    private static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return o.start - this.start;
        }
    }
}

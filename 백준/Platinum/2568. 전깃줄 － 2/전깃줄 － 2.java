import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        Node[] nodes = new Node[N];
        PriorityQueue<Node>[] pqs = new PriorityQueue[N];
        int[] arr = new int[N+1];
        for(int i = 0; i < N; i++) {
            int A = read();
            int B = read();
            nodes[i] = new Node(A,B);
            pqs[i] = new PriorityQueue<>(Comparator.comparingInt(o -> -o.A));
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.A));

        int index = 0;
        for(int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            int B = node.B;
            if(i == 0) {
                arr[0] = B;
                pqs[0].add(node);
                continue;
            }
            if(arr[index] < B) {
                index++;
                arr[index] = B;
                pqs[index].add(node);
                continue;
            }

            int start = 0;
            int end = index;
            while(start < end) {
                int mid = (start + end) >>> 1;
                if(arr[mid] < B) start = mid + 1;
                else end = mid;
            }
            arr[end] = B;
            pqs[end].add(node);
        }
        StringBuilder sb = new StringBuilder();
        int count = N - (index + 1);
        sb.append(count);
        int before = pqs[index].peek().A;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = index; i >= 0; i--) {
            boolean b = true;
            int tmp = 0;
            while(!pqs[i].isEmpty()) {
                int A = pqs[i].poll().A;
                if(before < A) {
                    pq.add(A);
                    continue;
                }
                if(b) {
                    b = false;
                    tmp = A;
                    continue;
                }
                pq.add(A);
            }
            before = tmp;
        }

        while(!pq.isEmpty()) {
            sb.append("\n").append(pq.poll());
        }
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

    private static class Node {
        int A;
        int B;
        public Node(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}

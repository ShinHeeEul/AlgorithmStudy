import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        Node[] nodes = new Node[N];
        int[] arr = new int[N+1];
        for(int i = 0; i < N; i++) {
            int A = read();
            int B = read();
            nodes[i] = new Node(A,B);
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.A));

        int index = 0;
        for(int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            int B = node.B;
            if(i == 0) {
                arr[0] = B;
                continue;
            }
            int current = arr[index];
            if(current < B) {
                arr[++index] = B;
                continue;
            }

            int start = 0;
            int end = index;
            while(start < end) {
                int mid = (start + end) >>> 1;
                if(arr[mid] < B) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            arr[end] = B;
        }

        System.out.println(N - (index + 1));
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

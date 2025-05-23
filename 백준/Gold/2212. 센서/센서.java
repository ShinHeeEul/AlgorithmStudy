import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int K = read();

        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++) arr[i] = read();

        Arrays.sort(arr);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < (arr.length - 1); i++) pq.add(new Node(arr[i], arr[i + 1]));

        while(K != 1) {
            pq.poll();
            K--;
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            answer += (n.end - n.start);
        }

        System.out.println(answer);

    }

    // 1 3 6 6 7 9 -> 2 3
    // 5 0 3 3 0 1 -> 12
    // 4 1 4 2 1 2 -> 14
    // 3 6 7 8 10 12 14 15 18 20 -> 0 2 0 3 2
    //  0 1 1 0 0  2  1  0  2
    public static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return (o.end - o.start) - (this.end - this.start);
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
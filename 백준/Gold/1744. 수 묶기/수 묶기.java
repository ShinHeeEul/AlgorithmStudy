import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();

        HashMap<Integer, Boolean> map = new HashMap<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] arr = new int[N];

        arr[0] = read();

        for (int i = 1; i < N; i++) {
            arr[i] = read();
            for(int j = i-1; j >= 0; j--) {
                pq.add(new Node(i, j,arr[i] * arr[j]));
            }
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int a = node.a;
            int b = node.b;
            int val = node.val;
            if(map.getOrDefault(a, false) | map.getOrDefault(b, false)) continue;
            if(val <= (arr[a] + arr[b])) continue;
            answer += val;
            map.put(a, true);
            map.put(b, true);
        }

        for(int i = 0; i < N; i++) {
            if(map.getOrDefault(i, false)) continue;
            answer += arr[i];
        }

        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {
        int a;
        int b;
        int val;

        Node(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return o.val - this.val;
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
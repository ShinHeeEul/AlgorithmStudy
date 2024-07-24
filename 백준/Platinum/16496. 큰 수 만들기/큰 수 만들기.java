import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            pq.add(new Node(read()));
        boolean isZero = true;
        while(!pq.isEmpty()) {
            int a = pq.poll().val;
            answer.append(a);
            if(a != 0) isZero = false;
        }
        if(isZero) answer = new StringBuilder("0");
        System.out.println(answer);
    }

    public static class Node implements Comparable<Node> {
        int val;

        public Node(int val) {
            this.val = val;
        }

        public int compareTo(Node o) {
            String v1 = val + "";
            String v2 = o.val + "";
            int min = Math.min(v1.length(), v2.length());
            for(int i = 0; i < min; i++) {
                if(v1.charAt(i) == v2.charAt(i)) continue;
                if(v1.charAt(i) > v2.charAt(i)) return -1;
                return 1;
            }
            if(Long.parseLong(v1 + v2) <= Long.parseLong(v2+v1)) {
                return 1;
            }
            return -1;
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
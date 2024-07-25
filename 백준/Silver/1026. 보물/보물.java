import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        
        int N = read();

        PriorityQueue<Integer> apq = new PriorityQueue<>();
        PriorityQueue<Integer> bpq = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            apq.add(Integer.parseInt(st1.nextToken()));
            bpq.add(Integer.parseInt(st2.nextToken()));
        }
        
        int ans = 0;
        for(int i = 0; i < N; i++) ans += apq.poll() * bpq.poll();
        System.out.println(ans);
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
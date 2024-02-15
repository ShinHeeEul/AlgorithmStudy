public class Main {

    static int[] dp;
    public static void main(String[] args) throws Exception {
        int N = read();

        dp = new int[N + 2];
        Node[] nodes = new Node[N + 2];

        for(int i = 1; i <= N; i++) {
            nodes[i] = new Node(read(), read());
        }

        nodes[N+1] = new Node(0,0);

        int max = 0;
        for(int i = 1; i <= N+1; i++) {
            max = Math.max(max, dp[i]);
            int nxt = nodes[i].t + i;
            if(nxt > N+1) continue;
            dp[nxt] = Math.max(max + nodes[i].p, dp[nxt]);
        }

        System.out.println(dp[N+1]);
    }

    static class Node {
        int t;
        int p;

        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

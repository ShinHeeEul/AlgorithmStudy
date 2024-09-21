import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static long[] dists;
    static ArrayList<Edge> list;
    public static void main(String[] args) throws Exception {
        int TC = read();

        while(TC --> 0) {

            int N = read();
            int M = read();
            int W = read();

            list = new ArrayList<>();

            for(int i = 0; i < M; i++) {
                int s = read();
                int e = read();
                int t = read();
                list.add(new Edge(s,e,t));
                list.add(new Edge(e,s,t));
            }

            for(int i = 0; i < W; i++) {
                int s = read();
                int e = read();
                int t = read();
                list.add(new Edge(s,e,-t));
            }

            boolean b = true;

                dists = new long[N + 1];
                Arrays.fill(dists, Integer.MAX_VALUE);
                dists[0] = 0;

                for (int i = 0; i < N; i++) {
                    for (Edge edge : list) {
                            dists[edge.to] = Math.min(dists[edge.to], dists[edge.from] + edge.cost);
                    }
                }

                for(Edge edge : list) {
                    if(dists[edge.to] > dists[edge.from] + edge.cost) {
                        System.out.println("YES");
                        b = false;
                        break;
                    }
                }
            if(b) {
                System.out.println("NO");
            }

            }



    }

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}

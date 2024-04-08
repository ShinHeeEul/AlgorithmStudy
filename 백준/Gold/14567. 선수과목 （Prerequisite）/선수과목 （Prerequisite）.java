import java.util.ArrayList;

public class Main {

    static ArrayList<Node>[] list;
    static int[] score;
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        list = new ArrayList[N+1];
        score = new int[N+1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            int A = read();
            int B = read();
            list[A].add(new Node(B));
        }

        for(int i = 1; i <= N; i++) Topol(i);
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= N; i++) sb.append(score[i] + 1).append(" ");
        System.out.println(sb.toString());

    }

    public static void Topol(int i) {
        for(Node n : list[i]) score[n.before] = Math.max(score[n.before], score[i] + 1);
    }

    static class Node {
        int before;
        public Node(int before) {
            this.before = before;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

}
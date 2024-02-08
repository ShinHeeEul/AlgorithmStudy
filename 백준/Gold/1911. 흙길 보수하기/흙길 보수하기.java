import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int L = read();

        ArrayList<Node> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(new Node(read(), read()));
        }

        Collections.sort(list);

        int answer = 0;
        int before = -1;
        for(Node n : list) {
            if(n.start <= before) n.start = before + 1;
            int a = n.end - n.start;
            int b = a % L;
            int c = a / L;

            if(a <= 0) continue;
            if(b == 0) answer += c;
            else {
                answer += c + 1;
                before = n.end + L - b - 1;
            }
        }

        System.out.println(answer);
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

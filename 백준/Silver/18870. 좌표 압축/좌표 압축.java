import java.io.*;
import java.util.*;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Node[] map = new Node[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            long val = Long.parseLong(st.nextToken());
            map[i] = new Node(val, i);
        }

        Arrays.sort(map);

        int count = 0;
        for(int i = 0; i < N; i++) {
            Node n = map[i];
            ans[n.i] = count;
            if((i != N-1)) {
                if(map[i].val == map[i+1].val) {
                    continue;
                }
            }
            count++;
        }

        for(int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();

    }

    private static class Node implements Comparable<Node> {

        private long val;
        private int i;

        public Node(long val, int i) {
            this.val = val;
            this.i = i;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.val, other.val);
        }

    }

}
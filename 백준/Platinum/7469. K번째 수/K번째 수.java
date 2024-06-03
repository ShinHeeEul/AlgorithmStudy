import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main{

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = read();
        int Q = read();
        Node[] list = new Node[N];
        for(int i = 1; i <= N; i++)
            list[i-1] = new Node(read(),i);
        
        Arrays.sort(list);

        for(int i = 0; i < Q; i++) {
            int count = 0;
            int start = read();
            int end = read();
            int cnt = read();
            int idx = 0;
            while(count < cnt) {
                int index = list[idx++].index;
                if(index >= start && index <= end) count++;
            }
            bw.write(list[idx-1].val + "");
            if(i != Q-1) bw.write("\n");
        }
        bw.flush();
    }

    public static class Node implements Comparable<Node> {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }

    }

    private static int read() throws Exception {
        int d, o = 0;
        boolean isNegative = false;

        d = System.in.read();
        if (d == 45) {
            isNegative = true;
            d = System.in.read();
        }

        d &= 15;
        o = d;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        // Apply the sign if necessary
        return isNegative ? -o : o;
    }

}

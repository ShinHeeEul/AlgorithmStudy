import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class Main {
    static Node[] A;
    static int size;
    public static void main(String[] args) throws Exception {
        int N =  read();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = 1;
        while(size < N) {
            size <<= 1;
        }
        A = new Node[size * 2 + 1];
        for(int i = 0; i < size * 2 + 1; i++) {
            A[i] = new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
        }
        for(int i = size + 1; i < size + N + 1; i++) {
            A[i] = new Node(i - size, read());
        }
        update();

        int M =  read();
        while(M --> 0) {
            int a =  read();
            if(a == 1) {
                updateValue(new Node(read(), read()));
                continue;
            }
            bw.write(query(1, size, 2, 1, size).index + "\n");
        }
        bw.flush();

    }

    private static Node query(int left, int right, int node, int start, int end) {
        if(left > end || right < start) {
            return new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if(left <= start && end <= right) {
            return A[node];
        }
        int mid = (start + end) / 2;
        Node n1 = query(left, right, node * 2 - 1, start, mid);
        Node n2 = query(left, right, node * 2, mid + 1, end);
        if(n1.compareTo(n2) > 0) {
            return n1;
        }
        return n2;
    }

    private static void updateValue(Node node) {
        int index = size + node.index;
        A[index].val = node.val;

        while(index > 1) {
            int current = (index + 1) >> 1;

            //이거 고치기
            Node n1 = A[(current << 1)-1];
            Node n2 =  A[current << 1];
            if(n1.compareTo(n2) > 0) {
                A[current] = n1;

            } else {
                A[current] = n2;
            }
            index = current;
        }
    }

    private static void update() {
        int size = A.length - 1;
        while(size > 1) {
            Node n1 =  A[size-1];
            Node n2 = A[size];
            if(n1.compareTo(n2) > 0) {
                A[(size + 1) >> 1] = n1;
            } else {
                A[(size + 1) >> 1] = n2;
            }
            size -= 2;
        }
    }

    private static class Node implements Comparable<Node> {
        int val;
        int index;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if(o.val == this.val) {
                return o.index - this.index;
            }
            return  o.val -  this.val;
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

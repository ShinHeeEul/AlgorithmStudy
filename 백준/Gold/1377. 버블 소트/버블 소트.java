import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Node[] A = new  Node[N];

        for(int i = 0; i < N; i++) A[i] = new Node(Integer.parseInt(br.readLine()), i);

        Arrays.sort(A, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        int count = 0;
        for(int i = 0; i < N; i++) {
            int tmp = i-A[i].index;
            if(count > tmp) count = tmp;
        }

        System.out.println(Math.abs(count) + 1);

        bw.flush();
        bw.close();
    }
    private static class Node{
        public int value;
        public int index;

        public int getValue() {
            return getValue();
        }

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }

}
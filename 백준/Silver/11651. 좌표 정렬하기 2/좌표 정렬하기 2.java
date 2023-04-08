import java.io.*;
import java.util.*;

public class Main {

    public static Node[] A;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        A = new Node[N];
        StringTokenizer st;
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            A[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(A);
        //Collections.sort(Arrays.stream(A).toList());

        for(int i = 0; i < N; i++) {
           bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }


    private static class Node implements Comparable<Node>{
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node n) {
            if(n.y > this.y) return -1;
            else if(n.y < this.y) return 1;
            else {

                if(n.x > this.x) return -1;
                return 1;
            }
        }

        @Override
        public String toString() {
            return x+ " " + y;
        }
    }

}
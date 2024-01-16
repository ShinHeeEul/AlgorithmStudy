import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static Character[][] map;
    static Node[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new Character[N][M];
        arr = new Node[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                arr[i][j] = new Node(i,j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                go(i,j);
            }
        }

        HashSet<Node> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                set.add(arr[i][j]);
            }
        }

        System.out.println(set.size());
    }

    static class Node implements Comparable<Node> {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            return this.i == n.i && this.j == n.j;
        }
        @Override
        public int hashCode() {
            return Objects.hash(this.i, this.j);
        }

        @Override
        public int compareTo(Node o) {
            if(o.i == this.i) {
                return o.j - this.j;
            }
            return o.i - this.i;
        }
    }

    public static boolean union(Node x,Node y) {
        x = find(x);
        y = find(y);

        if(x.equals(y)) return false;

        if(x.compareTo(y) < 0) {
            arr[x.i][x.j] = y;
        } else if(x.compareTo(y) > 0) {
            arr[y.i][y.j] = x;
        }
        return true;
    }

    public static Node find(Node x) {
        if(x.equals(arr[x.i][x.j])) {
            return x;
        }
        return arr[x.i][x.j] = find(arr[x.i][x.j]);
    }

    public static void go(int i, int j) {


        switch(map[i][j]) {
            case 'U':
                if(union(new Node(i,j), new Node(i-1,j))) {
                    go(i-1,j);
                }
                break;
            case 'D':
                if(union(new Node(i,j), new Node(i+1,j))) {
                    go(i+1,j);
                }
                break;
            case 'L':
                if(union(new Node(i,j), new Node(i,j-1))) {
                    go(i,j-1);
                }
                break;
            case 'R':
                if(union(new Node(i,j), new Node(i,j+1))) {
                    go(i,j+1);
                }
                break;
        }
    }
}

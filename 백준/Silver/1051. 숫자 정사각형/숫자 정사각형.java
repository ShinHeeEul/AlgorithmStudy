import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

class Main {

    static int[][] arr;

    static HashMap<Integer, ArrayList<Node>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int a = System.in.read() - '0';
                if (map.getOrDefault(a, null) == null) map.put(a, new ArrayList<>());
                arr[i][j] = a;
                ArrayList<Node> list = map.get(a);
                list.add(new Node(i, j));
            }
            System.in.read();
        }

        int answer = 0;
        for (int a : map.keySet()) {
            ArrayList<Node> list = map.get(a);
            for (int i = 0; i < list.size(); i++) {
                Node n1 = list.get(i);
                for (int j = list.size() - 1; j >= i; j--) {
                    Node n2 = list.get(j);
                    if (isRectangle(n1, n2, a)) {
                        int t = n2.i - n1.i + 1;
                        answer = Math.max(answer, t * t);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isRectangle(Node n1, Node n2, int val) {
        return arr[n1.i][n2.j] == val && arr[n2.i][n1.j] == val && Math.abs(n2.i -n1.i) == Math.abs(n2.j - n1.j);
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }

    static class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
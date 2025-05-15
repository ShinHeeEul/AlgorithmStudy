import java.util.*;

public class Main {


    static HashMap<Node, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        int N  = read();

        int[] start = new int[3];
        for(int i = 0; i < N; i++) start[i] = read();

        int[] arr = {9, 3, 1, 9, 1, 3, 3, 1, 9, 3, 9, 1, 1, 3, 9, 1, 9, 3};

        Queue<Node> queue = new LinkedList<>();
        Node no = new Node(0, start);
        queue.add(no);
        map.put(no, true);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.isEmpty()) {
                System.out.println(node.count);
                return;
            }

            for(int i = 0; i < 6; i++) {
                int[] tmp = new int[3];
                for(int j = 0; j < 3; j++) {
                    tmp[j] = node.arr[j] - arr[i * 3 + j];
                }
                Node n = new Node(node.count + 1, tmp);
                if(map.getOrDefault(n, false)) continue;
                queue.add(n);
                map.put(n, true);
            }
        }

    }

    static class Node {

        int[] arr;
        int count;

        public Node(int count, int[] a) {
            arr = a;
            this.count = count;
        }

        public boolean isEmpty() {
            for (int j : arr) if (j > 0) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return arr[0] * 10000 + arr[1] * 100 + arr[2];
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return node.arr[0] == this.arr[0] && node.arr[1] == this.arr[1] && node.arr[2] == this.arr[2];
        }
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

}

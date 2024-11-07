import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        long L = read();
        int N = (int) read();
        int K = (int) read();

        Queue<Node> queue = new LinkedList<>();
        HashMap<Long, Boolean> map = new HashMap<>();


        for(int i = 0; i < N; i++) {
            long l = read();
            queue.add(new Node(l, 0));
            map.put(l, true);
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.println(node.value);
            K--;
            if(K == 0) break;

            if(!map.getOrDefault(node.index-1, false) && (node.index - 1) >= 0) {
                map.put(node.index-1, true);
                queue.add(new Node(node.index-1, node.value + 1));
            }
            if(!map.getOrDefault(node.index+1, false) && (node.index + 1) <= L) {
                map.put(node.index+1, true);
                queue.add(new Node(node.index+1, node.value + 1));
            }
        }
    }

    public static class Node {
        long index;
        int value;

        public Node(long index, int value) {
            this.index = index;
            this.value = value;
        }
    }


    private static long read() throws Exception {
        long d, o;
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
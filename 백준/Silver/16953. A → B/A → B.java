import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int a;
    static int b;
    static HashMap<Long, Boolean> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        a = read();
        b = read();

        System.out.println(bfs(a));

    }

    private static int bfs(int start) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int count = node.count;
            long val = node.val;

            if(val > b) continue;
            if(val == b) return count + 1;

            long tmp = val << 1;
            if(!map.getOrDefault(tmp, false)) {
                map.put(tmp, true);
                queue.add(new Node(tmp, count + 1));
            }

            tmp = val * 10 + 1;
            if(!map.getOrDefault(tmp, false)) {
                map.put(tmp, true);
                queue.add(new Node(tmp, count + 1));
            }

        }
        return -1;
    }

    private static class Node {
        long val;
        int count;

        public Node(long val, int count) {
            this.val = val;
            this.count = count;
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
import java.util.*;

public class Main {
    static int Istart = 0;
    static int Iend = 0;
    static int zero = 0;
    static HashMap<Integer, Boolean> map = new HashMap<>();
    static Queue<Node> queue;
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Istart *= 10;
                Iend *= 10;
                int read = read();
                int index = i * 3 + j + 1;
                Istart += read;
                Iend += index;
                if(read == 0) {
                    zero = index;
                }
            }
        }
        Iend -= Iend % 10;

        bfs();

    }

    private static void bfs() {
        queue = new LinkedList<>();
        Node start = new Node(Istart, 0, zero);
        queue.add(start);
        map.put(Istart, true);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.r == Iend) {
                System.out.println(node.count);
                return;
            }

            int zero = node.zero;


            // 1,2,3,4,5,6,7,8,9일 때 마다 switchPosition 해주기
            if(zero == 1) {
                switchPosition(node, 1,2).ifPresent(e -> queue.add(e));
                switchPosition(node, 1,4).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 2) {
                switchPosition(node, 2,1).ifPresent(e -> queue.add(e));
                switchPosition(node, 2,3).ifPresent(e -> queue.add(e));
                switchPosition(node, 2,5).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 3) {
                switchPosition(node, 3,2).ifPresent(e -> queue.add(e));
                switchPosition(node, 3,6).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 4) {
                switchPosition(node, 4,1).ifPresent(e -> queue.add(e));
                switchPosition(node, 4,5).ifPresent(e -> queue.add(e));
                switchPosition(node, 4,7).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 5) {
                switchPosition(node, 5,2).ifPresent(e -> queue.add(e));
                switchPosition(node, 5,4).ifPresent(e -> queue.add(e));
                switchPosition(node, 5,6).ifPresent(e -> queue.add(e));
                switchPosition(node, 5,8).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 6) {
                switchPosition(node, 6,3).ifPresent(e -> queue.add(e));
                switchPosition(node, 6,5).ifPresent(e -> queue.add(e));
                switchPosition(node, 6,9).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 7) {
                switchPosition(node, 7,4).ifPresent(e -> queue.add(e));
                switchPosition(node, 7,8).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 8) {
                switchPosition(node, 8,7).ifPresent(e -> queue.add(e));
                switchPosition(node, 8,5).ifPresent(e -> queue.add(e));
                switchPosition(node, 8,9).ifPresent(e -> queue.add(e));
                continue;
            }
            if(zero == 9) {
                switchPosition(node, 9,8).ifPresent(e -> queue.add(e));
                switchPosition(node, 9,6).ifPresent(e -> queue.add(e));
            }
        }

        System.out.println(-1);
    }


    private static Optional<Node> switchPosition(Node node, int x, int y) {

        int r = node.r;
        int xx = (int)Math.pow(10, 9 - x);
        int yy = (int)Math.pow(10, 9 - y);
        int tempY = (r / yy) % 10;

        int newX = r + tempY * xx - tempY * yy;


        if(map.getOrDefault(newX, false)) return Optional.empty();
        map.put(newX, true);

        Node n = new Node(newX, node.count + 1, y);
        return Optional.of(n);
    }


    private static class Node {
        int r;
        int count;
        int zero;


        public Node(int r, int count, int zero) {
            this.r = r;
            this.zero = zero;
            this.count = count;
        }
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}

import java.util.*;

public class Main {

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static int N;
    public static void main(String[] args) throws Exception {

        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                char c = (char) System.in.read();
                if(c == '*') {
                    list.add(new int[]{i, j});
                }
            }
            System.in.read();
        }
        N = list.size();

        Queue<Node> queue = new LinkedList<>();

        HashMap<Node, Boolean> visited = new HashMap<>();

        Node start = new Node(list.toArray(new int[list.size()][]), 0);
        queue.add(start);
        visited.put(start, true);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int[][] map = node.map;
            if(node.isEnd()) {
                System.out.println(node.count);
                return;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < 4; j++) {
                    int[][] tmp = new int[N][2];
                    for(int k = 0; k < N; k++) tmp[k] = map[k].clone();
                    tmp[i][0] = map[i][0] + di[j];
                    tmp[i][1] = map[i][1] + dj[j];
                    int ii = tmp[i][0];
                    int jj = tmp[i][1];
                    if(ii >= 0 && ii < 5 && jj >= 0 && jj < 5) {
                        Node nxt = new Node(tmp, node.count + 1);
                        if(!visited.getOrDefault(nxt, false)) {
                            visited.put(nxt, true);
                            queue.add(nxt);
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int[][] map;
        boolean[][] mab;
        int count;

        public Node(int[][] map, int count) {
            this.map = map;

            mab = new boolean[5][5];
            for(int i = 0; i < N; i++) {
                mab[map[i][0]][map[i][1]] = true;
            }
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            for(int i = 0; i < N; i++) {
                if(!mab[n.map[i][0]][n.map[i][1]]) return false;
            }
            return true;
        }

        public boolean isEnd() {
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{map[0][0], map[0][1]});
            HashMap<Integer, Boolean> visited = new HashMap<>();
            int count = 1;
            visited.put(map[0][0] * 10 + map[0][1], true);
            while(!queue.isEmpty()) {
                Integer[] n = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int ni = n[0] + di[i];
                    int nj = n[1] + dj[i];
                    if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5) continue;
                        if(mab[ni][nj] && !visited.getOrDefault(ni * 10 + nj, false)) {
                            visited.put(ni * 10 + nj, true);
                            count++;
                            queue.add(new Integer[]{ni, nj});
                        }
                }
            }
            return count == N;
        }

        @Override
        public int hashCode() {
            long bit = 0;
            for (int i = 0; i < N; i++) {
                bit |= 1L << (map[i][0] * 5 + map[i][1]);
            }
            return Long.hashCode(bit);
        }

    }


    private static int read() throws Exception {
        int d, o;
        d = System.in.read();

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return o;
    }

}

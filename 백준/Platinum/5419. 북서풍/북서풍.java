import java.util.PriorityQueue;

public class Main {

    // 좌표 압축 -> 작은 것부터 : 1 ~ N (1~N, 1~N)
    // PriorityQueue 규칙 : 1) x가 더 작은거 우선, 같은 경우 y가 큰 게 우선

    // x는 같거나 작은거, y는 같거나 큰거로 갈 수 있음.
    // x 세그 트리와 y 세그 트리 하나씩 두고

    // 현재 값 c라 하면 x는 1~c까지, y는 c~N까지 합 구한 다음 둘 중 작은 애가 짝

    // 이후 값 업데이트

    static Node[] nodes;
    static long[] xSegments;
    static long[] ySegments;

    static int segmentSize;
    static int size;

    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        while(T --> 0) {

            // 세그 트리 세팅
            size = 1;

            int N = read();

            while(size < N) size <<= 1;
            segmentSize = (size << 1) + 1;

            xSegments = new long[segmentSize];
            ySegments = new long[segmentSize];

            // 좌표 세팅
            nodes = new Node[N];

            PriorityQueue<CompressNode> xQueue = new PriorityQueue<>();
            PriorityQueue<CompressNode> yQueue = new PriorityQueue<>();

            // 값 입력
            // -- 값 압축을 위해 pq에 담아서 관리
            for(int i = 0; i < N; i++) {
                nodes[i] = new Node(read(), read());
                xQueue.add(new CompressNode(nodes[i].x, i));
                yQueue.add(new CompressNode(nodes[i].y, i));
            }

            // 값 압축
            // -- x 압축
            int cnt = 1;
            while(!xQueue.isEmpty()) {
                CompressNode node = xQueue.poll();

                nodes[node.index].x = cnt;

                if(!xQueue.isEmpty() && node.val == xQueue.peek().val) continue;

                cnt++;
            }

            // -- y 압축
            cnt = 1;
            while(!yQueue.isEmpty()) {
                CompressNode node = yQueue.poll();

                nodes[node.index].y = cnt;

                if(!yQueue.isEmpty() && node.val == yQueue.peek().val) continue;

                cnt++;
            }

            // 계산
            long sum = 0;

            PriorityQueue<Node> queue = new PriorityQueue<>();

            for(int i = 0; i < N; i++) {
                queue.add(nodes[i]);
            }

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                int x = node.x;
                int y = node.y;
                // 현재 값 c라 하면 x는 1~c까지, y는 c~N까지 합 구한 다음 둘 중 작은 애가 짝
                sum += Math.min(queryX(1,x,2,1,size), queryY(y,size,2,1,size));

                updateX(x);
                updateY(y);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    public static void updateX(int val)  {
        val += size;

        while(val >= 2) {
            xSegments[val]++;
            val = (val + 1) >> 1;
        }
    }

    public static void updateY(int val)  {
        val += size;

        while(val >= 2) {
            ySegments[val]++;
            val = (val + 1) >> 1;
        }
    }

    public static long queryX(int left, int right, int node, int start, int end) {
        if(left > end || right < start) return 0;

        if(left <= start && end <= right) return xSegments[node];

        int half = (start + end) >> 1;
        return queryX(left, right, (node << 1) - 1, start, half) + queryX(left, right, node << 1, half + 1, end);
    }


    public static long queryY(int left, int right, int node, int start, int end) {
        if(left > end || right < start) return 0;

        if(left <= start && end <= right) return ySegments[node];

        int half = (start + end) >> 1;
        return queryY(left, right, (node << 1) - 1, start, half) + queryY(left, right, node << 1, half + 1, end);
    }

    // 압축을 위한 노드 - 더 작은 값이 우선 순위 업
    private static class CompressNode implements Comparable<CompressNode> {
        int val;
        int index;

        public CompressNode(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(CompressNode o) {
            return this.val - o.val;
        }
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x) {
                return o.y - this.y;
            }

            return this.x - o.x;
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
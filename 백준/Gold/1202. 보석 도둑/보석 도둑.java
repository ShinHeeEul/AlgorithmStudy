import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static Jewel[] arr;
    static Jewel[] segments;
    static int size;
    static int N;

    public static void main(String[] args) throws Exception {
        N = read();
        int K = read();

        arr = new Jewel[N + 1];
        size = 1;

        while(size < N) {
            size <<= 1;
        }

        for(int i = 0; i < N; i++) {
            arr[i] = new Jewel(read(), read());
        }

        arr[N] = new Jewel(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Arrays.sort(arr);

        segments = new Jewel[(size << 1) + 1];
        Arrays.fill(segments, new Jewel(0,0));

        for(int i = size + 1; i < size + N + 1; i++) {
            segments[i] = arr[i - size - 1];
            segments[i].index = i;
        }

        int segmentSize = segments.length-1;

        while(segmentSize > 1) {
            int a = (segmentSize + 1) >> 1;
            if(segments[segmentSize].val > segments[segmentSize - 1].val) segments[a] = segments[segmentSize];
            else segments[a] = segments[segmentSize - 1];
            segmentSize -= 2;
        }

        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < K; i++) {
            pq.add(read());
        }

        while(!pq.isEmpty()) {
            int weight = pq.poll();
            int index = binarySearch(weight);
            if(index < 0) continue;
            Jewel jewel = query(1, index + 1, 2, 1,size);
            ans += jewel.val;
            update(jewel.index);
        }

        System.out.println(ans);
    }

    private static void update(int segmentSize) {
        segments[segmentSize] = new Jewel(0,0);

        while(segmentSize > 1) {
            segmentSize = (segmentSize + 1) >> 1;
            if(segments[segmentSize << 1].val > segments[(segmentSize << 1) - 1].val) segments[segmentSize] = segments[segmentSize << 1];
            else segments[segmentSize] = segments[(segmentSize << 1) - 1];
        }
    }

    private static Jewel query(int left, int right, int node, int start, int end) {
        if(left > end || right < start) {
            return new Jewel(0,0);
        }
        if(left <= start && end <= right) {
            return segments[node];
        }
        int mid = (start + end) >> 1;
        Jewel j1 = query(left, right, (node << 1) - 1, start, mid);
        Jewel j2 = query(left, right, node << 1, mid + 1, end);

        if(j1.val > j2.val) return j1;
        return j2;
    }

    private static int binarySearch(int weight) {
        int start = 0;
        int end = arr.length-1;
        while(start < end) {
            int mid = (start + end) >> 1;
            Jewel jewel = arr[mid];

            if(jewel.weight < weight || (weight == jewel.weight && arr[mid + 1].weight == weight)) {
                start = mid + 1;
                continue;
            }

            if(jewel.weight == weight && arr[mid + 1].weight > weight) return mid;
            end = mid;
        }
        return end - 1;
    }

    private static class Jewel implements Comparable<Jewel> {
        int val;
        int weight;
        int index;
        boolean visited;

        public Jewel(int weight, int val) {
            this.val = val;
            this.weight = weight;
            visited = false;
        }

        @Override
        public int compareTo(Jewel o) {
            if(this.weight == o.weight) {
                return this.val - o.val;
            }

            return this.weight - o.weight;
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

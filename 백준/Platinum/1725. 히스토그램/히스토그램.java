import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedWriter bw;
    static int[] arr;
    static int[] segment;
    static long max;
    static int size;
    public static void main(String[] args) throws Exception {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = read();
            max = 0;
            segments(N, bw);
        bw.flush();
    }

    public static void segments(int N, BufferedWriter bw) throws Exception {
        size = 1;
        while(size < N) {
            size <<= 1;
        }
        arr = new int[size + 2];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int segmentSize = size * 2 + 1;
        segment = new int[segmentSize];

        //tree 초기화
        for(int i = 1; i <= N; i++) {
            arr[i] = read();
        }
        for(int i = segmentSize - size,j = 1; i < segmentSize; i++, j++) {
            segment[i] = j;
        }

        //세그먼트 트리 구성
        for(int i = segmentSize - 2; i > 0; i-=2) {
            if(arr[segment[i]] > arr[segment[i + 1]]) {
                segment[(i >> 1) + 1] = segment[i + 1];
            } else {
                segment[(i >> 1) + 1] = segment[i];
            }
        }
        getMax(1,N);
        bw.write(max+"\n");
    }

    public static void getMax(int s, int e) {

        //todo : minIndex가 잘 안나옴
        int minIndex = getMinIndex(s, e);
        if(minIndex == size + 1) return;
        max = Math.max(max, (long) arr[minIndex] * (e - s + 1));

        if(s < minIndex) {
            getMax(s, minIndex - 1);
        }
        if(e > minIndex) {
            getMax(minIndex + 1, e);
        }
    }

    public static int getMinIndex(int s, int e) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,size,2));
        int minIndex = size + 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int start = node.start;
            int end = node.end;
            int index = node.index;

            // s, e : 찾으려는 범위 값
            // start, end : 현재 범위 값
            if((s <= start) && (e >= end)) {
                int idx = segment[index];
                if(arr[minIndex] > arr[idx]) {
                    minIndex = idx;
                }
                continue;
            }

            int mid = (start + end) /2 ;
            if(s <= mid) {
                queue.add(new Node(start, mid, index * 2 - 1));
            }
            if(e > mid) {
                queue.add(new Node(mid + 1, end, index * 2));
            }
        }
        return minIndex;
    }


    public static class Node {
        int start;
        int end;
        int index;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return o;
    }
}

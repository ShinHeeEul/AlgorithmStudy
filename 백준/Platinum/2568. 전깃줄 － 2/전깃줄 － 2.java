import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Node[] nodes = new Node[N];
        PriorityQueue<Node>[] pqs = new PriorityQueue[N];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[N+1];
        int max = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(A,B);
            max = Math.max(A,max);
            pqs[i] = new PriorityQueue<Node>(Comparator.comparingInt(o -> -o.A));
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.A));

        int index = 0;
        for(int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            int B = node.B;
            if(i == 0) {
                arr[0] = B;
                pqs[0].add(node);
                continue;
            }
            int current = arr[index];
            if(current < B) {
                index++;
                arr[index] = B;
                pqs[index].add(node);
                continue;
            }

            int start = 0;
            int end = index;
            while(start < end) {
                int mid = (start + end) >>> 1;
                if(arr[mid] < B) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            arr[end] = B;
            pqs[end].add(node);
        }

        int count = N - (index + 1);
        bw.write(count + "");
        int before = pqs[index].peek().A;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = index; i >= 0; i--) {
            boolean b = true;
            int tmp = 0;
            while(!pqs[i].isEmpty()) {
                Node node = pqs[i].poll();
                if(before < node.A) {
                    pq.add(node.A);
                    continue;
                }
                if(b) {
                    b = false;
                    tmp = node.A;
                    continue;
                }
                pq.add(node.A);
            }
            before = tmp;
        }

        while(!pq.isEmpty()) {
            bw.write("\n" + pq.poll());
        }
        bw.flush();
        bw.close();
    }
    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) <= 32) continue;

        o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

    private static class Node {
        int A;
        int B;
        public Node(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}

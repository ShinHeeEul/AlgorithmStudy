import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Node>[] list = new ArrayList[N];
        Node[] lis = new Node[N];
        int current = 0;

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            int a = Integer.parseInt(st.nextToken());
            if (i == 0) {
                lis[0] = new Node(a, 0);
                list[i].add(new Node(a, 0));
                continue;
            }
            if (a > lis[current].val) {
                lis[++current] = new Node(a, i);
                list[current].add(new Node(a, i));
            } else {
                int index = binarySearch(lis, 0, current, a);
                lis[index] = new Node(a, i);
                list[index].add(new Node(a, i));
            }
        }

        System.out.println(current + 1);

        StringBuilder s = new StringBuilder();
        Node next = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<>();
        for (int i = current; i >= 0; i--) {
            for (Node n : list[i]) {
                if ((next.index > n.index) && (next.val > n.val)) {
                    stack.add(n.val);
                    next = n;
                    break;
                }
            }
        }
        while(!stack.isEmpty()) {
            s.append(stack.pop()).append(" ");
        }
        System.out.println(s);

        br.close();
    }

    static class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    static int binarySearch(Node[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (arr[mid].val < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}

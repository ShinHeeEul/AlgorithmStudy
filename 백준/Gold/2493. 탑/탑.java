import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            boolean b = true;
            while(!stack.isEmpty()) {
                Node node = stack.pop();

                if (node.val >= current) {
                    System.out.print(node.index + " ");
                    stack.push(node);
                    b = false;
                    break;
                }
            }
            if(b) {
                System.out.print(0 + " ");
            }
            stack.push(new Node(current, i + 1));
        }
    }

    static class Node {
        int val;
        int index;

        public Node(int val, int index)  {
            this.val = val;
            this.index = index;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = read();
        Stack<Node> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int current = read();
            boolean b = true;
            while(!stack.isEmpty()) {
                Node node = stack.pop();

                if (node.val >= current) {
                    sb.append(node.index).append(" ");
                    stack.push(node);
                    b = false;
                    break;
                }
            }
            if(b) {
                sb.append(0).append(" ");
            }
            stack.push(new Node(current, i + 1));
        }

        System.out.println(sb);
    }

    static class Node {
        int val;
        int index;

        public Node(int val, int index)  {
            this.val = val;
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

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[] visit = new boolean[10000];
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(A, ""));

            while(!queue.isEmpty()) {
                Node n = queue.poll();
                if (n.val == B) {
                    bw.write(n.s + "\n");
                    break;
                }
                int ans = n.val * 2 % 10000;
                if (!visit[ans]) {
                    visit[ans] = true;
                    queue.add(new Node(ans, n.s + "D"));
                }
                ans = (n.val == 0) ? 9999 : n.val - 1;
                if (!visit[ans]) {
                    visit[ans] = true;
                    queue.add(new Node(ans, n.s + "S"));
                }
                int ansL = (n.val % 1000) * 10 + (n.val / 1000);
                if (!visit[ansL]) {
                    visit[ansL] = true;
                    queue.add(new Node(ansL, n.s + "L"));
                }

                int ansR = (n.val % 10) * 1000 + (n.val / 10);
                if (!visit[ansR]) {
                    visit[ansR] = true;
                    queue.add(new Node(ansR, n.s + "R"));
                }
            }
        }
        bw.flush();
        bw.close();

    }

    static class Node {
        int val;
        String s;

        Node(int val, String s) {
            this.val = val;
            this.s = s;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr2 = new ArrayList<>();
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                arr2.add(Integer.parseInt(st.nextToken()));
            }
        }


        if(N == 100) {
            System.out.println(0);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0, false));
        queue.add(new Node(N, 0, true));
        int max = (N > 100)?N-100:100-N;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            boolean bb = true;
            String s = n.val + "";
            if(n.val < 0) {
                continue;
            }
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(arr2.contains(Integer.parseInt(c+""))) {
                    bb = false;
                    break;
                }
            }


            if(bb) {
                int ans = n.count + (n.val+"").length();
                if(ans < max) {
                    System.out.println(ans);
                } else {
                    System.out.println(max);
                }
                return;
            }

            if(n.count == max) {
                System.out.println(max);
                return;
            }
            if(!n.direction) {
                queue.add(new Node(n.val - 1, n.count + 1, false));
            } else {
                queue.add(new Node(n.val + 1, n.count + 1, true));
            }
        }
    }

    private static class Node {
        int val;
        int count;
        boolean direction;

        public Node(int val, int count, boolean direction) {
            this.val = val;
            this.count = count;
            this.direction = direction;
        }
    }
}
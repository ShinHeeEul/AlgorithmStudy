import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[] visited = new boolean[100_002];
    public static void main(String[] args) throws Exception {
       int N = read();
       int K = read();

       int max = Integer.MAX_VALUE;

       if(K <= N) {
           System.out.println(N - K);
       } else {
           Queue<Node> queue = new LinkedList<>();
           queue.add(new Node(0, N));
           visited[N] = true;

           while(!queue.isEmpty()) {
               Node node = queue.poll();
               int value = node.value;
               int count = node.count;
               if(count > max) {
                   break;
               }

               while(value <= 100_000) {

                   max = Math.min(max, Math.abs(K - value) + count);
                   if(value > 0) {
                       if(!visited[value - 1]) {
                           visited[value - 1] = true;
                           queue.add(new Node(count + 1, value - 1));
                       }
                   }
                   if(value < 100_000) {
                       if(!visited[value + 1]) {
                           visited[value + 1] = true;
                           queue.add(new Node(count + 1, value + 1));
                       }
                   }
                   if(value == 0) break;
                   value *= 2;
               }


           }

           System.out.println(max);
       }
    }

    private static class Node {
        int value;
        int count;

        public Node(int index, int value) {
            this.count = index;
            this.value = value;
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

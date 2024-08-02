import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        int T = read();
        for(int i = 0; i < T; i++) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Node> reversePq = new PriorityQueue<>();
            int Q  = read();
            int count = 0;
            for(int j = 0; j < Q; j++) {
                char oper = (char) System.in.read();
                System.in.read();
                int val =  read();

                if(oper == 'I') {
                    count++;
                    pq.add(new Node(j, val));
                    reversePq.add(new Node(j, val));
                    continue;
                }
                if(val > 0) {
                    while(!pq.isEmpty()) {
                        int index = pq.poll().index;
                        if(!map.getOrDefault(index, false)) {
                            map.put(index, true);
                            break;
                        }
                    }
                } else {
                    while(!reversePq.isEmpty()) {
                        int index = reversePq.poll().index;
                        if(!map.getOrDefault(index, false)) {
                            map.put(index, true);
                            break;
                        }
                    }
                }
            }
            if(map.size() == count) {
                System.out.println("EMPTY");
                continue;
            }
            long max = 0;
            long min = 0;
            while(!pq.isEmpty()) {
                Node node = pq.poll();
                int index = node.index;
                long val = node.val;
                if(!map.getOrDefault(index, false)) {
                    max = val;
                    break;
                }
            }
            while(!reversePq.isEmpty()) {
                Node node = reversePq.poll();
                int index = node.index;
                long val = node.val;
                if(!map.getOrDefault(index, false)) {
                    min = val;
                    break;
                }
            }
            System.out.println(max + " " + min);
        }
    }

    public static class Node implements Comparable<Node> {
        long val;
        int index;

        public Node(int index, int val) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            long ans = val - o.val;
            if(ans > Integer.MAX_VALUE) return 1;
            else if(ans < Integer.MIN_VALUE) return -1;
            return (int) ans;
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
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        PriorityQueue<Integer> endpq = new PriorityQueue<>();
        PriorityQueue<Integer> startpq = new PriorityQueue<>(Comparator.reverseOrder());
        
        int size = targets.length;
        Node[] nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(targets[i][0], targets[i][1]);
        }
        Arrays.sort(nodes);
        endpq.add(nodes[0].end);
        startpq.add(nodes[0].start);
        
        for(int i = 1; i < size; i++) {
            Node node = nodes[i];
            if(startpq.peek() < node.end) {
                endpq.poll();
                endpq.add(node.end);
                startpq.add(node.start);
                continue;
            }
            endpq.add(node.end);
            startpq = new PriorityQueue<>(Comparator.reverseOrder());
            startpq.add(node.start);
        }
        return endpq.size();
    }
    
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Node n) {
            if(n.end == this.end) {
                return n.start - this.start;
            }
            return n.end - this.end;
        }
    }
}
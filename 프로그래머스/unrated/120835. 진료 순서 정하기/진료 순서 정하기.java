import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
       int[] answer = new int[emergency.length];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for(int i = 0; i < emergency.length; i++) {
            queue.add(new Node(emergency[i], i));
        }
        
        for(int i = 0; i < emergency.length; i++) {
            Node n = queue.poll();
            answer[n.index] = i+1;
        }
        
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int val;
        int index;
        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
        
        public int compareTo(Node o) {
            return o.val - this.val;
        }
    }
}
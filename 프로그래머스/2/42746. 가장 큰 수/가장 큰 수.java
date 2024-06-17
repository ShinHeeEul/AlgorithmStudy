import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int number : numbers)
            pq.add(new Node(number));
        boolean isZero = true;
        while(!pq.isEmpty()) {
            int a = pq.poll().val;
            if(a != 0) isZero = false;
            answer += a;
            
        }
        if(isZero) answer = "0";
        return answer;
    }
    
    public class Node implements Comparable<Node> {
        int val;
        
        public Node(int val) {
            this.val = val;
        }
        
        public int compareTo(Node o) {
            String v1 = val + "";
            String v2 = o.val + "";
            int min = Math.min(v1.length(), v2.length());
            for(int i = 0; i < min; i++) {
                if(v1.charAt(i) == v2.charAt(i)) continue;
                if(v1.charAt(i) > v2.charAt(i)) return -1;
                return 1;
            }
                if(Integer.parseInt(v1 + v2) <= Integer.parseInt(v2+v1)) {
                    return 1;
                }
            return -1;
        }
    }
}
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int work : works) {
            pq.add(work);
        }
        
        while(!pq.isEmpty() && n > 0) {
            int node = pq.poll();
            if(pq.isEmpty()) {
                if(n >= node) {
                    break;
                }
                pq.add(node - n);
                n = 0;
            }
            int nextNode = pq.peek();
            
            
            int diff = Math.min(n, node - nextNode);
            
            if(node == nextNode) diff = 1;
            
            int tmp = node - diff;
            if(tmp != 0) pq.add(tmp);
            n -= diff;
        }
        
        while(!pq.isEmpty()) {
            int a = pq.poll();
            answer += (a * a);
        }
        
        return answer;
    }
}
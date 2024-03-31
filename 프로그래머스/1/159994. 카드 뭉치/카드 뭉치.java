import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        
        for(String card : cards1) queue1.add(card);
        for(String card : cards2) queue2.add(card);
        
        for(String g : goal) {
            if(g.equals(queue1.peek())) {
                queue1.poll();
            } else if(g.equals(queue2.peek())) {
                queue2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
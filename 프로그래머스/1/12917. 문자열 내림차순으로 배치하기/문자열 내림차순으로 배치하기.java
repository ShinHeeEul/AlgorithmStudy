import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(char c : s.toCharArray()) pq.add(c);
        
        while(!pq.isEmpty()) answer += pq.poll();
        return answer;
    }
}
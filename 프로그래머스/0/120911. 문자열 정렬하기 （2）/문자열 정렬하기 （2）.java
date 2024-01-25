import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        PriorityQueue<Character> pq = new PriorityQueue<>();
        
        for(char c : my_string.toCharArray()) {
            if(c >= 'A' && c <= 'Z') {
                c -= 'A';
                c += 'a';
            }
            pq.add(c);
        }
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}
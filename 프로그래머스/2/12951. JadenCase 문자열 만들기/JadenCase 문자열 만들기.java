import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        answer += (s.charAt(0) + "").toUpperCase();
        
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char before = s.charAt(i-1);
            if(before == ' ') {
                if((c >= 'a') && (c <= 'z')) 
                    c = (char) (c - ('a'-'A'));
            }
            answer += c;
        }
        
        return answer;
    }
}
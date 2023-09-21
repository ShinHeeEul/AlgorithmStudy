import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++) {
            String s = babbling[i];
            
            s = s.replaceAll("aya","/");
            s = s.replaceAll("ye","/");
            s = s.replaceAll("woo","/");
            s = s.replaceAll("ma","/");
            s = s.replaceAll("/","");
            if(s.equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}
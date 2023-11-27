import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] picture, int k) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i = 0; i < picture.length; i++) {
            String s = picture[i];
            String an = "";
            for(char c : s.toCharArray()) {
                for(int j = 0; j < k ;j++) {
                    an += c;
                }
            }
            
            for(int j = 0; j < k; j++) {
                answer.add(an);
            }
            
        }
        return answer;
    }
}
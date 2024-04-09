import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        ArrayList<Character> skipSeq = new ArrayList<>();
        
        for(char c : skip.toCharArray()) skipSeq.add(c);
        
        for(char c : s.toCharArray()) {
            char cc = c;
            int tt = index;
            for(int i = 1; i <= tt; i++) {
                int kk = c + i;
                cc = (char) kk;
                while(cc > 'z') {
                    cc -= ('z'- 'a' + 1);
                }
                if(skipSeq.contains(cc)) tt++;
            }
            answer += cc;
        }
        return answer;
    }
}
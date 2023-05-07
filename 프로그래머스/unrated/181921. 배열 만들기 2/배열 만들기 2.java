import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList();
        
        for(int i = l; i <= r; i++) {
            String s = i + "";
            boolean b = true;
            for(char c : s.toCharArray()) {
                if(c != '5') {
                    if(c != '0') {
                        b = false;
                        break;
                    }
                }
            }
            if(b) answer.add(i);
        }
        if(answer.size() == 0) answer.add(-1);
        return answer;
    }
}
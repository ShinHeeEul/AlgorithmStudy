import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList();
        for(String S : intStrs) {
            int i = Integer.parseInt(S.substring(s,s+l));
            if(i > k) answer.add(i);
        }
        return answer;
    }
}
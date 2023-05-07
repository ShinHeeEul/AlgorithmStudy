import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int start, int end) {
        ArrayList<Integer> answer = new ArrayList();
        for(int i = start; i <= end; i++) answer.add(i);
        return answer;
    }
}
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList();
        Arrays.sort(num_list);
        
        for(int i : num_list) {
            if(answer.size() == 5) break;
            answer.add(i);
        }
        return answer;
    }
}
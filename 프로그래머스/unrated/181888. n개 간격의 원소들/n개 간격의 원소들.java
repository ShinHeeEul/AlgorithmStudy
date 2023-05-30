import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] num_list, int n) {
        ArrayList<Integer> answer = new ArrayList();        
        for(int i = 0; i < num_list.length; i+=n)
            answer.add(num_list[i]);
        
        return answer;
    }
}
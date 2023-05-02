import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        int len = num_list.length-1;
        ArrayList<Integer> answer = new ArrayList();
        for(int i : num_list)
            answer.add(i);
        if(num_list[len] > num_list[len-1]) answer.add(num_list[len] - num_list[len-1]);
        else answer.add(num_list[len] * 2);
        return answer;
    }
    
 
}
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] num_list, int n) {
        ArrayList<Integer> answer = new ArrayList();
        for(int i = n-1; i < num_list.length; i++)
            answer.add(num_list[i]);
        return answer;
    }
}
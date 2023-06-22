import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList();
        Arrays.sort(num_list);
        int count = 0;
        for(int i : num_list) {
            count++;
            if(count <= 5) continue; 
            answer.add(i);
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int[] query) {
        ArrayList<Integer> answer = new ArrayList();
        
        for(int i =0; i < arr.length; i++)
            answer.add(arr[i]);
        
        for(int i = 0;  i < query.length; i++) {
            if(i % 2 == 0){
                int k = answer.size();
                for(int j = query[i]+1; j < k; j++)
                    answer.remove(answer.size()-1);
            }
            else {
                for(int j = 0; j < query[i]; j++)
                    answer.remove(0);
            }
        }
        return answer;
    }
}
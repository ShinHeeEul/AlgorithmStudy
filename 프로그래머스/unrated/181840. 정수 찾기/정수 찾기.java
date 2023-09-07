import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        ArrayList<Integer> numList = new ArrayList();
        
        for(int i = 0 ; i < num_list.length ; i++) {
            if(num_list[i] == n) {
                return 1;
            }
        }
        return 0;
    }
}
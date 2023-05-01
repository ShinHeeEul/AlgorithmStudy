import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        for(int i : num_list) {
            if(i % 2 != 0) odd += i;
            else even += i;
        }
        answer = Integer.parseInt(odd) + Integer.parseInt(even);
        return answer;
    }
}
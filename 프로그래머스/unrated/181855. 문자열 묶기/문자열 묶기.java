import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] max = new int[31];
        
        for(String s : strArr)
            max[s.length()]++;
        
        Arrays.sort(max);
        return max[30];
    }
}
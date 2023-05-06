import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        
        for(int i = 0; i < queries.length; i++) {
            
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            int min = 1000000;
            for(int j = 0; j < arr.length; j++) {
            int ii = arr[j];
            if(s <= j) {
                if(e >= j) {
                    if(ii > k) {
                        if(min > ii)
                            min = ii;
                    }
                }
            }
            }
            answer[i] = min == 1000000?-1:min;
        }
        return answer;
    }
}
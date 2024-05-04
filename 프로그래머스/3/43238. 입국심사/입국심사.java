import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long min = Long.MAX_VALUE;
        for(int time : times) min  = Math.min(min, time);
        long answer = min * n;
        long start = 0;
        long end = min * n;
        
        while(start < end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for(int time : times) sum += (mid / time);
            if(n <= sum) {         
                answer = Math.min(answer, mid);
                end = mid;
                continue;
            }
            start = mid + 1;
        }
        
        return answer;
    }
}
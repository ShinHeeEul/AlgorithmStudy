import java.util.*;

class Solution {
    long max = Long.MIN_VALUE;
    long[] dps;
    long[] reverseDps;
    
    public long solution(int[] sequence) {
        dps = new long[sequence.length];
        reverseDps = new long[sequence.length];
        dps[0] = sequence[0];
        reverseDps[0] = -sequence[0];
        for(int i = 1; i < sequence.length; i++) {
            if(i % 2 == 0) {
                dps[i] = Math.max(sequence[i], dps[i - 1] + sequence[i]);
                reverseDps[i] = Math.max(-sequence[i], reverseDps[i - 1] - sequence[i]);
            } else {
                dps[i] = Math.max(-sequence[i], dps[i - 1] - sequence[i]);
                reverseDps[i] = Math.max(sequence[i], reverseDps[i - 1] + sequence[i]);
            }
            
            max = Math.max(max, Math.max(dps[i-1], reverseDps[i-1]));
        }
        
        max = Math.max(max, Math.max(dps[sequence.length-1], reverseDps[sequence.length-1]));
        
        return max;
    }
    
}
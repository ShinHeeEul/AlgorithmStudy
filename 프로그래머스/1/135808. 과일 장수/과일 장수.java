import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] scored = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scored, (i1, i2) -> i2 - i1);
        
        
        for(int i = 0; i + m <= scored.length; i += m) {
            int min = 100;
            for(int j = 0; j < m; j++) min = Math.min(min, scored[i + j]);
            answer += min * m;
        }
        
        return answer;
    }
}
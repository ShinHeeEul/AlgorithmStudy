import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int[] err = {-1};
        if(n > s) return err;
            for(int i = 0; i < n; i++) {
                answer[i] += s/n;
            }
            s -= (s/n * n);
            for(int i = 0; i < s; i++) {
                answer[i] += 1;
            }
        
        Arrays.sort(answer);
        return answer;
    }
}
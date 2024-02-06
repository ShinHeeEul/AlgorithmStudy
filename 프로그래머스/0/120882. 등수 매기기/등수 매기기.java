import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        int count = 1;
        for(int i = 200; i >= 0; i--) {
            int dup = 0;
            for(int j = 0; j < score.length; j++) {
                if(score[j][0] + score[j][1] == i) {
                    answer[j] = count;
                    dup++;
                }
            }
            count += dup;
        }
        return answer;
    }
}
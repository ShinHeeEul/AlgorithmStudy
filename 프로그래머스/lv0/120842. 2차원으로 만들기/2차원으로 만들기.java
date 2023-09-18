import java.util.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        for(int cnt = 0; cnt < num_list.length/n; cnt++) {
            for(int i = 0; i < n; i++) {
                answer[cnt][i] = num_list[cnt*n+i];
            }
        }
        return answer;
    }
}
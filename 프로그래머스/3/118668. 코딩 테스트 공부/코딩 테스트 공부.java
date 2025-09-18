import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        
        int idx = 500;
        int[][] dp = new int[idx][idx];
        
        
        for(int i = 0; i < idx; i++) Arrays.fill(dp[i], 1000000);
        
        int maxC = 0;
        int maxA = 0;
        
        dp[alp][cop] = 0;
        
        for(int[] problem : problems) {
            maxA = Math.max(maxA, problem[0]);
            maxC = Math.max(maxC, problem[1]);
        }
        
        for(int i = alp; i < idx; i++) {
            for(int j = cop; j < idx; j++) {
                if(i + 1 < idx) dp[i + 1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                if(j + 1 < idx) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for(int[] problem : problems) {
                    if(i >= problem[0] && j >= problem[1]) {
                        int a = i + problem[2];
                        int b = j + problem[3];
                      if(a < idx && b < idx)  {
                          dp[a][b] = Math.min(dp[a][b], dp[i][j] + problem[4]);
                        
                      }
                    }
                }
            }
        }
        for(int i = maxA; i < idx; i++) {
            for(int j = maxC; j < idx; j++) {
                
                answer = Math.min(answer, dp[i][j]);
            }
                
        }
        return answer;
    }
}
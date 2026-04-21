import java.util.*;
import java.math.*;

class Solution {
    int DEFAULT = Integer.MAX_VALUE >> 1;
    int[][] val =  {
    { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
    { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
    { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
    { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
    { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
    { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
    { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
    { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
    { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
    { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
};
    public int solution(String numbers) {
        
        int[][][] dp = new int[100010][10][10];
        for(int i = 0; i < 100010; i++) {
            for(int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], DEFAULT);
            }
        }
        dp[0][4][6] = 0;
        dp[0][6][4] = 0;
        char[] numberss = numbers.toCharArray();
        for(int i = 0; i < numbers.length(); i++) {
            char c = numberss[i];
            int a = Integer.parseInt(c + "");
            
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    if(dp[i][j][k] == DEFAULT) continue;

                    if(a != k) {
                    dp[i + 1][a][k] = Math.min(dp[i + 1][a][k], dp[i][j][k] + val[a][j]);
                    }
                    if(a != j) {
                    dp[i + 1][j][a] = Math.min(dp[i + 1][j][a], dp[i][j][k] + val[k][a]);
                    }
                }
            }
        }
        
        int min = 10000000;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                min = Math.min(min, dp[numbers.length()][i][j]);
            }
        }
        return min;
    }

}
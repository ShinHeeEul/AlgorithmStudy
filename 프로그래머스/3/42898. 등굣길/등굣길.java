class Solution {
    int MOD = 1_000_000_007;
    
    int[] dp;
    boolean[][] isWater;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        dp = new int[m + 1];
        isWater = new boolean[n][m];
        
        for(int[] puddle : puddles) {
            isWater[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        // 옆에꺼 1증가 시키고, 지금꺼 그대로?
        // dp[i] = dp[i - 1] + dp[i]
        
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j]) {
                    dp[j] = 0;
                    continue;
                }
                dp[j + 1] = dp[j] + dp[j + 1];
                dp[j + 1] %= MOD;
            }
        }
        answer = dp[m-1] % MOD;
        return answer;
    }
}
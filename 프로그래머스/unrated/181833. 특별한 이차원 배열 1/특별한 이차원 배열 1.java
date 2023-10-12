class Solution {
    public int[][] solution(int n) {
        int[][] ss = new int[n][n];
        
        for(int i = 0; i < n; i++) {
                ss[i][i] = 1;
        }
        
    return ss;
    }
}
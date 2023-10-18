class Solution {
    public Long solution(int n) {
        Long[] S = new Long[n+1];
        S[0] = 0L;
        S[1] = 1L;
        for(int i = 2; i < n+1; i++) {
            S[i] = S[i-1] % 1234567 + S[i-2] % 1234567; 
            S[i] %= 1234567;
        }
        return S[n];
    }
}
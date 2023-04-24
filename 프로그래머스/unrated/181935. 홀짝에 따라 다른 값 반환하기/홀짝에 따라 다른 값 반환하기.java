class Solution {
    public int solution(int n) {
        int answer = 0;
        int odd = 0;
        int even = 0;
        for(int i = 1; i <= n; i++) {
              odd += i;
              i++;
            if(i > n) break;
              even += i * i;
        }
        if(n % 2 == 0) return even;
        return odd;
    }
}
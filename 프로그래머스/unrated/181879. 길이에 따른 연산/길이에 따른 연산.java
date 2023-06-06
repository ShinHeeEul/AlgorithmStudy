class Solution {
    public int solution(int[] num_list) {
        int ans = 0;
        if(num_list.length >= 11) {
            for(int i : num_list) ans += i;
        }
        else {
            ans = 1;
            for(int i : num_list) ans *= i;
        }
        
        return ans;
    }
}
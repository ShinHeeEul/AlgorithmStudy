import java.math.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int aa = a % 2;
        int bb = b % 2;
        
        if(aa == 1 && bb == 1) {
            answer += (a * a);
            answer += (b * b);
        } else if(aa == 0 && bb == 0) {
            answer += Math.abs(a - b);
        } else {
            answer += (2 * (a + b));
        }
        return answer;
    }
}
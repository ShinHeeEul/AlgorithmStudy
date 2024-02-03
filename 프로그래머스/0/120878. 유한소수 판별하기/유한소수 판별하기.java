import java.lang.*;
class Solution {
    public int solution(int a, int b) {
        
        for(int i = 2; i <= Math.min(a,b); i++) {
            if((a % i == 0) && (b % i == 0)) {
                a /= i;
                b /= i;
                i--;
            }
        }
        
        while(b % 5 == 0) b /= 5;
        while(b % 2 == 0) b /= 2;
        if(b != 1) return 2;
        return 1;
    }
}
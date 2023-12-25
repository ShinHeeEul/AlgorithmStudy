import java.math.*;

class Solution {
    public int solution(int n) {
        BigInteger i = BigInteger.ONE;
        
        for(int  j = 1; j <= n; j++) {
            i = i.multiply(new BigInteger(j + ""));
            if(i.intValue() == n) {
                return j;
            } else if(i.intValue() > n) {
                return j-1;
            }
        }
        return -1;
    }
}
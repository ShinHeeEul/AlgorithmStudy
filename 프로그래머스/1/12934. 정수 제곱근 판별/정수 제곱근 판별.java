import java.math.*;

class Solution {
    public long solution(long n) {
        double d = Math.sqrt(n);
        if(d == (long) d) {
            long d1 = (long) d+1;
            return d1 * d1;
        }
        return -1;
    }
}
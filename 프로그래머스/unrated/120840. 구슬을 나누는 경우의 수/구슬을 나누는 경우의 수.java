import java.util.*;
import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        BigInteger answer = BigInteger.ONE;
        for(int i = balls; i > share; i--) {
            answer = answer.multiply(new BigInteger(i + ""));
        }
        for(int i = 1; i <= (balls- share); i++) {
            answer = answer.divide(new BigInteger(i + ""));
        }
        return answer.intValue();
    }
}
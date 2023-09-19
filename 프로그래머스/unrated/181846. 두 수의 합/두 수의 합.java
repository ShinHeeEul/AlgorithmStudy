import java.util.*;
import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger c = new BigInteger(a);
        BigInteger d = new BigInteger(b);
        
        return c.add(d).toString();
    }
}
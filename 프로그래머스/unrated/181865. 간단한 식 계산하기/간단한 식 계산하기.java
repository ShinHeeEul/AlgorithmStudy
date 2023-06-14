import java.util.*;

class Solution {
    public int solution(String binomial) {
        StringTokenizer st = new StringTokenizer(binomial);
        
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        switch(op) {
            case "+":
                return a + b;
            case "-":
                return a- b;
            case "*":
                return a * b;
        }
        return 0;
    }
}
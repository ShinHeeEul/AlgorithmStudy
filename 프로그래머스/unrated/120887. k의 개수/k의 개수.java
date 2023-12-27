import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        for(int a = i; a <= j; a++) {
            String s = a + "";
            
            for(char c : s.toCharArray()) {
                if((c + "").equals(k + "")) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
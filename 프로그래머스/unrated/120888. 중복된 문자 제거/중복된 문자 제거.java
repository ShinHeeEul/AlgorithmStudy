import java.util.*;

class Solution {
    public String solution(String my_string) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for(char c : my_string.toCharArray()) {
            set.add(c);
        }
        String s = "";
        for(char c : set) {
            s += c;
        }
        
        return s;
        
    }
}
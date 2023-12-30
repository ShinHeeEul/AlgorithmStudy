import java.util.*;

class Solution {
    public String solution(String s) {
        String ss = "";
        ArrayList<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            if(map.get(c) == null) {
                map.put(c, 1);
                continue;
            }
            map.put(c, map.get(c)+1);
        }
        
        for(char c : map.keySet()) {
            if(map.get(c) == 1) {
                list.add(c);
            }
        }
        
        Collections.sort(list);
        
        for(char c : list) {
            ss += c;
        }
        
        return ss;
    }
}
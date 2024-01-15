import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> list = new ArrayList();
        for(char c : my_string.toCharArray()) {
            if(c >= '0' && c <= '9') {
                list.add(Integer.parseInt(c + ""));
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
}
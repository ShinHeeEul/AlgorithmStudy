import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] names) {
        ArrayList<String> arr = new ArrayList();
        
        for(int i = 0; i < names.length; i+=5)
            arr.add(names[i]);
        
        return arr;
    }
}
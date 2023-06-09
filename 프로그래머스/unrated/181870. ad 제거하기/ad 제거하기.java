import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] strArr) {
        ArrayList<String> arr = new ArrayList();
        
        for(String s : strArr) {
            if(s.contains("ad")) continue;
            arr.add(s);
        }
        return arr;
    }
}
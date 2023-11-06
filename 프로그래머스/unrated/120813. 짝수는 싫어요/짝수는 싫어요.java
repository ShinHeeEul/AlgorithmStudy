import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i+=2) {
            list.add(i);
        }
        
        return list;
    }
}
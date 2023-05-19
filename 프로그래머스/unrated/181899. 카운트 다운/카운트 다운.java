import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int start, int end) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = start; i >= end ; i--)
            list.add(i);
        
        return list;
    }
}
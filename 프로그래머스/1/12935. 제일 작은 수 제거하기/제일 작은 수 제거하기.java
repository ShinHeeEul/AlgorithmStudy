import java.util.*;
import java.math.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int a : arr) {
            min = Math.min(min, a);
            list.add(a);
        }
        list.remove(list.indexOf(min));
        if(list.size() == 0) list.add(-1);
        return list;
    }
}
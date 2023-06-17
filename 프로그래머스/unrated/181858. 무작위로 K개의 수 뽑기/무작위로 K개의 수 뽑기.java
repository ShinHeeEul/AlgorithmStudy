import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int k) {
        LinkedHashSet<Integer> set = new LinkedHashSet();
        
        for(int i = 0;(k > set.size()) && (i < arr.length); i++)
            set.add(arr[i]);
        
        ArrayList<Integer> list = new ArrayList();
        
        for(int i : set)
            list.add(i);
        
        while(list.size() < k) list.add(-1);
        
        return list;
    }
}
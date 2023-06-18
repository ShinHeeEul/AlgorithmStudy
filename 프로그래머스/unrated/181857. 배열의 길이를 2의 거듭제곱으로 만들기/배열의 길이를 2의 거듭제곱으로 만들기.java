import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < arr.length; i++) list.add(arr[i]);
        
        int count = 1;
        while(arr.length > count) count *= 2;
        
        while(list.size() != count) {
            list.add(0);
        }
        
        return list;
    }
}
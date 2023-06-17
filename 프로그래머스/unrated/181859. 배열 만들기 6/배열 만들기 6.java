import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList();
        for(int i = 0; i < arr.length; i++) {
            if(stk.isEmpty()) {
                stk.add(arr[i]);
                continue;
            }
            if(stk.get(stk.size()-1) == arr[i]) {
                stk.remove(stk.size()-1);
                continue;
            }
            stk.add(arr[i]);
    
        }
        
        if(stk.isEmpty()) stk.add(-1);
        return stk;
    }
}
import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> arrs = new ArrayList();
        
        for(int i = 0; i < arr.length; i++) {
            arrs.add(arr[i]);
        }
        
        for(int i = 0; i < delete_list.length; i++) {
            if(arrs.indexOf(delete_list[i]) == -1) continue;
            arrs.remove(arrs.indexOf(delete_list[i]));
}
        return arrs;
    }
}
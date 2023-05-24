import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> arrlist = new ArrayList();
        
        
        for(int[] a : intervals) {
            for(int i = a[0]; i <= a[1]; i++) 
                arrlist.add(arr[i]);
        }
        return arrlist;
    }
}
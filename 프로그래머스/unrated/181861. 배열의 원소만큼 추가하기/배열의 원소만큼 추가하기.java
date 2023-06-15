import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> ans = new ArrayList();
        for(int i : arr) {
            for(int j = 0; j < i; j++)
                ans.add(i);
        }
        return ans;
    }
}
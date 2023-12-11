import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList();
        for(int num : numlist) {
            if(num%n == 0) {
                list.add(num);
            }
        }
        
        return list;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            int a = array[i];
            if(map.get(a) == null) {
                map.put(a, 1);
                continue;
            }
            map.put(a, map.get(a)+1);
        }
        int max = -1;
        int answer = -1;
        boolean b = false;
        for(int key : map.keySet()) {
            int a = map.get(key);
            if(max == a) {
                b = true;
                continue;
            }
            if(max < a) {
                b = false;
                max = a;
                answer = key;
            }
        }
        return b?-1:answer;
    }
}
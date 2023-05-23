import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList();
        boolean b = false;
        int count = 0;
        for(int i : arr) {
            if(i == 2) count++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(count == 0) break;
            if(arr[i] == 2) {
                count--;
                b = true;
            }
            if(b) {
                answer.add(arr[i]);
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        return answer;
    }
}
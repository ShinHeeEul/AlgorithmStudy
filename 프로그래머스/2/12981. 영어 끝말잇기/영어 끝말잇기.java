import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> arr = new ArrayList<>();
        arr.add(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            String before = words[i-1];
            String after = words[i];
            if(arr.contains(after) ||
               (before.charAt(before.length()-1) != after.charAt(0))) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            arr.add(after);
        }

        return answer;
    }
}
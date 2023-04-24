import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList();
        int current = 0;
        while(current < progresses.length) {
            int count = 0;
            boolean today = false;
            for(int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            while(progresses[current] >= 100) {
                count++;
                current++;
                today = true;
                if(current >= progresses.length) break;
            }

            if(today) answer.add(count);
        }

        return answer;
    }
}
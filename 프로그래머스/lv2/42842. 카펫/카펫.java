import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int wall = (brown - 4) / 2;
        for(int i = 1; i <= wall; i++) {
            int check = i * (wall - i);
            if(check == yellow) {
                answer[1] = i + 2;
                answer[0] = wall - i + 2;
                break;
            }
        }
        return answer;
    }
}
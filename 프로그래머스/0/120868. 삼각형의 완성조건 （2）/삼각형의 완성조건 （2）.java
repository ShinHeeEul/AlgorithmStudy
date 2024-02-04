import java.lang.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        for(int i = 1; i <= 2000; i++) {
            int l = Math.max(i, Math.max(sides[0], sides[1]));
            int a = i + sides[0] + sides[1];
            if(a-l > l) answer++;
        }
        return answer;
    }
}
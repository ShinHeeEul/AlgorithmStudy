import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            if(max < i) max = i;
            if(min > i) min = i;
        }
        answer += min;
        answer += " ";
        answer += max;
        return answer;
    }
}
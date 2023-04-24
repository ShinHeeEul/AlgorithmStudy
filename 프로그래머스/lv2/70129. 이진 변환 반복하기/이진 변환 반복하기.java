import java.util.*;

class Solution {
    public int[] solution(String s) {

        int zero = 0;
        int count = 0;
        while(!s.equals("1")) {
            String tmp = "";
            count++;
            for(char c : s.toCharArray()) {
                if(c == '1') {
                   tmp += c;
                    continue;
              }
                zero++;
            }

            //tmp의 길이를 2진법으로 표현
            int l = tmp.length();
            tmp = "";
            //6 -> 6 % 2 = 0
            //(6/2) % 2 = 1 1 % 2 = 1 110
            while(l != 0) {
                tmp += (l % 2);
                l /= 2;
            }
            //System.out.println(tmp);
            s = tmp;
        }
        int[] answer = {count, zero};
        return answer;
    }
}
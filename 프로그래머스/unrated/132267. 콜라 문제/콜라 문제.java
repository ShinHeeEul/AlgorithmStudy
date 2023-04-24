import java.util.*;

class Solution {
    //빈병 a개를 가져다주면 b 병을 주는 마트일 때 n 병일 때 최대 몇 병?    
    public int solution(int a, int b, int n) {
        int count = 0;
        while(n >= a) {
            int next = n / a * b; //다음에 받을 콜라
            n = n % a + next;
            count += next;
        }
        return count;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {numer1 * denom2 + denom1 * numer2, denom1 * denom2};
        int ran = Math.min(answer[0], answer[1]);
        for(int i = 2; i <= ran; i++) {
            if(answer[0] % i == 0 && answer[1] % i == 0) {
                answer[0] /= i;
                answer[1] /= i;
                i--;
            }
        }
        return answer;
    }
}
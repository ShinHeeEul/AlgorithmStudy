import java.math.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int min = 100000;
        int max = 0;
        for(int[] size : sizes) {
            min = Math.min(min, Math.min(size[0], size[1]));
            max = Math.max(max, Math.max(size[0], size[1]));
        }
        for(int i = min; i <= max; i++) {
            for(int j = i; j <= max; j++) {
                boolean b = true;
                for(int[] size : sizes) {
                    if((size[0] <= i && size[1] <= j) ||
                      (size[1] <= i && size[0] <= j)) {
                        answer = i * j;
                        continue;
                    }
                    j = Math.max(j, Math.min(size[0], size[1]));
                    b = false;
                    break;
                }
                if(b) return answer;
            }
        }
        return 0;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        
        int x = 0;
        int y = 0;
        for(int i = 0; i < dots.length; i++) {
            for(int j = i; j < dots.length; j++) {
                if(dots[i][0] != dots[j][0]) {
                    x = Math.abs(dots[i][0] - dots[j][0]);
                }
                if(dots[i][1] != dots[j][1]) {
                    y = Math.abs(dots[i][1] - dots[j][1]);
                }
            }
        }
        
        return x * y;
    }
}
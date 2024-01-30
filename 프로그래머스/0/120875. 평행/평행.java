import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        double x1 = dots[1][0] - dots[0][0];
        double y1 = dots[1][1] - dots[0][1];
        double x2 = dots[3][0] - dots[2][0];
        double y2 = dots[3][1] - dots[2][1];
        if(y2/x2 == y1/x1) return 1;
        
        x1 = dots[2][0] - dots[0][0];
        y1 = dots[2][1] - dots[0][1];
        x2 = dots[3][0] - dots[1][0];
        y2 = dots[3][1] - dots[1][1];
        
        if(y2/x2 == y1/x1) return 1;
        
        x1 = dots[3][0] - dots[0][0];
        y1 = dots[3][1] - dots[0][1];
        x2 = dots[2][0] - dots[1][0];
        y2 = dots[2][1] - dots[1][1];
        
        if(y2/x2 == y1/x1) return 1;
            
        return 0;
    }
}
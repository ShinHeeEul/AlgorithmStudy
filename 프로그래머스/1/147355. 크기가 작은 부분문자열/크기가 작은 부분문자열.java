import java.util.*;

class Solution {
    public int solution(String t, String p) {
        long ip = Long.parseLong(p);
        int pl = p.length();
        int cnt = 0;
        
        for(int i = 0; i + pl <= t.length(); i++) {
            if(ip >= Long.parseLong(t.substring(i, i + pl))) cnt++;
        }
        
        return cnt;
    }
}
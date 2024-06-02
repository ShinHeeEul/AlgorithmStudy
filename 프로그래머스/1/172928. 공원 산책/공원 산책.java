import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] start = new int[2];
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    start = new int[] {i,j};
                    break;
                }
            }
        }
        for(int i = 0; i < routes.length; i++) {
            String s = routes[i];
            char dir = s.charAt(0);
            int cnt = Integer.parseInt(s.charAt(2) + "");
            int[] tmp = start.clone();
            boolean b = true;
                for(int j = 0; j < cnt; j++) {
                    switch(dir) {
                        case 'E':
                            if(start[1] + 1 >= park[0].length()) {
                                b = false;
                                break;
                            }
                            if(park[start[0]].charAt(start[1] + 1) == 'X') {
                                b = false;
                                    break;
                                }
                            start[1]++;
                            break;
                        case 'W':
                            if(start[1] - 1 < 0) {
                                b = false;
                               break;
                            }
                             if(park[start[0]].charAt(start[1] - 1) == 'X') {
                                 b = false;
                                    break;
                                }
                            start[1]--;
                            break;
                        case 'S':
                            if(start[0] + 1 >= park.length) {
                                b = false;
                                break;
                            }
                            if(park[start[0] + 1].charAt(start[1]) == 'X') {
                                b = false;
                                    break;
                                }
                            start[0]++;
                            break;
                        case 'N':
                            
                            if(start[0] - 1 < 0) {
                                b = false;
                                break;
                            }
                            if(park[start[0] - 1].charAt(start[1]) == 'X') {
                                b = false;
                                    break;
                                }
                            start[0]--;
                            break;
                    }
                    if(!b) {
                        start = tmp.clone();
                            break;
                    }
                }
            
        }
        
        return start;
    }
}
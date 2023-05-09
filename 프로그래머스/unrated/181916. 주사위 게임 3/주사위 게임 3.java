import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 1;
        int[] check = new int[6];
        
        check[a-1]++;
        check[b-1]++;
        check[c-1]++;
        check[d-1]++;
        
        for(int i =check.length-1; i >= 0; i--) {
            int k = check[i];
            if(k == 4) {
                answer = 1111 * (i + 1); break;
            }
            else if(k == 3) {
                for(int j = 0; j < check.length; j++) {
                        if(check[j] == 1) {
                            answer = ((10 * (i+1)) + j+ 1) * ((10 * (i+1)) + j + 1);
                            break;
                        }
                    }
                break;
            }
            else if(k == 2) {
                answer = 1;
                for(int j = 0; j < check.length; j++) {
                    if((check[j] == 2) && (j != i)) {
                        answer = (i + 1 + j + 1) * Math.abs(i-j);
                        break;
                    }
                    if(check[j] == 1) {
                        answer = answer * (j+1);
                    }
                }
                break;
            }
            else if(k == 1) {
                answer = i+1;
                
            }
        }
        return answer;
    }
}
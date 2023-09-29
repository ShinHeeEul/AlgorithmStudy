import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int a = arr.length;
        int b = arr[0].length;
        int big = a > b ? a : b;
        
        int[][] answer = new int[big][big];
        if(b > a) {
            for(int i = 0; i < a; i++) {
                for(int j = 0; j < b; j++) {
                    if(j >= b) {
                        answer[i][j] = 0;
                        continue;
                    }
                    answer[i][j] = arr[i][j];
                }
            }
        } else if(b < a) {
            for(int i = 0; i < a; i++) {
                for(int j = 0; j < b; j++) {
                    if(i >= a) {
                        answer[i][j] = 0;
                        continue;
                    }
                    answer[i][j] = arr[i][j];
                }
            }
        }
        
        else {
            return arr;
        }
        return answer;
    }
}
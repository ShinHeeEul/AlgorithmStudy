import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int k = 0;
        Queue<Integer>[] stack = new LinkedList[board[0].length + 1];
        
        Stack<Integer> answer = new Stack();
        
        for(int i = 1; i <= board[0].length; i++) {
            stack[i] = new LinkedList();
            for(int j = 0; j < board.length; j++) {
                int doll = board[j][i-1];
                
                if(doll != 0) {
                    stack[i].add(doll);
                }
            }
        }
        
        for(int move : moves) {
            
            if(stack[move].isEmpty()) {
                continue;
            }
            
            int a = stack[move].poll();
            
            if(!answer.isEmpty()) {
                if(a == answer.peek()) {
                    answer.pop();
                    k+= 2;
                    continue;
                }
            }
            answer.push(a);
        }
        return k;
    }
}
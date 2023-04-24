import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        
        for(int i = 0 ; i < visit.length; i++) {
            if(!visit[i]) {
                answer++;
                Stack<Integer> stack = new Stack();
                stack.add(i);
                while(!stack.isEmpty()) {
                    int current = stack.pop();
                    visit[current] = true;
                    for(int j = 0; j < computers[current].length; j++) {
                        if(computers[current][j] == 1) {
                                if(!visit[j]) stack.push(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
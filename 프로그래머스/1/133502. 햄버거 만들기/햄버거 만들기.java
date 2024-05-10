import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        String s = "";
        Stack<Integer> stack = new Stack<>();
        
        for(int ing : ingredient) {
            Stack<Integer> tmp = new Stack<>();
            if(ing == 1) {
                if(stack.size() >= 3) {
                    if(stack.peek() == 3) {
                        tmp.push(stack.pop());
                        if(stack.peek() == 2) {
                            tmp.push(stack.pop());
                            if(stack.peek() == 1) {
                                stack.pop();
                                answer++;
                                continue;
                            }
                        }
                    }
                    while(!tmp.isEmpty()) stack.push(tmp.pop());
                }
            }
            stack.add(ing);
        }
        
        return answer;
    }
}
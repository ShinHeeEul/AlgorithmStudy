import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();
        
        for(char c : s.toCharArray()) {
            switch(c) {
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    stack.pop();
                    break;
                    
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
}
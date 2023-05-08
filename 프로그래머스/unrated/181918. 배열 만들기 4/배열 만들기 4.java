import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < arr.length; i++) {
            if(stack.size() == 0) {
                stack.push(arr[i]);
                continue;
            }
            int pop = stack.peek();
            if(pop < arr[i]) stack.push(arr[i]);
            else {
                stack.pop();
                i--;
            }
        }
        ArrayList<Integer> stk = new ArrayList(stack);
        return stk;
    }
}
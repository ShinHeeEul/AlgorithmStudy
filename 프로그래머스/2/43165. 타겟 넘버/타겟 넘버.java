import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Stack<Node> stack = new Stack();
        
        stack.push(new Node(numbers[0],0));
        stack.push(new Node(-numbers[0],0));
        
        while(!stack.isEmpty()) {
            Node n = stack.pop();
            if(n.index == numbers.length-1) {
                if(target == n.val) answer++;
                continue;
            }
            stack.push(new Node(n.val + numbers[n.index+1], n.index+1));
            stack.push(new Node(n.val - numbers[n.index+1], n.index+1));
        }
        
        return answer;
    }
    
    class Node {
        int val;
        int index;
        
        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}

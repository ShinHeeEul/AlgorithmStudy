import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        for(int priority : priorities) {
            queue.add(new Node(i++, priority));
            pq.add(priority);
        }
        
        int count = 1;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.priority == pq.peek()) {
                if(n.index == location) {
                    return count;
                }
                count++;
                pq.poll();
                continue;
            }
            queue.add(n);
        }
        return -1;
    }
    
    public static class Node {
        int index;
        int priority;
        
        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
import java.util.*;
class Solution {
    static ArrayDeque<Integer> queue;
    public int[] solution(String[] operations) {
        int[] answer = {};
        queue = new ArrayDeque<>();
        
        for(String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String oper = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")) {
                queue.add(val);
                Integer[] test = queue.toArray(new Integer[0]);
                Arrays.sort(test);
                queue = new ArrayDeque<>();
                for(Integer te : test) {
                    queue.add(te);
                }
                continue;
            }
            if(queue.size() == 0) continue;
            if(val < 0) {
                queue.pollFirst();
            } else {
                queue.pollLast();
            }
        }
        return queue.size() == 0 ? new int[] {0,0} : new int[] {queue.getLast(), queue.getFirst()};
    }
}
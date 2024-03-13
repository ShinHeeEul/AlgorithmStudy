import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        queue.add(arr[0]);
        
        int b = arr[0];
        for(int a : arr) {
            if(b != a) {
                queue.add(a);
                b = a;
            }
        }
        while(!queue.isEmpty()) list.add(queue.poll());
        
        return list;
    }
}
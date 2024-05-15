import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int k, int[] score) {
        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
       for(int i : score) {
           pq.add(i);
           int size = pq.size();
           
           ArrayList<Integer> li = new ArrayList<>();
           if(size < k) {
               while(pq.size() > 1) {
                   li.add(pq.poll());
               }
               answer.add(pq.peek());
               for(int a : li) {
                   pq.add(a);
               }
               continue;
           }
            for(int a = 1; a < k; a++) {
                   li.add(pq.poll());
              }
           answer.add(pq.peek());
           for(int a : li) {
                   pq.add(a);
               }
       }
        return answer;
    }
}
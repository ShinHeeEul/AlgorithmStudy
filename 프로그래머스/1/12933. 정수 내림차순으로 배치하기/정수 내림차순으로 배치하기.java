import java.util.*;

class Solution {
    public long solution(long n) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(n != 0) {
            pq.add(n % 10);
            n /= 10;
        }
        while(!pq.isEmpty()) {
            n *= 10;
            n += pq.poll();
        }
        return n;
    }
}
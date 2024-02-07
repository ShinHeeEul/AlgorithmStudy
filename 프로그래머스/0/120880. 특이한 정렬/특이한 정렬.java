import java.util.*;
import java.lang.*;

class Solution {
    int N;
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        N = n;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i : numlist) {
            pq.add(new Node(i));
        }
        
        for(int i = 0; !pq.isEmpty(); i++) {
            Node nn = pq.poll();
            answer[i] = nn.i;
        }
        return answer;
    }
    
    public class Node implements Comparable<Node>{
        int i;
        public Node(int i) {
            this.i = i;
        }
        public int compareTo(Node n) {
            int a = Math.abs(N - n.i);
            int b = Math.abs(N - this.i);
            if(a == b) {
                return n.i - this.i;
            }
            return b - a;
        }
    }
}
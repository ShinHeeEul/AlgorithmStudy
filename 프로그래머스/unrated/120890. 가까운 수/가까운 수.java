import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Node[] arr = new Node[array.length];
        for(int i = 0; i < array.length; i++) {
            arr[i] = new Node(i, array[i], Math.abs(array[i] - n));
        }
        
        Arrays.sort(arr, Comparator.reverseOrder());
        
        return arr[0].realValue;
    }
    
    static class Node implements Comparable<Node> {
        int index;
        int realValue;
        int value;
        
        public Node(int index, int realValue, int value) {
            this.index = index;
            this.realValue = realValue;
            this.value = value;
        }
        
        public int compareTo(Node n) {
            if(n.value == this.value) {
                return n.realValue - this.realValue;
            }
            return n.value - this.value;
        }
    }
}
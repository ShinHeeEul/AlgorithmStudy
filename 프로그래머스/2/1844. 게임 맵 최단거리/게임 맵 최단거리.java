import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        Queue<Node> stack = new LinkedList<>();
        stack.add(new Node(0,0,1));
        
        while(!stack.isEmpty()) {
            Node n = stack.poll();
            if((n.x == maps.length-1) && (n.y == maps[0].length-1)) {
                return n.count;    
            }
            int current_x;
            int current_y;
            if(n.x > 0) {
                current_x = n.x-1;
                current_y = n.y;
                    if(maps[current_x][current_y] == 1) {
                        stack.add(new Node(current_x,current_y,n.count+1));
                        maps[current_x][current_y] = 0;
                    }
                
            } 
            if(n.y > 0) {
                current_x = n.x;
                current_y = n.y-1;
                    if(maps[current_x][current_y] == 1) {
                        stack.add(new Node(current_x,current_y,n.count+1));
                        maps[current_x][current_y] = 0;
                    }
            } 
            if(n.x < maps.length-1) {
                current_x = n.x+1;
                current_y = n.y;
                    if(maps[current_x][current_y] == 1) {
                        stack.add(new Node(current_x,current_y,n.count+1));
                        maps[current_x][current_y] = 0;
                    }
            } 
            if(n.y < maps[0].length-1) {
                current_x = n.x;
                current_y = n.y+1;
                    if(maps[current_x][current_y] == 1) {
                        stack.add(new Node(current_x,current_y,n.count+1));
                        maps[current_x][current_y] = 0;
                    }
            }
        }
        return -1;
    }
    
    class Node {
        int x;
        int y;
        int count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
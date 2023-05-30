import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> arr = new ArrayList();
        
        for(int i = 0; i < todo_list.length; i++)
            if(!finished[i]) arr.add(todo_list[i]);
        
        return arr;
    }
}
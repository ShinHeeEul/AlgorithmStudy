import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int j = 0; j < commands.length; j++) { 
            ArrayList<Integer> tmp = new ArrayList<>();
        
            for(int i = 0; i < array.length; i++) {
                if((i +1 >= commands[j][0]) && (i+1 <= commands[j][1])) tmp.add(array[i]);
            }
            Collections.sort(tmp);
            answer.add(tmp.get(commands[j][2]-1));
        }
        
        
        return answer;
    }
}
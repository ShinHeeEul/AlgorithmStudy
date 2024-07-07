//import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        /*for(int i = 0; i < participant.length; i++) {
            for(int j = 0; j < completion.length; j++) {
                
                    //System.out.println(Arrays.toString(completion));
                if(participant[i].equals(completion[j])) {
                    
                    //System.out.println(completion[j]);
                    completion[j] = null;
                    break;
                }
                else if(j == completion.length-1) {
                    answer = participant[i];
                }
            }
            
        }*/
        
        HashMap<String, Integer>  map = new HashMap<>();
        ArrayList<String> exc = new ArrayList<>();
        for(int i = 0; i < completion.length; i++) {
            if(map.get(completion[i]) == null)
                map.put(completion[i],i);
            else
                exc.add(completion[i]);
        }
        
        for(int i = 0; i< participant.length; i++) {
            if((map.get(participant[i]) == null)) {
                if(exc.contains(participant[i])) {
                    exc.remove(participant[i]);
                    continue;
                    }
                return participant[i];
            }
            
            map.remove(participant[i]);
            
            
            
        }
        return answer;
    }
}
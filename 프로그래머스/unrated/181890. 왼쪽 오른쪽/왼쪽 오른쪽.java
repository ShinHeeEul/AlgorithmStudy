import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] str_list) {
        ArrayList<String> answer = new ArrayList();
        
        boolean b = false;
        for(String s : str_list) {
            if(!b) {
                
                if(s.equals("l"))
                    return answer;
                
                else if(s.equals("r")) {
                    b = true;
                    answer = new ArrayList();
                    continue;
                }
                    
            }
            
            answer.add(s);
            
        }
        if(!b) return new ArrayList<String>();
        return answer;
    }
}
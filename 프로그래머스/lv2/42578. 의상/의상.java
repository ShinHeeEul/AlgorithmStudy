import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1],map.get(clothes[i][1]) + 1);
            else map.put(clothes[i][1],1);
        }
        Iterator it = map.entrySet().iterator();
        
        while(it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            System.out.println(ent);
            answer *= ((Integer) ent.getValue()+1);
        }
        answer -= 1;
        return answer;
    }
}
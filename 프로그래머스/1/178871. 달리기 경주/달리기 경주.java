import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> list = new HashMap<>();
        for(int i = 0;i < players.length; i++) {
            list.put(players[i], i);
        }
        for(String S : callings) {
            int index = list.get(S);
            list.put(S, index-1);
            list.put(players[index-1], index);
            players[index] = players[index-1];
            players[index-1] = S;
        }
        
        return players;
    }
}
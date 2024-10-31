import java.util.*;

class Solution {
    Map<Integer, Integer> ins = new HashMap<>();
    Map<Integer, Integer> outs = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    
    public int[] solution(int[][] edges) {
        int[] answer = {};
        
        for(int i = 0; i < edges.length; i++) {
            set.add(edges[i][0]);
            set.add(edges[i][1]);
            ins.put(edges[i][1], ins.getOrDefault(edges[i][1], 0) + 1);
            outs.put(edges[i][0], outs.getOrDefault(edges[i][0], 0) + 1);
        }
        
        int start = 0;
        int outLine =0 ;
        int eight = 0;
        int line = 0;

        for(int s : set) {
            int in = ins.getOrDefault(s, 0);
            int out = outs.getOrDefault(s, 0);
            if(in == 0 && out > 1) {
                start = s;
                outLine = out;
            }
            else if(out == 2) {
                eight++;
            }
            else if(out == 0){
                line++;
            }
        }
        
        return new int[] {start, outLine - (eight + line), line, eight};
    }
}
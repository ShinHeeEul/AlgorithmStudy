import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> idMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }
        Set<String> reportSet = new HashSet<>();
        // 신고당한 사람, 신고한 사람
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String rep : reports) {
            reportSet.add(rep);
        }
        
        for(String report : reportSet.toArray(new String[0])) {
            StringTokenizer st = new StringTokenizer(report);
            
            String a = st.nextToken();
            String b = st.nextToken();
            ArrayList list = map.getOrDefault(b, new ArrayList<>());
            list.add(a);
            map.put(b, list);
            
        }
        
        for(String key : map.keySet()) {
            List<String> list = map.get(key);
            if(list.size() >= k) {
                for(String li : list) {
                    answer[idMap.get(li)]++;
                }
            }
        }
        
        return answer;
    }
}
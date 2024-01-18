import java.util.*;

class Solution {
    public ArrayList<String> solution(String my_str, int n) {
        ArrayList<String> list = new ArrayList();
        String s = "";
        int count = 0;
        for(char c : my_str.toCharArray()) {
            s += c;
            count++;
            if(count == n) {
                list.add(s);
                s = "";
                count = 0;
            }
        }
        if(!s.equals("")) {
            list.add(s);
        }
        return list;
    }
}
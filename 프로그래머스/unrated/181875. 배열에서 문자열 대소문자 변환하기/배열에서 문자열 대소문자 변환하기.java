import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] strArr) {
        ArrayList<String> arr = new ArrayList();
        
        for(int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            String tmp = "";
            for(char c : s.toCharArray()) {
                if(i % 2 !=0) {
                    if(c >= 'a') {
                        c -= 'a';
                        c += 'A';
                    }
                }
                else {
                    if(c < 'a') {
                        c -= 'A';
                        c += 'a';
                    }
                }
                tmp += c;
            }
            arr.add(tmp);
        }
        return arr;
    }
}
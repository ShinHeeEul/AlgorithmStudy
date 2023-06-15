import java.util.*;

class Solution {
    public ArrayList<String> solution(String myStr) {
        ArrayList<String> arr = new ArrayList();
        arr.add(myStr); 
        ArrayList<String> ans = func("a", arr);
        ArrayList<String> ans2 = func("b", ans);
        ArrayList<String> ans3 = func("c",ans2);
        if(ans3.isEmpty())ans3.add("EMPTY");
        
        return ans3;
    }
    
    public static ArrayList<String> func(String s, ArrayList<String> arr) {
        ArrayList<String> ans = new ArrayList();
        
        for(String ss : arr) {
            StringTokenizer st1 = new StringTokenizer(ss,s);
            while(st1.hasMoreTokens()) ans.add(st1.nextToken());
        }
        
        return ans;
    }
}
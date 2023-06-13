import java.util.*;
class Solution {
    public ArrayList<String> solution(String myString) {
        ArrayList<String> answer = new ArrayList();
        StringTokenizer st = new StringTokenizer(myString,"x");
        while(st.hasMoreTokens())
            answer.add(st.nextToken());
        Collections.sort(answer);
        return answer;
    }
}
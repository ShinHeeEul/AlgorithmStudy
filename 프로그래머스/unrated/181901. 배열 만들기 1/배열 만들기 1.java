import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int n, int k) {
        ArrayList<Integer> answer = new ArrayList();
        for(int i = k; i <= n; i+=k)
            answer.add(i);
        return answer;
    }
}
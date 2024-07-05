import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int size = people.length;
        boolean[] visited = new boolean[size];
        Arrays.sort(people);
        int start = 0;
        for(int i = size-1; i >= start; i--) {
            if(people[start] + people[i] <= limit) {
                answer++;
                visited[i] = true;
                visited[start] = true;
                start++;
            }
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) answer++;
        }

        return answer;
    }
}
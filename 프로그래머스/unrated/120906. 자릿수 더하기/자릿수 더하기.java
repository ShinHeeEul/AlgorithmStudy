class Solution {
    public int solution(int n) {
        String s = n + "";
        int answer = 0;
        
        for(char c : s.toCharArray()) {
            answer += Integer.parseInt(c + "");
        }
        
        return answer;
    }
}
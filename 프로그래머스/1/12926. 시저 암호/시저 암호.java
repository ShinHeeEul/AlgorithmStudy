class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                answer += ' ';
                continue;
            }
            int a = c + n;
            if((a > 90 && c <= 90) || (a > 122)) {
                a -= 26;
            }
            answer += (char) a;
        }
        return answer;
    }
}
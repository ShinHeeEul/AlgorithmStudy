class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] ss = s.split(" ");
        
        int i = 0;
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                i = 0;
                answer += c;
                continue;
            }
            
            if(i % 2 != 0) answer += (c + "").toLowerCase();
            else answer += (c + "").toUpperCase();
            i++;
            
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String rny_string) {
        String answer = "";
        for(char c : rny_string.toCharArray()) {
            if(c == 'm') {
                answer += "rn";
                continue;
            }
            answer += c;
        }
        return answer;
    }
}
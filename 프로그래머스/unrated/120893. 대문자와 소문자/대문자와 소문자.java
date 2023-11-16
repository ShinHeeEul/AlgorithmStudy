class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char c : my_string.toCharArray()) {
            if(c <= 'Z') {
                c -= 'A';
                c += 'a';
            } else if(c >= 'a') {
                c -= 'a';
                c += 'A';
            }
            answer += c;
        }
        return answer;
    }
}
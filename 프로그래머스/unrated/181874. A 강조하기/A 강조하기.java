class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char c : myString.toCharArray()) {
            if(c == 'a') c = 'A';
            else if((c > 'A') && (c <= 'Z')) {
                c -= 'A';
                c += 'a';
            }
            answer += c;
        }
        return answer;
    }
}
class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char c : myString.toCharArray()) {
            if(c < 'a') {
                c -= 'A';
                c += 'a';
            } 
            answer += c;
        }
        return answer;
    }
}
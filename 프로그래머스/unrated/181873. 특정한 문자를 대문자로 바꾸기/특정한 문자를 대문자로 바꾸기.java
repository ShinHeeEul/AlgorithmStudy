class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for(char c : my_string.toCharArray()) {
            if(alp.equals(c + "")) {
                c -= 'a';
                c += 'A';
            }
            answer += c;
        }
        return answer;
    }
}
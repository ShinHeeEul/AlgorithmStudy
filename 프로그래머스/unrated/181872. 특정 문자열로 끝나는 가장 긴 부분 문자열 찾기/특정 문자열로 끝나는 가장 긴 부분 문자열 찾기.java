class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        String ans = "";
        for(char c : myString.toCharArray()) {
            answer += c;
            if(answer.length() - pat.length() < 0) continue;
            String sub = answer.substring(answer.length() - pat.length(),
                                         answer.length());
            if(sub.equals(pat)) ans = answer;
        }
        return ans;
    }
}
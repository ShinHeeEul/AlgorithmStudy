class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        for(int i = 0; i < length; i++) {
            if(i < length - 4) {
                answer += "*";
            } else {
                answer += phone_number.charAt(i);
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int tmp = 0;
        for(char c : my_string.toCharArray()) {
            if(c >= '0' && c <= '9') {
                tmp *= 10;
                tmp += Integer.parseInt(c + "");
            } else {
                answer += tmp;
                tmp = 0;
            }
        }
        answer += tmp;
        return answer;
    }
}
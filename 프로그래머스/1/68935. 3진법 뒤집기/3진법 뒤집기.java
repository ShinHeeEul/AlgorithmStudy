class Solution {
    public int solution(int n) {
        int answer = 0;
        String s= "";
        
        while (n >= 3) {
            s += n % 3;
            n /= 3;
        }
        s += n;
        for(int i = 0; i < s.length(); i++) {
            answer *= 3;
            answer += Integer.parseInt(s.charAt(i) + "");
        }
        
        return answer;
    }
}
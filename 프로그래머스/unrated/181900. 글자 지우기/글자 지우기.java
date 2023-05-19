class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            boolean b = false;
            for(int j : indices) {
                if(i == j) {
                    b = true;
                    break;
                }
            }
            if(b) continue;
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
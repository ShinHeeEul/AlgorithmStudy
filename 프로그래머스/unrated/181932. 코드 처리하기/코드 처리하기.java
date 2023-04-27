class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        char[] arr = code.toCharArray();
        for(int i = 0; i < code.length(); i++) {
            if(mode == 0) {
                
                if(arr[i] == '1')  {
                    mode = 1;
                    continue;
                }
                if(i % 2 == 0) answer += arr[i];
            }
            else if(mode == 1) {
                if(arr[i] == '1') {
                    mode = 0;
                    continue;
                }
                
                if(i % 2 != 0) answer += arr[i];  
            }
        }
        return answer.equals("")?"EMPTY":answer;
    }
}
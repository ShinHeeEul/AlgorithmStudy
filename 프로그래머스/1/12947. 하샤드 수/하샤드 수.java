class Solution {
    public boolean solution(int x) {
        int answer = 0;
        String s = x + "";
        for(char c : s.toCharArray()) {
            answer += Integer.parseInt(c + "");
        }
        return x%answer==0?true:false;
    }
}
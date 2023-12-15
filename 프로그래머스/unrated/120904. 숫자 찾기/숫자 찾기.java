class Solution {
    public int solution(int num, int k) {
        String s = num + "";
        for(int i = 0; i < s.length(); i++) {
            int tt =  Integer.parseInt(s.charAt(i) + "");
            
            if(tt == k) {
                return i+1;
            }
        }
        
        return -1;
    }
}
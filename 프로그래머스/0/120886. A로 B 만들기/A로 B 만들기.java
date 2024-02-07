class Solution {
    public int solution(String before, String after) {
        String s = "";
        int a = 0;
        int b = 0;
        for(char c : before.toCharArray()) a += c;
        for(char c : after.toCharArray()) b += c;
        
        if(a == b) return 1;
        
        return 0;
    }
}
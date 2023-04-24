class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.parseInt(a + "" + b);
        int ba = Integer.parseInt(b + "" + a);
        
        if(ab < ba) return ba;
        
        return ab;
    }
}
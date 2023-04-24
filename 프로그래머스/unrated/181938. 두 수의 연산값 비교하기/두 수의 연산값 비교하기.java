class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.parseInt(a + "" + b);
        int ab2 = 2 * a * b;
        
        if(ab > ab2) return ab;
        return ab2;
    }
}
class Solution {
    public int solution(int n, int m, int[] section) {
        
        int current = 0;
        int count = 0;
        for(int sec : section) {
            if(current < sec) {
                current = sec + m - 1;
                count++;
            }     
        }
        return count;
    }
}
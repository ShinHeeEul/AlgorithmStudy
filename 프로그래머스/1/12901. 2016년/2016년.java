class Solution {
    public String solution(int a, int b) {
        String[] dow = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] med = {31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 0;
        for(int i = 0; i < a-1; i++) {
            day += med[i];
        }
        day += b;
        return dow[(4 + day) % 7];
    }
}
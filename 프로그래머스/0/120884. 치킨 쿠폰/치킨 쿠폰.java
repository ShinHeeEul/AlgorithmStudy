class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(chicken > 9) {
            int chick = chicken / 10;
            answer += chick;
            chicken = chick + chicken % 10;
        }
        return answer;
    }
}
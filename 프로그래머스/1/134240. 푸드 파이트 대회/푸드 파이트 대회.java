class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i = food.length - 1; i > 0; i--) {
            while(food[i] / 2 != 0) {
                answer = i + answer + i;
                food[i] -= 2;
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int multi = 1;
        for(int i : num_list) {
            multi *= i;
            answer += i;
        }
        if(multi < (answer * answer)) return 1;
        else if(multi > (answer * answer)) return 0;
        return answer;
    }
}
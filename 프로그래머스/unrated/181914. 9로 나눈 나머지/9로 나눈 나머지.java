class Solution {
    public int solution(String number) {
        int sum = 0;
        for(char c : number.toCharArray()) {
            int i = Integer.parseInt(c + "");
            sum += i;
        }
        int answer = sum % 9;
        return answer;
    }
}
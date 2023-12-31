class Solution {
    public int solution(String my_string) {
        String[] regex = my_string.split(" ");
        int answer = Integer.parseInt(regex[0]);
        for(int i = 1; i < regex.length; i++) {
            String a = regex[i];
            if(a.equals("+")) {
                answer += Integer.parseInt(regex[i+1]);
            } else if(a.equals("-")) {
                answer -= Integer.parseInt(regex[i+1]);
            }
        }
        return answer;
    }
}
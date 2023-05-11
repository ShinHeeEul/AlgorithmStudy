class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        char[] c = my_string.toCharArray();
        
        for(int i : index_list) {
            answer += c[i];
        }
        return answer;
    }
}
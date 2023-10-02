class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for(int i = 0; i < str_list.length; i++) {
            boolean b = true;
            String s = str_list[i];
            if(!s.contains(ex)) {
                answer += s;
            }
        }
        return answer;
    }
}
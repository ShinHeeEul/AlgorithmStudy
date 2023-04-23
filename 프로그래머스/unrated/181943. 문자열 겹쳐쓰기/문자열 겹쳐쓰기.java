class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] c = my_string.toCharArray();
        char[] o = overwrite_string.toCharArray();
        for(int i = 0; i < o.length; i++)
            c[i+s] = o[i];
        answer = new String(c);
        return answer;
    }
}
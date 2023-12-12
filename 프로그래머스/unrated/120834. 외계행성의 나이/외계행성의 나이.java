class Solution {
    public String solution(int age) {
        String s = "";
        String ss = age + "";
        for(char c : ss.toCharArray()) {
            char cc = (char) ((int)'a' + Integer.parseInt(c + ""));
            s += cc;
        }
        return s;
    }
}
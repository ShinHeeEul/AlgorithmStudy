class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        char[] myc = myString.toCharArray();
        for(int i = 0; i < myc.length - pat.length() + 1; i++) {
            String s = "";
            for(int j = i; j < i + pat.length(); j++)
                s += myc[j];
            if(s.equals(pat)) answer++;
        }
        return answer;
    }
}
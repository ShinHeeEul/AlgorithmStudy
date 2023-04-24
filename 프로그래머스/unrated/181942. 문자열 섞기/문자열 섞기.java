class Solution {
    public String solution(String str1, String str2) {
        String S = "";
        for(int i = 0;i < str1.length(); i++) {
            S +=  str1.charAt(i);
            S += str2.charAt(i);
        }
        
    return S;
    }
}
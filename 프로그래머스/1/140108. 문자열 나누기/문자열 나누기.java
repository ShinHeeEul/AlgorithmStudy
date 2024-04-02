class Solution {
    public int solution(String s) {
        int answer = 0;
        char cc = s.charAt(0);
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(cc == c) a++;
            else b++;
            if(a == b) {
                System.out.println(s.substring(0,i+1));
                s = s.substring(i+1, s.length());
                answer++;
                i = -1;
                if(s.length() == 0) break;
                cc = s.charAt(0);
            }
            
        }
        
        if(s.length() != 0) answer++;
        return answer;
    }
}
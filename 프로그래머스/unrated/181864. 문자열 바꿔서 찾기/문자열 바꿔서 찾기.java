class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String s = "";
        for(char c: pat.toCharArray()) {
            switch(c) {
                case 'A':
                    s += 'B';
                    break;
                case 'B':
                    s += 'A';
                    break;
            }
        }
        
        if(myString.contains(s)) return 1;
        return 0;
    }
}
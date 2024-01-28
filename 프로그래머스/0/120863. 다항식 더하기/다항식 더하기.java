class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int y = 0;
        String[] ss = polynomial.split(" ");
        
        for(String s : ss) {
            if(s.equals("x")) {
                x++;
            } else if(s.contains("x")) {
                x += Integer.parseInt(s.substring(0,s.length()-1));
            } else if(s.equals("+")) {
                continue;
            } else {
                y += Integer.parseInt(s);
            }
        }
        
        if(x != 0 && y != 0) {
            if(x == 1) {
                answer = "x + " + y;
            } else {
                answer = x + "x + " + y;
            }
        } else if(x != 0 && y == 0) {
            if(x == 1) {
                answer = "x";
            } else {
                answer = x + "x";
            }
        } else {
            answer = y + "";
        }
        return answer;
    }
}
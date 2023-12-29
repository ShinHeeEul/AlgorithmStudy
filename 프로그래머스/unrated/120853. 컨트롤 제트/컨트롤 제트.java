class Solution {
    public int solution(String s) {
        int answer = 0;
        int before = 0;
        
        String[] ss = s.split(" ");
        
        for(String d : ss) {
            if(d.equals("Z")) {
                answer -= before;
                continue;
            }
            answer += Integer.parseInt(d);
            before = Integer.parseInt(d);
        }
        return answer;
    }
}
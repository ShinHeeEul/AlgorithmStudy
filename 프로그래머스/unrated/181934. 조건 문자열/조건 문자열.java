class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        if(ineq.equals(">")) {
            if(eq.equals("!")) {
                if(n > m) return 1;
                return 0;
            }
            if(n >= m) return 1;
            return 0;
        }
        if(ineq.equals("<")) {
            if(eq.equals("!")) {
                if(n < m) return 1;
                return 0;
            }
            if(n <= m) return 1;
            return 0;
        }
        return answer;
    }
}
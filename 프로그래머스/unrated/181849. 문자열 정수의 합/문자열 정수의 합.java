class Solution {
    public int solution(String num_str) {
        
        int sum = 0;
        
        for(char c : num_str.toCharArray()) {
            sum += Integer.parseInt(c + "");
        }
        
        return sum;
    }
}
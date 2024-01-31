class Solution {
    public int solution(int[][] lines) {
        int[] tmp = new int[201];
        
        for(int i = 0; i < lines.length; i++) {
            for(int j = lines[i][0]; j < lines[i][1]; j++) {
                tmp[j+100]++;
            }
        }
        int answer = 0;
        for(int i = 0; i < 201; i++) {
            if(tmp[i] > 1) answer++;
        }
        return answer;
    
    }
}
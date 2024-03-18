class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int iLength = arr1.length;
        int jLength = arr1[0].length;
        int[][] answer = new int[iLength][jLength];
        
        for(int i = 0; i < iLength; i++) {
            for(int j = 0; j < jLength; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] sum = triangle;
        int max = 0;
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    sum[i][j] = sum[i-1][0] + triangle[i][j];
                }
                else if(j == triangle[i].length-1)
                    sum[i][j] = sum[i-1][sum[i-1].length-1] + triangle[i][j];
                else {
                    if(sum[i-1][j-1] > sum[i-1][j])
                        sum[i][j] = sum[i-1][j-1] + triangle[i][j];
                    else
                        sum[i][j] = sum[i-1][j] + triangle[i][j];
                }
                if (max < sum[i][j]) max = sum[i][j];
            }
        }
        return max;
    }
}
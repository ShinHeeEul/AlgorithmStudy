class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] i : queries) {
            for(int j = i[0]; j <= i[1]; j++) {
                if(j % i[2] == 0) {
                    arr[j]++;
                }
            }
        }
        return arr;
    }
}
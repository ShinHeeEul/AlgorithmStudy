class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for(int[] t :  queries) {
            for(int i = t[0]; i <= t[1]; i++) {
                arr[i]++;
            }
        }
        return arr;
    }
}
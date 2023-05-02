class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int[] qu : queries) {
            int tmp = arr[qu[0]];
            arr[qu[0]] = arr[qu[1]];
            arr[qu[1]] = tmp;
        }
        return arr;
    }
}
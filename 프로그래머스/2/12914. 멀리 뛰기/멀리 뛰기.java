class Solution {
    public long solution(int n) {
        int[] arr = new int[n+3];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n+2; i++) {
            arr[i] = arr[i-1]% 1234567 + arr[i-2]% 1234567;
            arr[i] %= 1234567;
        }
        return arr[n];
    }
}